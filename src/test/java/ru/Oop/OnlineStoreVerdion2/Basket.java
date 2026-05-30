package ru.Oop.OnlineStoreVerdion2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
    public ArrayList<Product> listProductsInShoppingCart;

    public void add(Product... products) {
        for (Product i : products) {
            listProductsInShoppingCart.add(i);
        }
    }

    public void print() {
        for (int j = 0; j < listProductsInShoppingCart.size(); j++) {
            System.out.printf("%s, цена: %.2f, рейтинг: %.2f\n",
                    listProductsInShoppingCart.get(j).getName(),
                    listProductsInShoppingCart.get(j).getPrice(),
                    listProductsInShoppingCart.get(j).getRating());
        }
    }
}

