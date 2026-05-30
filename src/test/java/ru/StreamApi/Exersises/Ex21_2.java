package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex21_2 {
    //Найти самый ранний год (минимум), игнорируя некорректные.
    @Test
    void test() {
        assertEquals(2022, findsTheEarliestYear(Arrays.asList(
                "year=2023,month=12,day=05",
                "year=2022,month=01,day=15",
                "year=invalid,month=12,day=05"
        )));
        assertEquals(2022, findsTheEarliestYear(Arrays.asList(
                "year=invalid,month=12,day=05",
                "year=invalid,month=01,day=15",
                "year=invalid,month=12,day=05"
        )));
    }

    public Integer findsTheEarliestYear(List<String> dates) {
        return dates.stream()
                .map(s -> s.substring(s.indexOf("=") + 1, s.indexOf(",")))
                .filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .min()
                .orElse(-1);
    }
}
