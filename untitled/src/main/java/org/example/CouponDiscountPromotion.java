package org.example;

import java.util.List;

public class CouponDiscountPromotion implements Promotion{
    private Product chosenProduct;

    public CouponDiscountPromotion(Product chosenProduct) {
        this.chosenProduct = chosenProduct;
    }

    @Override
    public void apply(Customer customer) {

        Coupon coupon = customer.getCoupon("1234");

        if (coupon == null) {
            return;
        }

        Cart cart = customer.getCart();

        for (CartItem item : cart.getItems()) {

            if (item.getProduct().getCode().equals(chosenProduct.getCode())) {

                double discountedPrice = item.getFinalPrice() * (1 - coupon.getDiscountPercent() / 100);

                item.setFinalPrice(discountedPrice);

                coupon.setUsed(true);

                return;
            }
        }
    }
}
