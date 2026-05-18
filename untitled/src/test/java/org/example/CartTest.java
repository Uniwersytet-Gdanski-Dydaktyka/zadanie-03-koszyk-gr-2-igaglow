package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void shouldAddProductToCart() {

        Cart cart = new Cart();

        Product product =
                new Product("001", "Laptop", 1000);

        cart.addProduct(product);

        assertEquals(1, cart.getItems().size());
    }

    @Test
    void shouldIncreaseQuantityWhenAddingSameProduct() {

        Cart cart = new Cart();

        Product product =
                new Product("001", "Laptop", 1000);

        cart.addProduct(product);
        cart.addProduct(product);

        assertEquals(1, cart.getItems().size());

        CartItem item = cart.getItems().get(0);

        assertEquals(2, item.getQuantity());
    }

    @Test
    void shouldNotAddNullProduct() {

        Cart cart = new Cart();

        cart.addProduct(null);

        assertEquals(0, cart.getItems().size());
    }

    @Test
    void shouldRemoveProduct() {

        Cart cart = new Cart();

        Product product =
                new Product("001", "Laptop", 1000);

        cart.addProduct(product);

        cart.removeProduct(product);

        assertEquals(0, cart.getItems().size());
    }

    @Test
    void shouldCalculateTotalPrice() {

        Cart cart = new Cart();

        cart.addProduct(
                new Product("001", "Laptop", 1000)
        );

        cart.addProduct(
                new Product("002", "Mouse", 100)
        );

        assertEquals(1100, cart.getTotal());
    }
}