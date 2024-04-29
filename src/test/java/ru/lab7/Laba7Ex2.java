package ru.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba7Ex2 {
    /* Найти номер последнего вхождения минимального значения в последовательность
    длины n. */
    @Test
    void test() {
        assertEquals(6, findIndexOfLastMinNumberIteratively(new int[]{89, 32, 16, 9, 33, 67, 9, 13, 24}));

        assertEquals(9, findIndexOfLastMinNumberIteratively(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));

        assertEquals(9, findIndexOfLastMinNumberIteratively(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 1}));

        assertEquals(-1, findIndexOfLastMinNumberIteratively(new int[]{}));

        assertEquals(0, findIndexOfLastMinNumberIteratively(new int[]{1}));



        assertEquals(4,
                findIndexOfLastMinNumberRecursively(new int[]{4, 6, 8, 2, 1, 9, 4}, 4, 0, 1));

        assertEquals(-1, findIndexOfLastMinNumberRecursively(new int[]{}, 0, 0, 1));

        assertEquals(0,
                findIndexOfLastMinNumberRecursively(new int[]{1, 6, 8, 2, 4, 9, 4}, 1, 0, 1));

        assertEquals(6,
                findIndexOfLastMinNumberRecursively(new int[]{4, 6, 8, 2, 1, 9, 1}, 4, 0, 1));

        assertEquals(0, findIndexOfLastMinNumberRecursively(new int[]{1}, 1, 0, 1));
    }

    private int findIndexOfLastMinNumberIteratively(int[] numberArray) {
        if (numberArray.length < 1) {
            return -1;
        }

        int minNumber = numberArray[0];
        int indexMinNumber = 0;

        for (int i = 1; i < numberArray.length; i++) {
            if (minNumber >= numberArray[i]) {
                minNumber = numberArray[i];
                indexMinNumber = i;
            }
        }

        return indexMinNumber;
    }

    private int findIndexOfLastMinNumberRecursively(int[] numberArray, int minNumber, int indexMinNumber, int i) {
        if (i >= numberArray.length) {
            return numberArray.length == 0 ? -1 : indexMinNumber;
        }

        if (minNumber >= numberArray[i]) {
            minNumber = numberArray[i];
            indexMinNumber = i;
        }

        i++;
        return findIndexOfLastMinNumberRecursively(numberArray, minNumber, indexMinNumber, i);
    }
}
