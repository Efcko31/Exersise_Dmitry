package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba4Ex2Stream {
    //. Дана целочисленная последовательность. Определить количество вхождений каждого числа в последовательность.
    @Test
    void test() {
        assertEquals(List.of("1: 1", "2: 2", "3: 3", "4: 3", "5: 4", "6: 2", "7: 1", "8: 1", "9: 2"),
                totalOfEachNumberInArray(List.of(3, 7, 8, 6, 4, 5, 5, 5, 4, 6, 4, 9, 2, 9, 2, 1, 3, 5, 3)));//todo List.of
        assertEquals(List.of("3: 6"),
                totalOfEachNumberInArray(List.of(3, 3, 3, 3, 3, 3)));//todo List.of
        assertEquals(List.of("3: 1"),
                totalOfEachNumberInArray(List.of(3)));
        assertEquals(List.of("3: 2", "4: 2", "8: 2"),
                totalOfEachNumberInArray(List.of(3, 3, 8, 8, 4, 4)));
        assertEquals(List.of("1: 1", "2: 1", "3: 1", "4: 1", "5: 1", "6: 1", "7: 1", "8: 1", "9: 1"),
                totalOfEachNumberInArray(List.of(3, 2, 4, 1, 5, 6, 9, 8, 7)));//todo List.of
        assertEquals(List.of(),
                totalOfEachNumberInArray(List.of()));//todo Collections.emptyList()
    }

    private List<String> totalOfEachNumberInArray(List<Integer> list) {
        Map<Integer, Integer> map1 = list.stream() //todo осмысленное название переменной
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));//todo операции стримов на разных строках
        List<String> answer = new ArrayList<>();
        map1.forEach((k, v) -> answer.add(k + ": " + v));//todo строку
        System.out.println(map1.entrySet().stream()
                .map(entry -> String.format("%d:%d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\t")));
        return answer;
    }
}
