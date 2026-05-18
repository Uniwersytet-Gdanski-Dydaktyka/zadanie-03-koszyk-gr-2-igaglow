package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Buy2Get1Promotion implements Promotion{
    @Override
    public void apply(Customer customer) {

        Cart cart = customer.getCart();

        List<CartItem> expandedItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {

            for (int i = 0; i < item.getQuantity(); i++) {
                expandedItems.add(item);
            }
        }

        if (expandedItems.size() < 3) {
            return;
        }

        expandedItems.sort(Comparator.comparing(i -> i.getProduct().getPrice()));

        int freeProductsCount = expandedItems.size() / 3;

        for (int i = 0; i < freeProductsCount; i++) {
            expandedItems.get(i).setFinalPrice(0.0);
        }
    }
}
