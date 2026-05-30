package ru.Oop.OnlineStoreVerdion2;

import org.junit.jupiter.api.Test;

import static ru.Oop.OnlineStoreVerdion2.Categories.*;
import static ru.Oop.OnlineStoreVerdion2.Users.*;
import static ru.Oop.OnlineStoreVerdion2.Products.*;



public class ProductsTest {
    @Test
    void test() {
        DAIRY_PRODUCTS.getCategory().addProductInCategory(milkHouseInVillage);
        DAIRY_PRODUCTS.getCategory().addProductInCategory(butterPresident, tilsiterCheese);
        CHOCOLATE.getCategory().addProductInCategory(hazelnutsChocolate, milkChocolate, bitterChocolate);
        BAKERY_PRODUCTS.getCategory().addProductInCategory(bread, loaf, baguette);

        ivan.getBasket().getListProductsInShoppingCart().add(baguette);
        ivan.getBasket().getListProductsInShoppingCart().add(loaf);
        zinaida.getBasket().add(loaf, bread, tilsiterCheese);
        ilya.getBasket().add(milkHouseInVillage, milkHouseInVillage, milkChocolate, baguette, tilsiterCheese);

        Categories.print(DAIRY_PRODUCTS, CHOCOLATE, BAKERY_PRODUCTS);
        Categories.print(SOFT_DRINKS);

        ivan.printBasket();
        ilya.printBasket();
        zinaida.printBasket();


    }
}
