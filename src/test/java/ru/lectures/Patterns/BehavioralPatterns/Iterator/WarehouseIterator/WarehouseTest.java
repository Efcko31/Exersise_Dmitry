package ru.lectures.Patterns.BehavioralPatterns.Iterator.WarehouseIterator;

import java.util.Iterator;

public class WarehouseTest {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct(new Product("A1", 0));
        warehouse.addProduct(new Product("B2", 5));
        warehouse.addProduct(new Product("C3", 0));

        Iterator<Product> it = warehouse.getAvailableProductsIterator();
        while(it.hasNext()) {
            Product p = it.next();
            System.out.println("Доступен товар: " + p.getId());
        }
    }
}
