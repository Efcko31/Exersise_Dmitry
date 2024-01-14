package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex12 {
    //    С клавиатуры вводятся целые числа. Признак конца ввода — ноль.
//    Определить количество введённых нечётных чисел после последнего отрицательного.
    @Test
    void test() {
        Assertions.assertEquals(3, numberOddNumbersAfterLastNegative(new int[]{1, 2, -1, 3, 5, 7}));
        Assertions.assertEquals(4, numberOddNumbersAfterLastNegative(new int[]{1, 2, -1, 3, 5, 7, -6, 5, 7, 9, 11}));
        Assertions.assertEquals(2, numberOddNumbersAfterLastNegative(new int[]{1, 2, -1, 3, 10, 7}));
        Assertions.assertEquals(2, numberOddNumbersAfterLastNegative(new int[]{0, 2, -1, 3, 10, 7}));
        Assertions.assertEquals(2, numberOddNumbersAfterLastNegative(new int[]{-1, 2, -1, 3, 10, 7}));
        Assertions.assertEquals(0, numberOddNumbersAfterLastNegative(new int[]{1, 2, 1, 3, 10, -7}));

    }

    private int numberOddNumbersAfterLastNegative(int[] userNumber) {
        int total = 0;

        for (int i = userNumber.length - 1; i != 0 && userNumber[i] > 0; i--) {
            if (userNumber[i] % 2 != 0) {
                total++;
            }
        }
        return total;
    }
}
