package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex22_2 {
    //Для каждого города найти минимальную температуру.
    @Test
    void findsTheMinimumTemperatureForEachCityTest() {
        findsTheMinimumTemperatureForEachCity(Arrays.asList(
                new TemperatureForEx22_2("Moscow", -10),
                new TemperatureForEx22_2("Berlin", 5),
                new TemperatureForEx22_2("Berlin", -5),
                new TemperatureForEx22_2("Moscow", -15)
        ));
    }

    public void findsTheMinimumTemperatureForEachCity(List<TemperatureForEx22_2> temps) {
        Map<String, Integer> answer = temps.stream()
                .collect(Collectors.groupingBy(
                        TemperatureForEx22_2::getCity,Collectors.collectingAndThen(
                        Collectors.minBy(
                                Comparator.comparingInt(TemperatureForEx22_2::getValue)),
                        t -> t.isPresent() ? t.get().getValue() : -666)));
        System.out.println(answer);
    }
}
