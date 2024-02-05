package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex6 {

    //Определить, можно ли, переставив члены данной целочисленной последовательности, получить арифметическую прогрессию.
    private static final String NEGATIVE = "НЕТ";
    private static final String POSITIVE = "ДА";

    @Test
    void test() {
        Assertions.assertEquals(POSITIVE, determinesPresenceArithmeticProgression(new int[]{9, 3, 12, 6, 15}));
        Assertions.assertEquals(NEGATIVE, determinesPresenceArithmeticProgression(new int[]{9, 3, 7, 6, 4, 2}));
        Assertions.assertEquals(NEGATIVE, determinesPresenceArithmeticProgression(new int[]{9, 3, 12, 6, 15, 16}));
        Assertions.assertEquals(POSITIVE, determinesPresenceArithmeticProgression(new int[]{3, 6, 9, 12, 15}));
        Assertions.assertEquals(NEGATIVE, determinesPresenceArithmeticProgression(new int[]{1, 2, 3, 4, 15}));
    }

    private String determinesPresenceArithmeticProgression(int[] listNumber) {
        boolean arifmeticProgressFlag = true;

        for (int i = 1; i < listNumber.length; i++) {
            int currentNumber = listNumber[i];
            int j = i;
            while (j > 0 && listNumber[j - 1] > currentNumber) {
                listNumber[j] = listNumber[j - 1];
                j--;
            }
            listNumber[j] = currentNumber;
        }

        for (int step = 1; step < listNumber.length; step++) {

            int difference = listNumber[1] - listNumber[0];

            if (arifmeticProgressFlag && listNumber[step] - listNumber[step - 1] != difference) {
                arifmeticProgressFlag = false;
            }
        }

        return arifmeticProgressFlag ? POSITIVE : NEGATIVE;
    }
}
