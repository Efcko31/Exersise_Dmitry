package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex1 {
//    Дана последовательность целых чисел. Вывести упорядоченную по возрастанию
//    последовательность, состоящую из чисел данной последовательности, стоящих на
//    нечётных местах и встречающихся в ней только один раз.

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{4, 5, 6, 8, 0, 0, 0}, sortInAscendingOrderInOddPlaces(new int[]{1, 2, 3, 8, 1, 6, 7, 7, 7, 9, 9, 5, 2, 4}));
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0}, sortInAscendingOrderInOddPlaces(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0}, sortInAscendingOrderInOddPlaces(new int[]{2, 2, 3, 3, 7, 4, 5, 5, 6, 6, 7, 6, 4, 4}));
    }

    private int[] sortInAscendingOrderInOddPlaces(int[] listNum) {
        int[] answerArray = new int[listNum.length / 2];
        int[] answerArrayForNumberInNoEvenPlace = new int[listNum.length / 2];
        int[] duplicateArray = new int[20];
        int indexAnswerArrayForNumberInNoEvenPlace = 0,
                indexAnswerArray = 0;


        for (int i = 0; i < listNum.length; i++) {
            if (i % 2 != 0) {
                answerArrayForNumberInNoEvenPlace[indexAnswerArrayForNumberInNoEvenPlace] = listNum[i];
                indexAnswerArrayForNumberInNoEvenPlace++;
            }
            for (int j = 0; j < duplicateArray.length; j += 2) {
                if (duplicateArray[j] == listNum[i]) {
                    duplicateArray[j + 1] += 1;
                    j = duplicateArray.length;
                } else if (duplicateArray[j] == 0) {
                    duplicateArray[j] = listNum[i];
                    duplicateArray[j + 1] += 1;
                    j = duplicateArray.length;
                }
            }
        }
        for (int j = 0; j < duplicateArray.length && duplicateArray[j] != 0; j += 2) {
            if (duplicateArray[j + 1] == 1) {
                for (int i = 0; i < answerArrayForNumberInNoEvenPlace.length; i++) {
                    if (duplicateArray[j] == answerArrayForNumberInNoEvenPlace[i]) {
                        answerArray[indexAnswerArray] = duplicateArray[j];
                        indexAnswerArray++;
                        i = answerArrayForNumberInNoEvenPlace.length;
                    }
                }
            }
        }
        sortingByInsertion(answerArray);
        return answerArray;
    }

    private static int[] sortingByInsertion(int[] answerArray) {
        for (int i = 0; i < answerArray.length; i++) {
            int x = answerArray[i];
            int j = i;
            while (j > 0 && answerArray[j - 1] > x && x != 0) {
                answerArray[j] = answerArray[j - 1];
                j--;
            }
            answerArray[j] = x;
        }
        return answerArray;
    }
}