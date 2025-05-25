package ru.Interface.FunctionalInterfaceExercises.Level2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ExerciseCollectorsTest {
    @Test
    void test() {
        collectorsTest();

    }
    public void collectorsTest() {
        List<String> listFruit = List.of("apple", "banana", "lemon", "kiwi", "pear");

        Map<Integer, List<String>> mapFruit = listFruit.stream().collect(groupingBy(String::length));
        System.out.println(mapFruit);

    }
}
