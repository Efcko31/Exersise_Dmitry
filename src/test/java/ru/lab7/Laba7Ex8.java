package ru.lab7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Laba7Ex8 {
    /* Дана упорядоченная по убыванию последовательность целых чисел. Определить,
       есть ли среди членов данной последовательности число x, и если есть, найти номер
       этого члена. */

    @Test
    void test() {
        assertEquals(4, findIndexNumberX(new int[]{1, 4, 2, 3, 6, 9}, 6));

        assertEquals(-1, findIndexNumberX(new int[]{1, 4, 2, 3, 7, 9}, 6));

        assertEquals(-1, findIndexNumberX(new int[]{1}, 6));

        assertEquals(-1, findIndexNumberX(new int[]{1, 2, 3, 4, 7, 9}, 6));

        assertEquals(-1, findIndexNumberX(new int[]{1, 2, 3, 4, 5, 9}, 6));

        assertEquals(2, findIndexNumberX(new int[]{1, 3, 4, 2, 7, 5, 6}, 4));


        assertEquals(4, findIndexNumberXByRecursion(new int[]{1, 4, 2, 3, 6, 9}, 6, 0));

        assertEquals(-1, findIndexNumberXByRecursion(new int[]{1, 4, 2, 3, 8, 9}, 6, 0));

        assertEquals(0, findIndexNumberXByRecursion(new int[]{6}, 6, 0));

        assertEquals(-1, findIndexNumberXByRecursion(new int[]{}, 6, 0));

        assertEquals(2, findIndexNumberXByRecursion(new int[]{1, 3, 4, 2, 7, 5, 6}, 4, 0));
    }

    private int findIndexNumberX(int[] numbersArray, int x) {
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] == x) {
                return i;
            }
        }
    return -1;
    }

    private int findIndexNumberXByRecursion(int[] numberArray, int x, int i) {
        if (i == numberArray.length) {
            return -1;
        }

        if (numberArray[i] == x) {
            return i;
        }
        i++;
    return findIndexNumberXByRecursion(numberArray, x, i);
    }
}
