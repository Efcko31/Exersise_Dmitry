package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex15Transactions {
    //Для каждой валюты найти транзакцию с максимальной суммой и вывести в формате "USD: 500"
    @Test
    void test() {
        findsTheMaximumTransactionAmount(Arrays.asList(
                new TransactionForEx15("USD", 100),
                new TransactionForEx15("EUR", 200),
                new TransactionForEx15("USD", 500),
                new TransactionForEx15("EUR", 150),
                new TransactionForEx15("GBP", 300)));
    }

    public void findsTheMaximumTransactionAmount(List<TransactionForEx15> transactions) {
        Map<String, Integer> maxSumTransaction = transactions.stream()
                .collect(Collectors.groupingBy(
                        TransactionForEx15::getCurrency,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparingInt(TransactionForEx15::getAmount)),
                                c-> c.get().getAmount())));
        System.out.println(maxSumTransaction);
    }
}
