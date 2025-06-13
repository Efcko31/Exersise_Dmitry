package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex22 {
    // Для каждой категории найти самый дорогой заказ.
    @Test
    void findsTheMostExpensiveOrderForEachCategoryTest() {
        findsTheMostExpensiveOrderForEachCategory(Arrays.asList(
                new OrderForEx22("Electronics", 1000),
                new OrderForEx22("Books", 200),
                new OrderForEx22("Electronics", 1500)
        ));
    }

    public void findsTheMostExpensiveOrderForEachCategory(List<OrderForEx22> orders) {
        Map<String, Integer> answer = orders.stream()
                .collect(Collectors.groupingBy(
                        OrderForEx22::getProductCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(OrderForEx22::getPrice)),
                                        p -> p.isPresent() ? p.get().getPrice() : -1)));
        System.out.println(answer);
    }
}
