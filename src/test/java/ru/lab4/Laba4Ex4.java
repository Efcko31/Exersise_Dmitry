package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex4 {
    //Дана последовательность целых чисел, содержащая как положительные, так и отрицательные элементы. Упорядочить последовательность следующим образом: сначала
    //идут отрицательные числа, упорядоченные по невозрастанию, потом положительные, упорядоченные по неубыванию.
    // Сначала сортировать числа отрицательные, затем, начиная с последнего вхождения отричательного числа - отсортировать положительные.
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{-7, -9, 2, 3, 4, 5, 6}, sortNegativeDescendingOrderAndPositiveAscendingOrder(new int[]{3, -9, 5, -7, 2, 4, 6}));
        Assertions.assertArrayEquals(new int[]{-9, 2, 3, 4, 6, 7}, sortNegativeDescendingOrderAndPositiveAscendingOrder(new int[]{-9, 3, 7, 6, 4, 2}));
        Assertions.assertArrayEquals(new int[]{-3, -4, -6, -7, -9, 2}, sortNegativeDescendingOrderAndPositiveAscendingOrder(new int[]{-9, -3, -7, -6, -4, 2}));
        Assertions.assertArrayEquals(new int[]{2, 3, 4, 6, 7, 9}, sortNegativeDescendingOrderAndPositiveAscendingOrder(new int[]{9, 3, 7, 6, 4, 2}));
        Assertions.assertArrayEquals(new int[]{-6, -7, -8, -9, 1, 2, 3, 4, 5}, sortNegativeDescendingOrderAndPositiveAscendingOrder(new int[]{1, -8, 4, -6, 5, -9, 3, 2, -7}));
    }

    private int[] sortNegativeDescendingOrderAndPositiveAscendingOrder(int[] listNumber) {
        int indexNegativeNumber = 0;

        for (int i = 0; i < listNumber.length; i++) {
            if (i > 0 && listNumber[i] < 0) {
                int numberForReaplace = listNumber[i];
                listNumber[i] = listNumber[indexNegativeNumber];
                listNumber[indexNegativeNumber] = numberForReaplace;
                indexNegativeNumber++;
                sortingByInsertionForNegativeNumber(listNumber, indexNegativeNumber);
            }
        }
        sortingByInsertionForPositiveNumber(listNumber, indexNegativeNumber);
        return listNumber;
    }

    private static int[] sortingByInsertionForNegativeNumber(int[] answerArray, int finish) {
        for (int i = 0; i < finish; i++) {
            int x = answerArray[i];
            int j = i;
            while (j > 0 && answerArray[j - 1] < x) {
                answerArray[j] = answerArray[j - 1];
                j--;
            }
            answerArray[j] = x;
        }
        return answerArray;
    }

    private static int[] sortingByInsertionForPositiveNumber(int[] answerArray, int start) {
        for (int i = start; i < answerArray.length; i++) {
            int x = answerArray[i];
            int j = i;
            while (j > start && answerArray[j - 1] > x && x != 0) {
                answerArray[j] = answerArray[j - 1];
                j--;
            }
            answerArray[j] = x;
        }
        return answerArray;
    }
}
