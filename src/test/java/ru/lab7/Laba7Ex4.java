package ru.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba7Ex4 {
    /* С клавиатуры вводятся целые числа. Признак конца ввода — ноль.
    Найти произведение введённых нечётных чисел. */

    @Test
    void test() {
        assertEquals(120, findProductNumbers(new int[] {1, 2, 3, 4, 5}));

        assertEquals(1, findProductNumbers(new int[] {1}));

        assertEquals(0, findProductNumbers(new int[2000]));



        assertEquals(120, findProductNumbersByRecursion(new int[] {1, 2, 3, 4, 5}, 0, 1));

        assertEquals(1, findProductNumbersByRecursion(new int[] {1}, 0, 1));

        assertEquals(0, findProductNumbersByRecursion(new int[] {}, 0, 1));

        assertEquals(0, findProductNumbersByRecursion(new int[2000], 0, 1));
    }

    private int findProductNumbers(int[] numberArray) {
        int product = 1;

        for (int i = 0; i < numberArray.length; i++) {
            product*= numberArray[i];
        }
    return numberArray.length == 0 ? 0 : product;
    }

    private int findProductNumbersByRecursion(int[] numberArray, int i, int product) {
        if (i == numberArray.length) {
            return numberArray.length == 0 ? 0 : product;
        }

        product*= numberArray[i];
        i++;

    return findProductNumbersByRecursion(numberArray, i, product);
    }
}
