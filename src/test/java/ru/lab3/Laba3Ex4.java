package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex4 {
    // Определить, является ли данное натуральное число простым числом
    @Test
    void test() {
        Assertions.assertEquals("Является", checkingNumberForSimplicity(17));
        Assertions.assertEquals("Не является", checkingNumberForSimplicity(12));
        Assertions.assertEquals("Ни простое, Ни составное", checkingNumberForSimplicity(0));
        Assertions.assertEquals("Ни простое, Ни составное", checkingNumberForSimplicity(1));
        Assertions.assertEquals("Не является", checkingNumberForSimplicity(289));
        Assertions.assertEquals("Не является", checkingNumberForSimplicity(9));
    }

    private String checkingNumberForSimplicity(int user_number) {
        int totalNum = 0;
        for (int i = 2; i <= user_number / 2 && totalNum <= 2; i++) {
            if (user_number % i == 0)
                totalNum++;
        }
        if (totalNum >= 1 && user_number != 0 && user_number != 1)
            return "Не является";
        else if (totalNum == 0 && user_number != 0 && user_number != 1) {
            return "Является";
        } else
            return "Ни простое, Ни составное";
    }
}
