package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex11 {
    //Дана последовательность целых чисел. Получить упорядоченную по невозрастанию
    //последовательность, состоящую из членов данной последовательности, заключённых
    //между первым и последним отрицательными членами данной последовательности.
    // Последний отрицательный ИСКАТЬ С КОНЦА
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{9, 3, -2, 7, 6, 4, -1, 2}, decreasSequenceBetweenNegativeNumbers(new int[]{9, 3, -2, 4, 7, 6, -1, 2}));
        Assertions.assertArrayEquals(new int[]{-2, 6, -2, -3, -6, -10, 3, 4}, decreasSequenceBetweenNegativeNumbers(new int[]{-2, -2, 6, -3, -6, -10, 3, 4}));
        Assertions.assertArrayEquals(new int[]{-2, 6, 3, -2, -3, -6, -10, -4}, decreasSequenceBetweenNegativeNumbers(new int[]{-2, -2, 6, -3, -6, -10, 3, -4}));
    }

    private int[] decreasSequenceBetweenNegativeNumbers(int[] numberArray) {
        int indexFirstNegativeNumber = -1,
                indexlastNegativeNumber = -1;

        for (int i = 0; i < numberArray.length && indexFirstNegativeNumber == -1; i++){
            if(numberArray[i] < 0){
                indexFirstNegativeNumber = i;
            }
        }
        for (int i = numberArray.length -1; i > 0 && indexlastNegativeNumber == -1; i--){
            if(numberArray[i] < 0){
                indexlastNegativeNumber = i;
            }
        }

        for (int i = indexFirstNegativeNumber + 1; i < numberArray.length - 1; i++) {
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