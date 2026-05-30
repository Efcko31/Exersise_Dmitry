package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba4Ex2Stream {
    //private Map<Integer, Integer> mapOf;
    //. Дана целочисленнслая последовательность. Определить количество вхождений каждого чиа в последовательность.
    @Test
    void test() {

        assertEquals(Map.of(1, 1,
                        2, 2,
                        3, 3,
                        4, 3,
                        5, 4,
                        6, 2,
                        7, 1,
                        8, 1,
                        9, 2),
                totalOfEachNumberInArray(List.of(3, 7, 8, 6, 4, 5, 5, 5, 4, 6, 4, 9, 2, 9, 2, 1, 3, 5, 3)));
        assertEquals(Map.of(3, 6),
                totalOfEachNumberInArray(List.of(3, 3, 3, 3, 3, 3)));
        assertEquals(Map.of(3, 1),
                totalOfEachNumberInArray(List.of(3)));
        assertEquals(Map.of(3, 2,
                        4, 2,
                        8, 2),
                totalOfEachNumberInArray(List.of(3, 3, 8, 8, 4, 4)));
        assertEquals(Map.of(1, 1,
                        2, 1,
                        3, 1,
                        4, 1,
                        5, 1,
                        6, 1,
                        7, 1,
                        8, 1,
                        9, 1),
                totalOfEachNumberInArray(List.of(3, 2, 4, 1, 5, 6, 9, 8, 7)));
        assertEquals(Map.of(),
                totalOfEachNumberInArray(Collections.emptyList()));
    }

    private Map<Integer, Integer> totalOfEachNumberInArray(List<Integer> list) {
        Map<Integer, Integer> mapWithNumberOccurrencesEachNumberInSequence = list.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));

        System.out.println(mapWithNumberOccurrencesEachNumberInSequence.entrySet().stream()
                .map(entry -> String.format("%d:%d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\t")));
        return mapWithNumberOccurrencesEachNumberInSequence;
    }
}
