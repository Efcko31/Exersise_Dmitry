package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex2 {
    //Дан список целых чисел. Необходимо найти сумму квадратов всех четных чисел.
    @Test
    void findsTheSumOfTheSquaresOfAllEvenNumbersTest() {
        assertEquals(56, findsTheSumOfTheSquaresOfAllEvenNumbers(List.of(1, 2, 3, 4, 5, 6)));
    }

    public Integer findsTheSumOfTheSquaresOfAllEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();

    }
}
