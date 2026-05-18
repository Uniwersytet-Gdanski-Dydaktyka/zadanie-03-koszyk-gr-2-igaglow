package org.example;

import java.util.List;

public class PercentageDiscountPromotion implements Promotion{
    @Override
    public void apply(Customer customer) {

        Cart cart = customer.getCart();

        if (cart.getTotal() > 300) {

            for (CartItem item : cart.getItems()) {
                item.setFinalPrice((item.getFinalPrice() * 95) / 100);
            }
        }
    }
}
