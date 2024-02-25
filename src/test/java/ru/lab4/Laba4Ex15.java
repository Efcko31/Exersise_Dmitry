package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex15 {
    //Если в целочисленной последовательности нет других чисел кроме x, y, z, то упорядочить последовательность по невозрастанию

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{8, 6, 3}, CheckingForNumbersAndSorting(new int[]{3, 8, 6}, 3, 6, 8));
        Assertions.assertArrayEquals(new int[]{8, 6, 6, 3, 3}, CheckingForNumbersAndSorting(new int[]{3, 3, 8, 6, 6}, 3, 6, 8));
        Assertions.assertArrayEquals(new int[]{3, 8, 6, 4}, CheckingForNumbersAndSorting(new int[]{3, 8, 6, 4}, 3, 6, 8));
    }

    private int[] CheckingForNumbersAndSorting(int[] numberArray, int x, int y, int z) {
        int checkArrayLenght = 0;
        int[] checkArray = new int[numberArray.length];
        int[] answerArray = new int[]{};

        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] == x | numberArray[i] == y | numberArray[i] == z) {
                checkArray[checkArrayLenght] = numberArray[i];
                checkArrayLenght++;
                answerArray = sortingByBubble(checkArray);
            } else {
                return numberArray;
            }
        }
        return answerArray;
    }

    private static int[] sortingByBubble(int[] numberArray) {
        boolean flagStopSort = false;
        while (!flagStopSort) {
            flagStopSort = true;
            for (int i = 1; i < numberArray.length; i++) {
                int numberForReplace = numberArray[i];
                if ((numberArray[i] > numberArray[i - 1]) && numberArray[i] != 0) {
                    numberArray[i] = numberArray[i - 1];
                    numberArray[i - 1] = numberForReplace;
                    flagStopSort = false;
                }
            }
        }
        return numberArray;
    }
}
