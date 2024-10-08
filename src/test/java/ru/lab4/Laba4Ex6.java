package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.TRUE;

public class Laba4Ex6 {

    //Определить, можно ли, переставив члены данной целочисленной последовательности, получить арифметическую прогрессию.
    private static final String NEGATIVE = "НЕТ";
    private static final String POSITIVE = "ДА";

    @Test
    void test() {
        Assertions.assertTrue(determinesPresenceArithmeticProgression(new int[]{9, 3, 12, 6, 15}));
        Assertions.assertFalse(determinesPresenceArithmeticProgression(new int[]{9, 3, 7, 6, 4, 2}));
        Assertions.assertFalse(determinesPresenceArithmeticProgression(new int[]{9, 3, 12, 6, 15, 16}));
        Assertions.assertTrue(determinesPresenceArithmeticProgression(new int[]{3, 6, 9, 12, 15}));
        Assertions.assertFalse(determinesPresenceArithmeticProgression(new int[]{1, 2, 3, 4, 15}));
    }

    private boolean determinesPresenceArithmeticProgression(int[] listNumber) {
        boolean arifmeticProgressFlag = true;

        for (int i = 0; i < listNumber.length && arifmeticProgressFlag; i++) {
            int indexMinNumber = searchMinimumNumber(listNumber, i);
            int numberForReplace = listNumber[i];
            listNumber[i] = listNumber[indexMinNumber];
            listNumber[indexMinNumber] = numberForReplace;

            int difference = listNumber[1] - listNumber[0];
            if (i > 0 && listNumber[i] - listNumber[i - 1] != difference) {
                arifmeticProgressFlag = false;
            }

        }
        return arifmeticProgressFlag;
    }

    private static int searchMinimumNumber(int[] numberArray, int step) {
        int minValue = numberArray[step], minIndex = step;
        for (int i = step; i < numberArray.length; i++) {
            if (minValue > numberArray[i]) {
                minIndex = i;
                minValue = numberArray[i];
            }
        }
        return minIndex;
    }
}
