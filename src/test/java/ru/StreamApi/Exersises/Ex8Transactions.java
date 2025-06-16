package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Ex8Transactions {
    //Нужно сгруппировать транзакции по номеру счёта и для каждого счёта
    //вычислить итоговый баланс (депозиты прибавляем, снятия вычитаем).
    @Test
    void test() {
        calculatesTheTotalBalanceForEachAccount(Arrays.asList(
                new TransactionForEx8("A1", 1000, "DEPOSIT"),
                new TransactionForEx8("A2", 500, "DEPOSIT"),
                new TransactionForEx8("A1", 200, "WITHDRAWAL"),
                new TransactionForEx8("A2", 300, "WITHDRAWAL"),
                new TransactionForEx8("A1", 1500, "DEPOSIT")
        ));
    }

    public void calculatesTheTotalBalanceForEachAccount(List<TransactionForEx8> transactions) {
        Map<String, Integer> answer = transactions.stream()
                .collect(Collectors.groupingBy(
                        TransactionForEx8::getAccountId,
                        Collectors.reducing(
                                0,
                                transaction -> transaction.getType().equals("DEPOSIT")
                                        ? transaction.getAmount()
                                        : -transaction.getAmount(),
                                Integer::sum
                        )
                ));
        System.out.println(answer);


    }
}
