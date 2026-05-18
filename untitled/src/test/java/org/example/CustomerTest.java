package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldAddCoupon() {
        Customer customer = new Customer("1");

        Coupon coupon = new Coupon("1234", 30);

        customer.addCoupon(coupon);

        assertEquals(1, customer.getCoupons().size());
    }

    @Test
    void shouldNotAddNullCoupon() {
        Customer customer = new Customer("1");

        customer.addCoupon(null);

        assertEquals(0, customer.getCoupons().size());
    }

    @Test
    void shouldReturnTrueWhenCouponExists() {
        Customer customer = new Customer("1");

        customer.addCoupon(new Coupon("1234", 30));

        assertTrue(customer.hasCoupon("1234"));
    }

    @Test
    void shouldReturnFalseWhenCouponUsed() {
        Customer customer = new Customer("1");

        Coupon coupon = new Coupon("1234", 30);
        coupon.setUsed(true);

        customer.addCoupon(coupon);

        assertFalse(customer.hasCoupon("1234"));
    }

    @Test
    void shouldGetCouponByCode() {
        Customer customer = new Customer("1");

        Coupon coupon = new Coupon("1234", 30);

        customer.addCoupon(coupon);

        Coupon result = customer.getCoupon("1234");

        assertEquals(coupon, result);
    }
}
