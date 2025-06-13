package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Ex10 {
    //Дан список чисел.
    //Нужно вычислить произведение квадратов всех положительных чисел, используя reduce.
    @Test
    void test() {
        calculatesTheProductOfTheSquaresOfAllPositiveNumbers(Arrays.asList(2, -3, 4, -1, 5));
    }

    public void calculatesTheProductOfTheSquaresOfAllPositiveNumbers(List<Integer> nums) {
        System.out.println(nums.stream()
                .filter(n -> n > 0)
                .map(n -> n * n)
                .reduce(1, (a, b) -> a * b));
    }
}
