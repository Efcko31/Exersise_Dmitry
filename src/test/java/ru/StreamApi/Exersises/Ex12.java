package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex12 {
    // Для каждого покупателя найти количество уникальных товаров, которые он заказал
    @Test
    void test() {
        searchesForTheNumberOfUniqueItemsInAnOrder(Arrays.asList(
                new OrderForEx12("C1", "P1", 2),
                new OrderForEx12("C1", "P2", 1),
                new OrderForEx12("C2", "P1", 3),
                new OrderForEx12("C1", "P1", 1)
        ));
    }
    public void searchesForTheNumberOfUniqueItemsInAnOrder(List<OrderForEx12> orders) {
        Map<String, Long> answer = orders.stream()
                .collect(Collectors.groupingBy(
                        OrderForEx12::getCustomerId,
                        Collectors.mapping(
                                OrderForEx12::getProductId,
                                Collectors.toSet()
                        )))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> (long) e.getValue().size()));
        System.out.println(answer);
    }
}
