package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex1 {
//    Дана последовательность целых чисел. Вывести упорядоченную по возрастанию
//    последовательность, состоящую из чисел данной последовательности, стоящих на
//    нечётных местах и встречающихся в ней только один раз.
    // протий исходную последовательность ТОЛЬКО 1 раз.
    // создать 3-й массив, для вставки дублирующихся чисел.

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{4, 5, 6, 8, 0, 0, 0}, sortInAscendingOrderInOddPlaces(new int[]{1, 2, 3, 8, 1, 6, 7, 7, 7, 9, 9, 5, 2, 4}));

    }

    private int[] sortInAscendingOrderInOddPlaces(int[] listNum) {
        int[] answerArray = new int[listNum.length / 2];
        int[] duplicateArray = new int[listNum.length];
        int indexAnswerArray = 0;
        int indexDuplicateArray = 0;


        for (int j = 0; j < listNum.length; j++) {
            for (int i = 0; i < answerArray.length; i++) {
                if (listNum[j] == answerArray[i]) {
                    duplicateArray[indexDuplicateArray] = listNum[j];
                    indexDuplicateArray++;
                }
            }
            if (j % 2 != 0) {
                answerArray[indexAnswerArray] = listNum[j];
                indexAnswerArray++;
            }
            sortingByInsertion(answerArray);
        }
        for (int i = 0; i < answerArray.length; i++) {
            for (int j = 0; j < duplicateArray.length; j++) {
                if (answerArray[i] == duplicateArray[j]) {
                    answerArray[i] = 0;
                    int indexDuplicateNumberReplaceZero = i;
                    while (indexDuplicateNumberReplaceZero < answerArray.length - 1) {
                        int numberForReplace = answerArray[indexDuplicateNumberReplaceZero];
                        answerArray[indexDuplicateNumberReplaceZero] = answerArray[indexDuplicateNumberReplaceZero + 1];
                        answerArray[indexDuplicateNumberReplaceZero + 1] = numberForReplace;
                        indexDuplicateNumberReplaceZero++;
                    }
                }
            }
        }
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