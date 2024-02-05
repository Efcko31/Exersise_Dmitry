package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex4 {
    //Дана последовательность целых чисел, содержащая как положительные, так и отрицательные элементы. Упорядочить последовательность следующим образом: сначала
    //идут отрицательные числа, упорядоченные по невозрастанию, потом положительные, упорядоченные по неубыванию.
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{-7, -9, 2, 3, 4, 6}, sortNegativeDescendingOrderPositiveAscendingOrder(new int[]{-9, 3, -7, 6, 4, 2}));
        Assertions.assertArrayEquals(new int[]{-9, 2, 3, 4, 6, 7}, sortNegativeDescendingOrderPositiveAscendingOrder(new int[]{-9, 3, 7, 6, 4, 2}));
        Assertions.assertArrayEquals(new int[]{-3, -4, -6, -7, -9, 2}, sortNegativeDescendingOrderPositiveAscendingOrder(new int[]{-9, -3, -7, -6, -4, 2}));
        Assertions.assertArrayEquals(new int[]{2, 3, 4, 6, 7, 9}, sortNegativeDescendingOrderPositiveAscendingOrder(new int[]{9, 3, 7, 6, 4, 2}));
        Assertions.assertArrayEquals(new int[]{-6, -7, -8, -9, 1, 2, 3, 4, 5}, sortNegativeDescendingOrderPositiveAscendingOrder(new int[]{1, -8, 4, -6, 5, -9, 3, 2, -7}));
    }

    private int[] sortNegativeDescendingOrderPositiveAscendingOrder(int[] listNumber) {
        int indexFirstPositiveNumber = 0;

        for (int step = 0; step < listNumber.length; step++) {
            int indexMin = min(listNumber, step);

            int numberReplaceForMin = listNumber[step];
            listNumber[step] = listNumber[indexMin];
            listNumber[indexMin] = numberReplaceForMin;

            if (step > 0 && listNumber[step] > 0 && listNumber[step - 1] < 0) {
                indexFirstPositiveNumber = step;
            }
        }
        for (int negativeStep = 0; negativeStep < indexFirstPositiveNumber; negativeStep++) {
            int indexMax = max(listNumber, negativeStep, indexFirstPositiveNumber);

            int numberReplaceForMax = listNumber[negativeStep];
            listNumber[negativeStep] = listNumber[indexMax];
            listNumber[indexMax] = numberReplaceForMax;
        }
        return listNumber;
    }

    private static int min(int[] numberArray, int start) {
        int minIndex = start, minValue = numberArray[start];
        for (int i = start; i < numberArray.length; i++) {
            if (minValue > numberArray[i]) {
                minValue = numberArray[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int max(int[] numberArray, int start, int finish) {
        int maxIndex = start, maxValue = numberArray[start];
        for (int j = start; j < finish; j++) {
            if (maxValue < numberArray[j]) {
                maxValue = numberArray[j];
                maxIndex = j;
            }
        }
        return maxIndex;
    }
}
