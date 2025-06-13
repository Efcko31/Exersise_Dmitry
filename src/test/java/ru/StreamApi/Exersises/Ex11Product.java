package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Ex11Product {
    //Найти суммарную стоимость товаров по каждой категории,
    //отсортировать категории по убыванию суммы.

    @Test
    void test() {
        searchesForTotalCostOfGoodsByCategoryAndSortsAmountsInDescendingOrder(Arrays.asList(
                new ProductForEx11("Laptop", "Electronics", 1200),
                new ProductForEx11("Phone", "Electronics", 800),
                new ProductForEx11("Desk", "Furniture", 300),
                new ProductForEx11("Chair", "Furniture", 150),
                new ProductForEx11("Monitor", "Electronics", 250)
        ));
    }

    public void searchesForTotalCostOfGoodsByCategoryAndSortsAmountsInDescendingOrder(List<ProductForEx11> products) {
        Map<String, Integer> answer = products.stream()
                .collect(Collectors.groupingBy(ProductForEx11::getCategory,
                        Collectors.summingInt(ProductForEx11::getPrice)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        System.out.println(answer);
    }
}
