package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Buy2Get1PromotionTest {

    @Test
    void shouldMakeCheapestItemFree() {

        Customer customer = new Customer("1");

        customer.getCart().addProduct(
                new Product("1", "A", 100)
        );

        customer.getCart().addProduct(
                new Product("2", "B", 200)
        );

        customer.getCart().addProduct(
                new Product("3", "C", 300)
        );

        Buy2Get1Promotion promotion =
                new Buy2Get1Promotion();

        promotion.apply(customer);

        CartItem cheapest =
                customer.getCart()
                        .getItems()
                        .stream()
                        .filter(i ->
                                i.getProduct()
                                        .getPrice() == 100)
                        .findFirst()
                        .orElseThrow();

        assertEquals(
                0.0,
                cheapest.getFinalPrice()
        );
    }

    @Test
    void shouldDoNothingWhenLessThan3Products() {

        Customer customer = new Customer("1");

        customer.getCart().addProduct(
                new Product("1", "A", 100)
        );

        customer.getCart().addProduct(
                new Product("2", "B", 200)
        );

        Buy2Get1Promotion promotion =
                new Buy2Get1Promotion();

        promotion.apply(customer);

        CartItem item =
                customer.getCart().getItems().get(0);

        assertEquals(
                100,
                item.getFinalPrice()
        );
    }
}