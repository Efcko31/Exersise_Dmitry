package ru.Oop.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    protected String name;
    protected ArrayList<Product> products;

    public void addProductsToCategory(Product... product) {
        products.addAll(List.of(product));
    }

    public void removeProductFromCategory(Product product) {
        products.remove(product);
    }
}
