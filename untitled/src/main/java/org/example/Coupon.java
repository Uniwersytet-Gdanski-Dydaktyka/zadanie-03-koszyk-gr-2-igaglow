package org.example;

public class Coupon {

    private final String code;
    private final double discountPercent;

    private boolean used;

    public Coupon(String code, double discountPercent) {
        this.code = code;
        this.discountPercent = discountPercent;
        this.used = false;
    }

    public String getCode() {
        return code;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
