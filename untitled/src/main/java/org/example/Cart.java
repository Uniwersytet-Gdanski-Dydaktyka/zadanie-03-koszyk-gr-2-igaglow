package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private final List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product) {

        if (product == null) {
            return;
        }

        for (CartItem item : items) {

            if (item.getProduct().getCode().equals(product.getCode())) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }

        items.add(new CartItem(product, 1));
    }

    public void removeProduct(Product product) {

        CartItem foundItem = null;

        for (CartItem item : items) {

            if (item.getProduct().getCode().equals(product.getCode())) {

                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                } else {
                    foundItem = item;
                }

                break;
            }
        }

        if (foundItem != null) {
            items.remove(foundItem);
        }
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double getTotal() {

        double total = 0;

        for (CartItem item : items) {
            total += item.getTotalPrice();
        }

        return total;
    }

}
