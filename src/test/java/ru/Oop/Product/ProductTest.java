package ru.Oop.Product;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ProductTest {
    Category chocolate = new Category("Шоколад", new ArrayList<>());
    Category dairyProducts = new Category("Молочные издели", new ArrayList<>());
    Category bakery = new Category("Хлебобулочные изделия", new ArrayList<>());

    Product milk = new Product("Молоко Домик в деревне 3.2%, 1 литр.", 81.50, 4.5);
    Product butter = new Product("Масло сливочное Авида 400 гр.", 95.70, 4.8);
    Product cheese = new Product("Сыр Тельзитер Подворье 400 гр.", 253.80, 4.0);
    Product chocolate1 = new Product("Шоколад молочный", 79.90, 4.7);
    Product chocolate2 = new Product("Шоколад горький", 79.90, 4.1);
    Product chocolate3 = new Product("Шоколад с лесным орехом", 89.90, 4.4);
    Product bread1 = new Product("Хлеб черный", 35.50, 4.9);
    Product bread2 = new Product("Батон", 49.90, 4.2);
    Product bread3 = new Product("Багет", 55.20, 4.7);

    User user1 = new User("EkaterinaVologdova", "qwertyuiop[123", new Basket(new ArrayList<>()));
    User user2 = new User("IvanPereverzev", "fyrhxobn2", new Basket(new ArrayList<>()));
    User user3 = new User("DmitryNikolaev", "2281488_onlyfansForever", new Basket(new ArrayList<>()));

    @Test
    public void test() {
        chocolate.addProductsToCategory(chocolate1, chocolate2, chocolate3);
        dairyProducts.addProductsToCategory(milk, cheese, butter);
        bakery.addProductsToCategory(bread1, bread2, bread3);

        user1.getBasket().addProductsToBasket(bread1, cheese, butter);
        user2.getBasket().addProductsToBasket(chocolate1, milk, bread3);
        user3.getBasket().addProductsToBasket(chocolate2, chocolate3, bread2, milk);

        user3.getBasket().removeProductFromBasket(milk);

        ProductUtil.printProducts(chocolate, dairyProducts, bakery);
        ProductUtil.printUserBasket(user1, user2, user3);
    }

}
