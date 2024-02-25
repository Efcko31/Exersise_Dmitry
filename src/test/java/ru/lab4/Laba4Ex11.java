package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex11 {
    //Дана последовательность целых чисел. Получить упорядоченную по невозрастанию
    //последовательность, состоящую из членов данной последовательности, заключённых
    //между первым и последним отрицательными членами данной последовательности.
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{9, 3, -2, 7, 6, 4, -1, 2}, decreasSequenceBetweenNegativeNumbers(new int[]{9, 3, -2, 4, 7, 6, -1, 2}));
        Assertions.assertArrayEquals(new int[]{-2, 6, -2, -3, -6, -10, 3, 4}, decreasSequenceBetweenNegativeNumbers(new int[]{-2, -2, 6, -3, -6, -10, 3, 4}));
        Assertions.assertArrayEquals(new int[]{-2, 6, 3, -2, -3, -6, -10, -4}, decreasSequenceBetweenNegativeNumbers(new int[]{-2, -2, 6, -3, -6, -10, 3, -4}));

    }

    private int[] decreasSequenceBetweenNegativeNumbers(int[] numberArray) {
        int indexFirstNegativeNumber = 0, firstNegativeNumber = 0, indexNumberArray = 0, lastNegativeNumber = 0, indexlastNegativeNumber = 0;

        for (int j = 0; j < numberArray.length; j++) {
            if (numberArray[j] < 0 && firstNegativeNumber == 0) {
                indexFirstNegativeNumber = j + 1;
                firstNegativeNumber = numberArray[j];
            } else if (numberArray[j] < 0) {
                lastNegativeNumber = numberArray[j];
                indexlastNegativeNumber = j;
            }
        }

        for (int i = indexFirstNegativeNumber; i < numberArray.length - 1; i++) {
            int indexMaxNumber = searchMaximumValue(numberArray, i, indexlastNegativeNumber);

            int numberReplace = numberArray[i];
            numberArray[i] = numberArray[indexMaxNumber];
            numberArray[indexMaxNumber] = numberReplace;
        }
        return numberArray;
    }

    private static int searchMaximumValue(int[] array, int start, int stop) {
        int maxIndex = start, maxValue = array[start];
        for (int j = start; j < stop; j++) {
            if (maxValue < array[j]) {
                maxValue = array[j];
                maxIndex = j;
            }
        }
        return maxIndex;
    }
}