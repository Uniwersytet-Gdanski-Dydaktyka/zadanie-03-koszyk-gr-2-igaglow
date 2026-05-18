package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductSorterTest {

    private final ProductSorter sorter = new ProductSorter();

    @Test
    void shouldFindCheapestProduct() {

        Product p1 = new Product("1", "A", 300.0);
        Product p2 = new Product("2", "B", 100.0);

        Product result = sorter.findCheapest(List.of(p1, p2));

        assertEquals(p2, result);
    }

    @Test
    void shouldFindMostExpensiveProduct() {

        Product p1 = new Product("1", "A", 300.0);
        Product p2 = new Product("2", "B", 100.0);

        Product result = sorter.findMostExpensive(List.of(p1, p2));

        assertEquals(p1, result);
    }

    @Test
    void shouldSortProductsAscending() {

        Product p1 = new Product("1", "A", 300.0);
        Product p2 = new Product("2", "B", 100.0);

        List<Product> sorted =
                sorter.sortProducts(
                        List.of(p1, p2),
                        ProductComparators.PRICE_ASC
                );

        assertEquals(p2, sorted.get(0));
        assertEquals(p1, sorted.get(1));
    }
}
