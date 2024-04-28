package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Дано целое число n, удовлетворяющее условию 0 < |n| 6 2 · 10**9
//. Найти максимальную цифру в записи этого числа
public class Laba3Ex3 {
    @Test
    void test() {
        Assertions.assertEquals(7, findingMaximumDigitInNumber(275));
        Assertions.assertEquals(0, findingMaximumDigitInNumber(0));
        Assertions.assertEquals(7, findingMaximumDigitInNumber(752));
        Assertions.assertEquals(7, findingMaximumDigitInNumber(7));
        Assertions.assertEquals(9, findingMaximumDigitInNumber(987654321));
        Assertions.assertEquals(9, findingMaximumDigitInNumber(123456789));
        Assertions.assertEquals(9, findingMaximumDigitInNumber(123496785));
    }

    private int findingMaximumDigitInNumber(int number) {
        int maxNumber = 0;
        while (number != 0 && maxNumber != 9) {
            if (number != 0 && maxNumber < number % 10) {
                maxNumber = number % 10;
                number = number / 10;
            } else {
                number = number / 10;
            }
        }
        return maxNumber;
    }
}
