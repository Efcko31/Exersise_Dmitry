package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex3 {
    // Если число x встречается в последовательности, то упорядочить по невозрастанию
    //часть последовательности до последнего вхождения x
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{9, 3, 7, 6, 4, 2}, sortToNumber(new int[]{9, 3, 7, 6, 4, 2}));
        Assertions.assertArrayEquals(new int[]{3, 4, 6, 7, 9, 1, 2}, sortToNumber(new int[]{9, 3, 7, 6, 4, 1, 2}));
        Assertions.assertArrayEquals(new int[]{1, 3, 5, 4, 2, 9, 7}, sortToNumber(new int[]{1, 3, 5, 4, 2, 9, 7}));
    }
    private int[] sortToNumber(int[] listNumber) {
        int x = 1;
        int lastEntranceX = 0;

        for (int i = listNumber.length - 1; i > 0; i--) {
            if (listNumber[i] == x) {
                lastEntranceX = i;
                i = 0;
            }
        }
        sortByChoise(listNumber, lastEntranceX);
        return listNumber;
    }
    private static int[] sortByChoise(int[] numberArray, int lastEntranceX) {
        for (int i = 0; i < numberArray.length; i++) {
            int indexMinimum = searchMinimumValue(numberArray, i, lastEntranceX);
            int numberForReplace = numberArray[i];
            numberArray[i] = numberArray[indexMinimum];
            numberArray[indexMinimum] = numberForReplace;
        }
        return numberArray;
    }
    private static int searchMinimumValue(int[] numberArray, int start, int finish) {
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
