package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.parseInt;

public class Laba3Ex14 {
//    С клавиатуры вводятся целые числа. Признак конца ввода — ноль. Определить число,
//    следующее за последним из отрицательных чисел.

    @Test
    void testEx14() {
        Assertions.assertEquals("5", findingNumberAfterLastNegative(new int[]{1, 3, -1, 2, -4, 5}));
        Assertions.assertEquals("2", findingNumberAfterLastNegative(new int[]{1, 3, -1, 2,}));
        Assertions.assertEquals("5", findingNumberAfterLastNegative(new int[]{10, 3, -1, 2, -4, 5}));
        Assertions.assertEquals("4", findingNumberAfterLastNegative(new int[]{-1, 10, -1, -2, 4, 5}));
        Assertions.assertEquals("NOTHING", findingNumberAfterLastNegative(new int[]{8, 3, -1, 2, -4, -1}));
        Assertions.assertEquals("NOTHING", findingNumberAfterLastNegative(new int[]{-1, -10, -1, -2, -4, -5}));
    }

    private String findingNumberAfterLastNegative(int[] UserNumber) {
        String answer_str = "NOTHING";

        for (int i = UserNumber.length - 1; i != 0  && answer_str.equals("NOTHING"); i--) {
            if (UserNumber[i] < 0 && UserNumber[UserNumber.length - 1] > 0) {
                answer_str = Integer.toString(UserNumber[i + 1]);
            }
        }
        return answer_str;
    }
}
