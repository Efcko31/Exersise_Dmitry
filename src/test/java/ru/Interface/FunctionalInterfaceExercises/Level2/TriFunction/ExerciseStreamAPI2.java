package ru.Interface.FunctionalInterfaceExercises.Level2.TriFunction;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseStreamAPI2 {
    @Test
    void test() {
        assertEquals("[0 + 7, 1 + 6, 2 + 5, 3 + 4]", searchesForAllPairsNumbersInListThatAddUpGivenValue(
                List.of(0, 1, 2, 3, 4, 5, 6, 7), 7));
        assertEquals("[0 + 12, 3 + 9, 2 + 10, 1 + 11, 5 + 7, 4 + 8]",
                searchesForAllPairsNumbersInListThatAddUpGivenValue(
                        List.of(0, 3, 2, 11, 10, 5, 6, 7, 8, 9, 4, 1, 12), 12));

    }

    public String searchesForAllPairsNumbersInListThatAddUpGivenValue(List<Integer> numbers, Integer n) {

        List<String> sumNumbers = IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .filter(j -> numbers.get(i) + numbers.get(j) == n)
                        .mapToObj(j -> {
                            int a = numbers.get(i);
                            int b = numbers.get(j);
                            return a > b ? b + " + " + a : a + " + " + b;
                        }))
                .toList();
        System.out.println(sumNumbers);
        return sumNumbers.toString();
    }
}
