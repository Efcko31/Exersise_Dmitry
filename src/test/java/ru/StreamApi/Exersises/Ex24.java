package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex24 {

    //Дан список строк вида "name:age" (например, "Alice:25").
    //Найти средний возраст людей, чьё имя начинается на букву A (регистронезависимо).
    @Test
    void findsTheAverageAgeOfPeopleWhoseNameBeginsWithTheGivenLetterTest() {
        assertEquals(24.333333333333332d, findsTheAverageAgeOfPeopleWhoseNameBeginsWithTheGivenLetter(
                Arrays.asList("Alice:25", "bob:30", "alex:20", "Anna:28", "john:40"), "A"));
    }

    public Double findsTheAverageAgeOfPeopleWhoseNameBeginsWithTheGivenLetter(List<String> people, String letter) {
        return people.stream()
                .filter(s -> letter.equalsIgnoreCase(s.substring(0, 1)))
                .filter(n -> n.substring(n.indexOf(":") + 1).matches("\\d+"))
                .map(n -> n.substring(n.indexOf(":") + 1))
                .mapToDouble(Double::parseDouble)
                .average().orElse(-1.0d);
    }

    //Дан список транзакций с полями: accountId, amount, type (DEPOSIT или WITHDRAWAL).
    //Для каждого аккаунта найти максимальный депозит и минимальное снятие.
    @Test
    void findsTheMaximumDepositAndMinimumWithdrawalForEachAccountTest() {
        findsTheMaximumDepositAndMinimumWithdrawalForEachAccount(Arrays.asList(
                new TransactionForEx8("A1", 1000, "DEPOSIT"),
                new TransactionForEx8("A2", 500, "DEPOSIT"),
                new TransactionForEx8("A1", 200, "WITHDRAWAL"),
                new TransactionForEx8("A2", 300, "WITHDRAWAL"),
                new TransactionForEx8("A1", 1500, "DEPOSIT")
        ));
    }

    public void findsTheMaximumDepositAndMinimumWithdrawalForEachAccount(List<TransactionForEx8> transactions) {
        Map<String, Map<String, Integer>> answer = transactions.stream()
                .collect(Collectors.groupingBy(
                        TransactionForEx8::getAccountId,
                        Collectors.teeing(
                                Collectors.filtering(
                                        t -> "DEPOSIT".equals(t.getType()),
                                        Collectors.collectingAndThen(
                                                Collectors.mapping(
                                                        TransactionForEx8::getAmount,
                                                        Collectors.maxBy(Integer::compare)
                                                ),
                                                opt -> opt.orElse(null)
                                        )
                                ), Collectors.filtering(
                                        t -> "WITHDRAWAL".equals(t.getType()),
                                        Collectors.collectingAndThen(Collectors.mapping(
                                                TransactionForEx8::getAmount,
                                                Collectors.minBy(Integer::compare)), opt -> opt.orElse(null))
                                ),
                                (maxDeposit, minWithdrawal) -> {
                                    Map<String, Integer> map = new HashMap<>();
                                    if (maxDeposit != null) map.put("DEPOSIT", maxDeposit);
                                    if (minWithdrawal != null) map.put("WITHDRAWAL", minWithdrawal);
                                    return map;
                                }
                        )
                ));
        System.out.println(answer);

    }
}

