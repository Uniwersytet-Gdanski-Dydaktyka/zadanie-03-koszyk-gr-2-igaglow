package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PromotionServiceTest {

    @Test
    void shouldApplyAllPromotions() {

        Customer customer = new Customer("1");

        customer.getCart().addProduct(
                new Product("1", "Laptop", 400)
        );

        PromotionService service =
                new PromotionService(
                        List.of(
                                new PercentageDiscountPromotion(),
                                new FreeMugPromotion()
                        )
                );

        service.applyPromotions(customer);

        CartItem item =
                customer.getCart().getItems().get(0);

        assertEquals(
                380,
                item.getFinalPrice()
        );

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
    void shouldResetDiscountsBeforeApplyingPromotions() {

        Customer customer = new Customer("1");

        Product laptop =
                new Product("1", "Laptop", 400);

        customer.getCart().addProduct(laptop);

        CartItem item =
                customer.getCart().getItems().get(0);

        item.setFinalPrice(100);

        PromotionService service =
                new PromotionService(
                        List.of(
                                new PercentageDiscountPromotion()
                        )
                );

        service.applyPromotions(customer);

        assertEquals(
                380,
                item.getFinalPrice()
        );
    }
}
