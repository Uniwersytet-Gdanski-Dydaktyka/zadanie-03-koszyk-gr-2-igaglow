package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CouponPromotionTest {

    @Test
    void shouldAddCouponWhenCustomerDoesNotHaveIt() {
        Customer customer = new Customer("1");

        CouponPromotion promotion = new CouponPromotion();

        promotion.apply(customer);

        assertTrue(customer.hasCoupon("1234"));
    }

    @Test
    void shouldNotAddDuplicateCoupon() {
        Customer customer = new Customer("1");

        customer.addCoupon(new Coupon("1234", 30));

        CouponPromotion promotion = new CouponPromotion();

        promotion.apply(customer);

        assertEquals(1, customer.getCoupons().size());
    }
}
