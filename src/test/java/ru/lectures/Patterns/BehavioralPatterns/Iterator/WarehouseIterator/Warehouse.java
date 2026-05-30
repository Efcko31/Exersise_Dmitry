package ru.lectures.Patterns.BehavioralPatterns.Iterator.WarehouseIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Warehouse {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public Iterator<Product> getAvailableProductsIterator() {
        return new StockIterator(products);
    }
}
