package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex21 {
    @Test
    void test() {
        assertEquals(38.3d, findTheAverageTemperature(Arrays.asList("T=36.5", "T=abc", "T=40.1")));
    }

    public Double findTheAverageTemperature(List<String> temps) {
        return temps.stream()
                .map(s -> s.split("="))
                .filter(arr -> arr.length == 2)
                .map(arr -> arr[1])
//                .filter(s -> s.matches("-?\\d+\\.?\\d*"))
//                .mapToDouble(Double::parseDouble)
                .filter(s -> {
                    try {
                        Double.parseDouble(s.replace(",", "."));
                        return true;
                    } catch(NumberFormatException e) {
                        return false;
                    }
                }).mapToDouble(Double::parseDouble)
                .average()
                .orElse(0.0);
    }
}
