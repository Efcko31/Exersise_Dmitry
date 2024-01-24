package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex10 {
    //    Дано целое число n, удовлетворяющее условию 0 <= |n| <= 2 · 10**9
//. Найти произведение  отличных от нуля цифр данного числа.
    @Test
    void test() {
        Assertions.assertEquals(120, searchingProductNonZeroDigitsNumber(456));
        Assertions.assertEquals(1, searchingProductNonZeroDigitsNumber(0));
        Assertions.assertEquals(3360, searchingProductNonZeroDigitsNumber(1020580706));
    }

    private int searchingProductNonZeroDigitsNumber(int userNumber) {
        int answer = 1;
        for (int i = 0; i < userNumber && userNumber > 1; i++) {
            if (userNumber % 10 != 0) {
                answer = answer * (userNumber % 10);
                userNumber /= 10;
            } else
                userNumber /= 10;
        }
        return answer;
    }
}
