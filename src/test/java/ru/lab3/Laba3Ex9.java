package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex9 {
    //С клавиатуры вводятся целые числа. Признак конца ввода — ноль. Определить число, предшествующее первому из введённых максимальных значений.

    @Test
    void test() {
        Assertions.assertEquals("3", searchNumberPrecedingMaximum(new int[]{1, 2, 3, 4, 0, 6, 8, 9, 0}));
        Assertions.assertEquals("NOTHING", searchNumberPrecedingMaximum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        Assertions.assertEquals("NOTHING", searchNumberPrecedingMaximum(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
        Assertions.assertEquals("2", searchNumberPrecedingMaximum(new int[]{1, 2, 3}));
        Assertions.assertEquals("1", searchNumberPrecedingMaximum(new int[]{1, 3, 3}));
    }

    private String searchNumberPrecedingMaximum(int[] userNumber) {
        String answer = "NOTHING";
        int maxNumber = userNumber[0] - 1;
        for (int i = 0; i < userNumber.length && userNumber[i] != 0; i++) {
            if (userNumber[i] > maxNumber) {
                maxNumber = userNumber[i];
                if (i > 0)
                    answer = Integer.toString(userNumber[i - 1]);
            }
        }
        return answer;
    }
}
