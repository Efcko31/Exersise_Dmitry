package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex15 {
    //Если в целочисленной последовательности нет других чисел кроме x, y, z, то упорядочить последовательность по невозрастанию

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{8, 6, 3}, CheckingForNumbersAndSorting(new int[]{3, 8, 6}));
        Assertions.assertArrayEquals(new int[]{3, 8, 6, 4}, CheckingForNumbersAndSorting(new int[]{3, 8, 6, 4}));
    }

    private int[] CheckingForNumbersAndSorting(int[] numberArray) {
        int x = 3, y = 6, z = 8;
        boolean flagOtherNumbers = false;

        for (int i : numberArray) {
            if (!flagOtherNumbers) {
                if (i == x | i == y | i == z) {
                    flagOtherNumbers = false;
                } else {
                    flagOtherNumbers = true;
                }
            }
        }
        if (flagOtherNumbers) {
            return numberArray;
        } else {
            return sortingByChoice(numberArray);
        }
    }

    private static int[] sortingByChoice(int[] numberArray) {
        for (int step = 0; step < numberArray.length; step++) {
            int index = max(numberArray, step);

            int numberForReplace = numberArray[step];
            numberArray[step] = numberArray[index];
            numberArray[index] = numberForReplace;
        }
        return numberArray;
    }

    private static int max(int[] array, int start) {
        int maxIndex = start, maxValue = array[start];
        for (int i = start; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxIndex = i;
                maxValue = array[i];
            }
        }
        return maxIndex;
    }
}
