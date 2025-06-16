package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex6 {

    //Дан список заказов.
    //Нужно найти общую сумму всех заказов, чья сумма больше 1000, и вывести её.
    @Test
    void test() {
        assertEquals(2700, calculateTheTotalAmountOfOrdersWhoseAmountIsGreaterThanN(Arrays.asList(
                new OrderForEx6(1, 1500), new OrderForEx6(2, 800),
                new OrderForEx6(3, 1200), new OrderForEx6(4, 900)), 1000));
    }

    public Integer calculateTheTotalAmountOfOrdersWhoseAmountIsGreaterThanN(List<OrderForEx6> orders, Integer n) {
        return orders.stream()
                .filter(a -> a.getAmount() > n)
                .mapToInt(OrderForEx6::getAmount)
                .sum();
    }
}
