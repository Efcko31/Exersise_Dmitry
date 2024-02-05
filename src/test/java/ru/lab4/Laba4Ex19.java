package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex19 {
    //Из последовательности целых чисел вывести в порядке возрастания все числа,
    //стоящие на чётных местах и встречающиеся более двух раз
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{3, 4, 0, 0, 0}, sortingNumbersInEvenPlacesMoreThanTwice(new int[]{3, 7, 8, 6, 4, 5, 4, 6, 4, 9, 2, 9, 2, 1, 3, 5, 3}));
        Assertions.assertArrayEquals(new int[]{3, 0, 0, 0, 0}, sortingNumbersInEvenPlacesMoreThanTwice(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}));
    }

    private int[] sortingNumbersInEvenPlacesMoreThanTwice(int[] numberArray) {
        int[] numbersArrayInEvenPlaces = new int[(numberArray.length + 1) / 2];
        int[] answerArray = new int[(numbersArrayInEvenPlaces.length + 1) / 2];
        int totalDuplicateNumbers = 1, indexAnswerArray = 0;

        for (int i = 0; i < numberArray.length; i += 2) {
            numbersArrayInEvenPlaces[i - (i / 2)] = numberArray[i];
        }

        for (int step = 0; step < numbersArrayInEvenPlaces.length; step++) {
            int minIndexNumberArray = min(numbersArrayInEvenPlaces, step);

            int numberReplace = numbersArrayInEvenPlaces[step];
            numbersArrayInEvenPlaces[step] = numbersArrayInEvenPlaces[minIndexNumberArray];
            numbersArrayInEvenPlaces[minIndexNumberArray] = numberReplace;

            if (step > 0 && numbersArrayInEvenPlaces[step] == numbersArrayInEvenPlaces[step - 1] && step + 1 != numbersArrayInEvenPlaces.length) {
                totalDuplicateNumbers++;
            } else {
                if (totalDuplicateNumbers > 2) {
                    answerArray[indexAnswerArray] = numbersArrayInEvenPlaces[step - 1];
                    indexAnswerArray++;
                    totalDuplicateNumbers = 1;
                } else {
                    totalDuplicateNumbers = 1;
                }
            }
        }
        return answerArray;
    }

    private static int min(int[] array, int start) {
        int minIndex = start, minValue = array[start];
        for (int i = start; i < array.length; i++) {
            if (array[i] != 0 && minValue > array[i]) {
                minIndex = i;
                minValue = array[i];
            }
        }
        return minIndex;
    }
}
