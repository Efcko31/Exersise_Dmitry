package ru.Oop.OnlineStoreVerdion2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum Categories {

    DAIRY_PRODUCTS(new Category("Молочные изделия", new ArrayList<>())),
    BAKERY_PRODUCTS(new Category("Хлебобулочные изделия", new ArrayList<>())),
    CHOCOLATE(new Category("Шоколад", new ArrayList<>())),
    SOFT_DRINKS(new Category("Безалкогольные напитки", List.of(new Product("Добрый кола 2л.", 91.0, 4.3))));

    private final Category category;

    Categories(Category category) {
        this.category = category;
    }

    public static void print(Categories... category) {
        for (int i = 0; i < category.length; i++) {
            System.out.printf("\nКатегория: %s\n", category[i].getCategory().getName());
            for (int j = 0; j < category[i].getCategory().getProducts().size(); j++) {
                System.out.printf("%s, цена: %.2f, рейтинг: %.2f\n",
                        category[i].getCategory().getProducts().get(j).getName(),
                        category[i].getCategory().getProducts().get(j).getPrice(),
                        category[i].getCategory().getProducts().get(j).getRating());
            }
        }
    }

}
