package ru.Interface.FunctionalInterfaceExercises.Level2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseStreamAPI4 {
    @Test
    void test() {
//        assertEquals(List.of("A-A", "A-B", "A-C", "B-B", "B-C", "C-C"),
//                generatingAllPossibleCombinationsFromList(List.of("A", "B", "C")));
        assertEquals(List.of("A-A-A", "A-A-B", "A-A-C", "A-B-B", "A-B-C", "A-C-C", "B-B-B", "B-B-C", "B-C-C", "C-C-C"),
                generatingAllPossibleCombinationsFromList(List.of("A", "B", "C")));
    }
    public List<String> generatingAllPossibleCombinationsFromList(List<String> listSymbols) {
        List<String> pairsChar = IntStream.range(0, listSymbols.size())
                .boxed()
                .flatMap(i -> IntStream.range(i, listSymbols.size())
                        .boxed()
                        .flatMap(k -> IntStream.range(k, listSymbols.size())
                                .mapToObj(j ->
                                        listSymbols.get(i) + "-" + listSymbols.get(k) + "-" + listSymbols.get(j))))
                .toList();

        return pairsChar;

    }
}
