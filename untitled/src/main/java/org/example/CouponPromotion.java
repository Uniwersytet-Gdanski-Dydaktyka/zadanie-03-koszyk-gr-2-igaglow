package org.example;

import java.util.List;

public class CouponPromotion implements Promotion{
    @Override
    public void apply(Customer customer) {
        if (!customer.hasCoupon("1234")) {
            Coupon coupon = new Coupon("1234", 30);
            customer.addCoupon(coupon);
        }
    }
}
