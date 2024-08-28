package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex19 {
    //Из последовательности целых чисел вывести в порядке возрастания все числа,
    //стоящие на чётных местах и встречающиеся более двух раз
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{3, 4, 5, 0, 0}, sortingNumbersInEvenPlacesMoreThanTwice(new int[]{3, 7, 8, 6, 4, 5, 5, 5, 4, 6, 4, 9, 2, 9, 2, 1, 3, 5, 3}));
        Assertions.assertArrayEquals(new int[]{3, 0, 0, 0, 0}, sortingNumbersInEvenPlacesMoreThanTwice(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}));
    }

    private int[] sortingNumbersInEvenPlacesMoreThanTwice(int[] numberArray) {
        int[] numbersArrayInEvenPlaces = new int[(numberArray.length + 1) / 2];
        int[] answerArray = new int[(numbersArrayInEvenPlaces.length + 1) / 2];
        int[] arrayDuplicate = new int[20];
        int indexAnswerArray = 0;

        for (int i = 0; i < numberArray.length; i++) {
            if (i % 2 == 0) {
                numbersArrayInEvenPlaces[i - (i / 2)] = numberArray[i];
            }
            for (int j = 0; j < arrayDuplicate.length; j += 2) {
                if (arrayDuplicate[j] == numberArray[i]) {
                    arrayDuplicate[j + 1] += 1;
                    j = arrayDuplicate.length;
                } else if (arrayDuplicate[j] == 0) {
                    arrayDuplicate[j] = numberArray[i];
                    arrayDuplicate[j + 1] += 1;
                    j = arrayDuplicate.length;
                }
            }
        }
        sortByChoice(numbersArrayInEvenPlaces);

        for (int j = 0; j < arrayDuplicate.length; j += 2) {
            if (arrayDuplicate[j + 1] > 2) {
                for (int i = 0; i < numbersArrayInEvenPlaces.length; i++) {
                    if (arrayDuplicate[j] != 0 && arrayDuplicate[j] == numbersArrayInEvenPlaces[i]) {
                        answerArray[indexAnswerArray] = arrayDuplicate[j];
                        indexAnswerArray++;
                        i = numbersArrayInEvenPlaces.length;
                    }
                }
            }
        }
        return answerArray;
    }

    private static int searchMinimumValue(int[] array, int start) {
        int minIndex = start, minValue = array[start];
        for (int i = start; i < array.length; i++) {
            if (array[i] != 0 && minValue > array[i]) {
                minIndex = i;
                minValue = array[i];
            }
        }
        return minIndex;
    }

    private static void sortByChoice(int[] numberArray) {
        for (int i = 0; i < numberArray.length; i++) {
            int minIndexNumberArray = searchMinimumValue(numberArray, i);

            int numberReplace = numberArray[i];
            numberArray[i] = numberArray[minIndexNumberArray];
            numberArray[minIndexNumberArray] = numberReplace;
        }
    }
}
