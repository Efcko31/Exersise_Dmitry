package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex10 {
    //    Дано целое число n, удовлетворяющее условию 0 <= |n| <= 2 · 10**9
//. Найти произведение  отличных от нуля цифр данного числа.
    @Test
    void test() {
        Assertions.assertEquals(120, Ex10(456));
        Assertions.assertEquals(1, Ex10(0));
        Assertions.assertEquals(3360, Ex10(1020580706));
    }

    private int Ex10(int userNumber) {
        int answer = 1;
        for (int i = 0; i < userNumber; i++) {
            if (userNumber < 1)
                break;
            else {
                if (userNumber % 10 != 0) {
                    answer = answer * (userNumber % 10);
                    userNumber /= 10;
                } else
                    userNumber /= 10;
            }
        }
        return answer;
    }
}
