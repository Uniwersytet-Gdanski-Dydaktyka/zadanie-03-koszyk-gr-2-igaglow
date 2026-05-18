package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String id;

    private final Cart cart;

    private final List<Coupon> coupons;

    public Customer(String id) {

        this.id = id;

        this.cart = new Cart();

        this.coupons = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public Cart getCart() {
        return cart;
    }

    public void addCoupon(Coupon coupon) {

        if(coupon != null) {
            coupons.add(coupon);
        }
    }

    public boolean hasCoupon(String code) {

        for(Coupon coupon : coupons) {

            if(coupon.getCode().equals(code) && !coupon.isUsed()) {

                return true;
            }
        }

        return false;
    }

    public Coupon getCoupon(String code) {

        for(Coupon coupon : coupons) {

            if(coupon.getCode().equals(code) && !coupon.isUsed()) {

                return coupon;
            }
        }

        return null;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }
}
