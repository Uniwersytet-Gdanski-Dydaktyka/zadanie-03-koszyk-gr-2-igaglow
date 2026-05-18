package org.example;

public class CartItem {
    private final Product product;
    private int quantity;

    private double finalPrice;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.finalPrice = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void resetPrice() {
        this.finalPrice = product.getPrice();
    }

    public double getTotalPrice() {
        return finalPrice * quantity;
    }
}
