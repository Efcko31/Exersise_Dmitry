package ru.lab4;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Laba4Ex2 {
    //. Дана целочисленная последовательность. Определить количество вхождений каждого числа в последовательность.
    @Test
    void test() {
        assertArrayEquals(new int[]{3, 3, 7, 1, 8, 1, 6, 2, 4, 3, 5, 4, 9, 2, 2, 2, 1, 1, 0, 0},
                totalOfEachNumberInArray(new int[]{3, 7, 8, 6, 4, 5, 5, 5, 4, 6, 4, 9, 2, 9, 2, 1, 3, 5, 3}));
        assertArrayEquals(new int[]{3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                totalOfEachNumberInArray(new int[]{3, 3, 3, 3, 3, 3}));
        assertArrayEquals(new int[]{3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                totalOfEachNumberInArray(new int[]{3}));
        assertArrayEquals(new int[]{3, 2, 8, 2, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                totalOfEachNumberInArray(new int[]{3, 3, 8, 8, 4, 4}));
        assertArrayEquals(new int[]{3, 1, 2, 1, 4, 1, 1, 1, 5, 1, 6, 1, 9, 1, 8, 1, 7, 1, 0, 0},
                totalOfEachNumberInArray(new int[]{3, 2, 4, 1, 5, 6, 9, 8, 7}));
    }

    private int[] totalOfEachNumberInArray(int[] arrayNumber) {
        int[] arrayDuplicate = new int[20];
        for (int i = 0; i < arrayNumber.length; i++) {
            for (int j = 0; j < arrayDuplicate.length; j += 2) {
                if (arrayNumber[i] == arrayDuplicate[j]) {
                    arrayDuplicate[j + 1] += 1;
                    j = arrayDuplicate.length;
                } else if (arrayDuplicate[j] == 0) {
                    arrayDuplicate[j] = arrayNumber[i];
                    arrayDuplicate[j + 1] += 1;
                    j = arrayDuplicate.length;
                }
            }
        }
        return arrayDuplicate;
    }
}
