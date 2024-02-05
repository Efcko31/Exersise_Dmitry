package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex11 {
    //Дана последовательность целых чисел. Получить упорядоченную по невозрастанию
    //последовательность, состоящую из членов данной последовательности, заключённых
    //между первым и последним отрицательными членами данной последовательности.
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{-2, 9, 7, 6, 4, 3, 2, -1}, decreasingSequenceBetweenNegativeNumbers(new int[]{9, 3, -2, 7, 6, 4, -1, 2}));
        Assertions.assertArrayEquals(new int[]{-2, 6, 4, 3, 2, -3, -6, -10}, decreasingSequenceBetweenNegativeNumbers(new int[]{2, -2, 6, -3, -6, -10, 3, 4}));
        Assertions.assertArrayEquals(new int[]{-9, -1, -2, -3, -4, -6, -7, -8}, decreasingSequenceBetweenNegativeNumbers(new int[]{-9, -3, -2, -7, -6, -4, -1, -8}));
        Assertions.assertArrayEquals(new int[]{-3, -2}, decreasingSequenceBetweenNegativeNumbers(new int[]{-3, -2}));
    }

    private int[] decreasingSequenceBetweenNegativeNumbers(int[] numberArray) {
        int firstNegativeNumber = 0, indexNumberArray = 0, lastNegativeNumber = 0, indexlastNegativeNumber = 0;

        while (indexNumberArray < numberArray.length) {
            if (firstNegativeNumber == 0 && numberArray[indexNumberArray] < 0) {
                firstNegativeNumber = numberArray[indexNumberArray];
                numberArray[indexNumberArray] = numberArray[0];
                numberArray[0] = firstNegativeNumber;
                indexNumberArray++;
            } else if (numberArray[indexNumberArray] < 0) {
                lastNegativeNumber = numberArray[indexNumberArray];
                indexlastNegativeNumber = indexNumberArray;
                indexNumberArray++;
            } else {
                indexNumberArray++;
            }
            if (lastNegativeNumber != 0 && indexNumberArray == numberArray.length) {
                numberArray[indexlastNegativeNumber] = numberArray[numberArray.length - 1];
                numberArray[numberArray.length - 1] = lastNegativeNumber;
            }
        }


        for (int step = 1; step < numberArray.length - 1; step++) {
            int indexMinNumber = max(numberArray, step);

            int numberReplace = numberArray[step];
            numberArray[step] = numberArray[indexMinNumber];
            numberArray[indexMinNumber] = numberReplace;
        }
        return numberArray;
    }

    private static int max(int[] array, int start) {
        int maxIndex = start, maxValue = array[start];
        for (int j = start; j < array.length - 1; j++) {
            if (maxValue < array[j]) {
                maxValue = array[j];
                maxIndex = j;
            }
        }
        return maxIndex;
    }
}
