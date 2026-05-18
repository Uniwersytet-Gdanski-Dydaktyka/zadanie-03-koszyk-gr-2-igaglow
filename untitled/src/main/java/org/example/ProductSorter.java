package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductSorter {

    public List<Product> sortProducts(List<Product> products, Comparator<Product> comparator) {

        List<Product> sortedProducts = new ArrayList<>(products);

        sortedProducts.sort(comparator);

        return sortedProducts;
    }

    public Product findCheapest(List<Product> products) {

        return products.stream().min(ProductComparators.PRICE_ASC).orElse(null);
    }

    public Product findMostExpensive(List<Product> products) {

        return products.stream().max(ProductComparators.PRICE_ASC).orElse(null);
    }

    public List<Product> findNMostExpensive(List<Product> products, int n) {

        return products.stream().sorted(ProductComparators.PRICE_DESC).limit(n).toList();
    }

    public List<Product> findNCheapest(List<Product> products, int n) {

        return products.stream().sorted(ProductComparators.PRICE_ASC).limit(n).toList();
    }
}
