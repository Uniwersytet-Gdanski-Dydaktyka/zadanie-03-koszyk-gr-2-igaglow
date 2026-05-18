package org.example;

public class FreeMugPromotion implements Promotion{

    @Override
    public void apply(Customer customer) {

        Cart cart = customer.getCart();

        boolean hasMug = cart.getItems().stream().anyMatch(i -> i.getProduct().getCode().equals("000"));

        if (cart.getTotal() > 200 && !hasMug) {
            cart.addProduct(new Product("000", "Free mug", 0.0));
        }
    }
}
