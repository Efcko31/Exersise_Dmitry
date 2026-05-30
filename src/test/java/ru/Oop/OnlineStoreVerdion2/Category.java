package ru.Oop.OnlineStoreVerdion2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private String name;
    private List<Product> products;

    public void addProductInCategory(Product product) {
        products.add(product);
    }

    public void addProductInCategory(Product... product) {
        for (Product i : product) {
            products.add(i);
        }
    }

}
