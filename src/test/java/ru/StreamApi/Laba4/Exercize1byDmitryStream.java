package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercize1byDmitryStream {
    //Дана строка, где пробелом разделены слова, найти слова, которые состоят только из цифр
    @Test
    void test() {
        assertEquals(List.of("124785", "5555555"), findWordsConsistingOnlyOfNumbers(
                "хлеб2 мУка Сверхъестественное бюд45же3т 124785 сто100 5555555 mouse"));
        assertEquals(Collections.emptyList(), findWordsConsistingOnlyOfNumbers(
                ""));
    }

    public List<String> findWordsConsistingOnlyOfNumbers(String string) {
        return Arrays.stream(string.split(" "))
                .filter(s -> s.matches("\\d+"))
                .toList();

    }
}
