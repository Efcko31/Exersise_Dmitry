package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex18Transactions {
    //Для каждого кассира найти количество уникальных проданных товаров.
    @Test
    void test() {
        findsTheNumberOfUniqueProductsSold(Arrays.asList(
                new TransactionsForEx18("C1", "P1"),
                new TransactionsForEx18("C1", "P2"),
                new TransactionsForEx18("C2", "P1"),
                new TransactionsForEx18("C1", "P1")
        ));
    }

    public void findsTheNumberOfUniqueProductsSold(List<TransactionsForEx18> transactions) {
        Map<String, Integer> answer = transactions.stream()
                .collect(Collectors.groupingBy(
                        TransactionsForEx18::getCasherId,
                        Collectors.mapping(
                                TransactionsForEx18::getProductId,
                                Collectors.toSet())))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        p -> p.getValue().size()));
        System.out.println(answer);
    }
}
