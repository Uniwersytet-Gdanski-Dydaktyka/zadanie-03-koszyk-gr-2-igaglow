package org.example;

import java.util.Comparator;

public final class ProductComparators {

    private ProductComparators() {
    }

    public static final Comparator<Product> PRICE_DESC = Comparator.comparing(Product::getPrice).reversed();

    public static final Comparator<Product> PRICE_ASC = Comparator.comparing(Product::getPrice);

    public static final Comparator<Product> NAME_ASC = Comparator.comparing(Product::getName);

    public static final Comparator<Product> NAME_DESC = Comparator.comparing(Product::getName).reversed();

    public static final Comparator<Product> DEFAULT_SORT = PRICE_DESC.thenComparing(NAME_ASC);
}
