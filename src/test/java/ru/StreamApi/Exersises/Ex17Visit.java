package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex17Visit {
    //Найти количество уникальных страниц для каждого пользователя
    @Test
    void test() {
        findsTheNumberOfUniquePagesForEachUser(Arrays.asList(
                new VisitForEx17("U1", "/home"),
                new VisitForEx17("U1", "/about"),
                new VisitForEx17("U2", "/home"),
                new VisitForEx17("U1", "/home")
        ));
    }

    public void findsTheNumberOfUniquePagesForEachUser(List<VisitForEx17> visits) {
        Map<String, Integer> answer = visits.stream().collect(Collectors.groupingBy(
                        VisitForEx17::getUserId,
                        Collectors.mapping(
                                VisitForEx17::getPageUr1,
                                Collectors.toSet())))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        p -> p.getValue().size()));
        System.out.println(answer);
    }
}
