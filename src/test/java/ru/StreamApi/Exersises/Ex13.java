package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex13 {
    //Найти минимальное чётное число,
    //преобразовать его в строку в формате "Min = X". Если таких чисел нет — вернуть "None"
    @Test
    void test() {
        findsTheMinimumNumberAndConvertsItToAString(Arrays.asList("5", "22", "abc", "10", "7", "xyz"));
        findsTheMinimumNumberAndConvertsItToAString(Arrays.asList("5", "22", "abc", "10", "2", "xyz"));
        findsTheMinimumNumberAndConvertsItToAString(Arrays.asList("4", "22", "abc", "10", "7", "xyz"));
    }
    public void findsTheMinimumNumberAndConvertsItToAString(List<String> data) {
        String minNumber = data.stream()
                .filter(n -> n.matches("\\d+"))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min(Integer::compareTo)
                .map(n -> "Min = " + n)
                .orElse("NONE");
        System.out.println(minNumber);
    }
}
