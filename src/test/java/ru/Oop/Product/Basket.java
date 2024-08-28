package ru.Oop.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Basket {
    protected ArrayList<Product> productsForPurchase;

    public void addProductsToBasket(Product... product) {
        productsForPurchase.addAll(List.of(product));
    }

    public void removeProductFromBasket(Product product) {
        productsForPurchase.remove(product);
    }
}
