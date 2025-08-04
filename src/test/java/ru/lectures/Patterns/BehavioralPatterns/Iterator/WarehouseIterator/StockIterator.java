package ru.lectures.Patterns.BehavioralPatterns.Iterator.WarehouseIterator;

import java.util.Iterator;
import java.util.List;

public class StockIterator implements Iterator<Product> {
    private List<Product> products;
    private int position = 0;

    public StockIterator(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        while (position < products.size()) {
            if (products.get(position).getQuantity() > 0) {
                return true;
            }
            position++;
        }
        return false;
    }

    @Override
    public Product next() {
        if (!hasNext()) throw new RuntimeException();
        return products.get(position++);
    }
}
