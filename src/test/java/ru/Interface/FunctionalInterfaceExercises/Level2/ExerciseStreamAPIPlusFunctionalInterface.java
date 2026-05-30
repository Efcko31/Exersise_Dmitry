package ru.Interface.FunctionalInterfaceExercises.Level2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseStreamAPIPlusFunctionalInterface {
    @Test
    void test() {
        assertEquals(220, countsSumSquaresEvenNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    public Integer countsSumSquaresEvenNumbers(List<Integer> listNumber) {

        return listNumber.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
