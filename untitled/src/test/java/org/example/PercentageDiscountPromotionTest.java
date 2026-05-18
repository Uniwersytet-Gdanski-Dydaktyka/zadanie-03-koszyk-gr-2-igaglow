package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercentageDiscountPromotionTest {

    @Test
    void shouldApply5PercentDiscount() {

        Customer customer = new Customer("1");

        Product laptop =
                new Product("001", "Laptop", 400);

        customer.getCart().addProduct(laptop);

        PercentageDiscountPromotion promotion =
                new PercentageDiscountPromotion();

        promotion.apply(customer);

        CartItem item =
                customer.getCart().getItems().get(0);

        assertEquals(
                380,
                item.getFinalPrice()
        );
    }

    @Test
    void shouldNotApplyDiscountBelow300() {

        Customer customer = new Customer("1");

        Product laptop =
                new Product("001", "Laptop", 200);

        customer.getCart().addProduct(laptop);

        PercentageDiscountPromotion promotion =
                new PercentageDiscountPromotion();

        promotion.apply(customer);

        CartItem item =
                customer.getCart().getItems().get(0);

        assertEquals(
                200,
                item.getFinalPrice()
        );
    }
}