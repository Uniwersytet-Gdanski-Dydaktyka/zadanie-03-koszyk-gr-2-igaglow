package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CouponDiscountPromotionTest {

    @Test
    void shouldApplyCouponDiscountToChosenProduct() {

        Customer customer = new Customer("1");

        Product laptop =
                new Product("001", "Laptop", 1000);

        customer.getCart().addProduct(laptop);

        customer.addCoupon(
                new Coupon("1234", 30)
        );

        CouponDiscountPromotion promotion =
                new CouponDiscountPromotion(laptop);

        promotion.apply(customer);

        CartItem item =
                customer.getCart().getItems().get(0);

        assertEquals(
                700,
                item.getFinalPrice()
        );
    }

    @Test
    void shouldMarkCouponAsUsed() {

        Customer customer = new Customer("1");

        Product laptop =
                new Product("001", "Laptop", 1000);

        customer.getCart().addProduct(laptop);

        Coupon coupon =
                new Coupon("1234", 30);

        customer.addCoupon(coupon);

        CouponDiscountPromotion promotion =
                new CouponDiscountPromotion(laptop);

        promotion.apply(customer);

        assertTrue(coupon.isUsed());
    }

    @Test
    void shouldDoNothingWhenCouponDoesNotExist() {

        Customer customer = new Customer("1");

        Product laptop =
                new Product("001", "Laptop", 1000);

        customer.getCart().addProduct(laptop);

        CouponDiscountPromotion promotion =
                new CouponDiscountPromotion(laptop);

        promotion.apply(customer);

        CartItem item =
                customer.getCart().getItems().get(0);

        assertEquals(
                1000,
                item.getFinalPrice()
        );
    }
}