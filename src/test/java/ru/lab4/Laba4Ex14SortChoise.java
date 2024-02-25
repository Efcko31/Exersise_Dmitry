package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex14SortChoise {
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 9}, arrangeInAscendingOrder(new int[]{9, 3, 2, 7, 6, 4, 1, 5}));
        Assertions.assertArrayEquals(new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4}, arrangeInAscendingOrder(new int[]{3, -3, -2, 2, 0, -4, -1, 1, 4}));
        Assertions.assertArrayEquals(new int[]{3, 3}, arrangeInAscendingOrder(new int[]{3, 3}));
    }

    private int[] arrangeInAscendingOrder(int[] numberArray) {
        for (int i = 0; i < numberArray.length; i++) {
            int indexMinNumber = searchMinimumValue(numberArray, i);
            int numberReplace = numberArray[i];
            numberArray[i] = numberArray[indexMinNumber];
            numberArray[indexMinNumber] = numberReplace;
        }
        return numberArray;
    }
    private static int searchMinimumValue(int[] numberArray, int start) {
        int minIndex = start, minValue = numberArray[start];
        for (int i = start; i < numberArray.length; i++) {
            if (minValue > numberArray[i]) {
                minValue = numberArray[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
