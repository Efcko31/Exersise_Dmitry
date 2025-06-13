package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex21_1 {
    //Найти среднее значение value, игнорируя некорректные.
    @Test
    void test() {
        assertEquals(7.75d, findsTheAverageValueOf(Arrays.asList(
                "value=5.5;unit=kg",
                "value=10.0;unit=g",
                "value=abc;unit=g"
        )));
        assertEquals(7.75d, findsTheAverageValueOf(Arrays.asList(
                "value=5,5;unit=kg",
                "value=10,0;unit=g",
                "value=abc;unit=g"
        )));
        assertEquals(-2.25d, findsTheAverageValueOf(Arrays.asList(
                "value=5,5;unit=kg",
                "value=-10,0;unit=g",
                "value=abc;unit=g"
        )));
        assertEquals(-1.0d, findsTheAverageValueOf(Arrays.asList(
                "value=ddd;unit=kg",
                "value=Nan,0;unit=g",
                "value=abc;unit=g"
        )));
    }

    public Double findsTheAverageValueOf(List<String> data) {
        return data.stream()
                .map(s -> s.split(";")[0].substring(s.indexOf("=") + 1))
                .filter(s -> s.matches("-?\\d+[,.]\\d+"))
                .map(s -> s.replace(",", "."))
                .mapToDouble(Double::parseDouble)
                .average()
                .orElse(-1.0);
    }
}
