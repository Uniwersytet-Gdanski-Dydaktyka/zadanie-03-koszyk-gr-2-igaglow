package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeMugPromotionTest {

    @Test
    void shouldAddFreeMugWhenTotalAbove200() {

        Customer customer = new Customer("1");

        customer.getCart().addProduct(
                new Product("001", "Laptop", 250)
        );

        FreeMugPromotion promotion =
                new FreeMugPromotion();

        promotion.apply(customer);

        boolean hasMug =
                customer.getCart()
                        .getItems()
                        .stream()
                        .anyMatch(i ->
                                i.getProduct()
                                        .getCode()
                                        .equals("000"));

        assertTrue(hasMug);
    }

    @Test
    void shouldNotAddSecondMug() {

        Customer customer = new Customer("1");

        customer.getCart().addProduct(
                new Product("001", "Laptop", 250)
        );

        customer.getCart().addProduct(
                new Product("000", "Free mug", 0)
        );

        FreeMugPromotion promotion =
                new FreeMugPromotion();

        promotion.apply(customer);

        long mugsCount =
                customer.getCart()
                        .getItems()
                        .stream()
                        .filter(i ->
                                i.getProduct()
                                        .getCode()
                                        .equals("000"))
                        .count();

        assertEquals(1, mugsCount);
    }
}
