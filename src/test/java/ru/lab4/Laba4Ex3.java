package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex3 {
    // Если число x встречается в последовательности, то упорядочить по невозрастанию
    //часть последовательности до последнего вхождения x
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{9, 3, 7, 6, 4, 2}, sortingToNumber(new int[]{9, 3, 7, 6, 4, 2}));
        Assertions.assertArrayEquals(new int[]{3, 4, 6, 7, 9, 1, 2}, sortingToNumber(new int[]{9, 3, 7, 6, 4, 1, 2}));
        Assertions.assertArrayEquals(new int[]{1, 3, 5, 4, 2, 9, 7}, sortingToNumber(new int[]{1, 3, 5, 4, 2, 9, 7}));
    }

    private int[] sortingToNumber(int[] listNumber) {
        int x = 1;
        int indexX = 0;

        for (int i = 0; i < listNumber.length; i++) {
            if (listNumber[i] == x) {
                indexX = i;
            }
        }
        for (int step = 0; step < listNumber.length; step++) {
            int indexMinimum = min(listNumber, step, indexX);

            int numberForReplace = listNumber[step];
            listNumber[step] = listNumber[indexMinimum];
            listNumber[indexMinimum] = numberForReplace;

        }
        return listNumber;
    }

    private static int min(int[] numberArray, int start, int finish) {
        int minIndex = start, minValue = numberArray[start];
        for (int j = start; j < finish; j++) {
            if (minValue > numberArray[j]) {
                minValue = numberArray[j];
                minIndex = j;
            }
        }
        return minIndex;
    }
}
