package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex1 {
//    Дана последовательность целых чисел. Вывести упорядоченную по возрастанию
//    последовательность, состоящую из чисел данной последовательности, стоящих на
//    нечётных местах и встречающихся в ней только один раз.

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{2, 3, 6}, sortInAscendingOrderInOddPlaces(new int[]{9, 3, 7, 6, 4, 2}));
        Assertions.assertArrayEquals(new int[]{2, 3, 8, 0}, sortInAscendingOrderInOddPlaces(new int[]{9, 3, 7, 3, 4, 2, 6, 8}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 8, 0}, sortInAscendingOrderInOddPlaces(new int[]{9, 3, 7, 1, 4, 3, 6, 8, 2, 2}));
        Assertions.assertArrayEquals(new int[]{3, 0}, sortInAscendingOrderInOddPlaces(new int[]{9, 3, 7, 3}));
        Assertions.assertArrayEquals(new int[]{3}, sortInAscendingOrderInOddPlaces(new int[]{9, 3, 7}));
        Assertions.assertArrayEquals(new int[]{3, 0, 0, 0}, sortInAscendingOrderInOddPlaces(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 0, 0}, sortInAscendingOrderInOddPlaces(new int[]{1, 1, 1, 3, 3, 3, 3, 2, 2, 2, 2}));
    }

    private int[] sortInAscendingOrderInOddPlaces(int[] listNum) {
        int[] answerArray = new int[listNum.length / 2];
        int indexAnswerArray = 0;
        int indexForNumberReplace = 1;
        int indexDuplicateNumber = 1;

        for (int j = 1; j < listNum.length; j += 2) {
            answerArray[indexAnswerArray] = listNum[j];
            indexAnswerArray++;
        }
        for (int step = 0; step < answerArray.length; step++) {
            int index = min(answerArray, step);
            int numberReplace = answerArray[step];

            answerArray[step] = answerArray[index];
            answerArray[index] = numberReplace;
        }
        while (indexDuplicateNumber <= (answerArray.length - 1)) {
            if (answerArray[indexDuplicateNumber] == answerArray[indexDuplicateNumber - 1] && answerArray[indexDuplicateNumber] != 0) {
                answerArray[indexDuplicateNumber] = answerArray[answerArray.length - indexForNumberReplace];
                answerArray[answerArray.length - indexForNumberReplace] = 0;
                indexForNumberReplace++;
            } else {
                indexDuplicateNumber++;
            }
        }
        return answerArray;
    }

    private static int min(int[] answerArray, int start) {
        int minIndex = start, minValue = answerArray[start];
        for (int i = start; i < answerArray.length; i++) {
            if (minValue > answerArray[i]) {
                minValue = answerArray[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
