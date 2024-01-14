package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex5 {
    // Даны натуральные числа a и b. Определить, могут ли эти числа быть соседними
    //членами последовательности Фибоначчи. Последовательность Фибоначчи задаётся
    //следующим образом:
    //f1 = f2 = 1, fi = fi−1 + fi−2 для i > 2.

    @Test
    void test() {

        Assertions.assertEquals("ДА", adjacentNumbersOfTheFibonacciSequence(new int[]{3, 5}));
        Assertions.assertEquals("ДА", adjacentNumbersOfTheFibonacciSequence(new int[]{5, 3}));
        Assertions.assertEquals("НЕТ", adjacentNumbersOfTheFibonacciSequence(new int[]{0, 0}));
        Assertions.assertEquals("НЕТ, введите 2 числа!", adjacentNumbersOfTheFibonacciSequence(new int[]{0}));
        Assertions.assertEquals("НЕТ, введите 2 числа!", adjacentNumbersOfTheFibonacciSequence(new int[]{0, 0, 12}));
        //Assertions.assertEquals("НЕТ, введите 2 числа!", test(new int[] {j, f}));
        // Как проверить, что пользователь точно ввел числа?

    }

    private String adjacentNumbersOfTheFibonacciSequence(int[] userNumbers) {
        int f1 = 1, f2 = 1, f3 = f1 + f2;
        boolean flagNum = false;

        if (userNumbers.length == 2 && userNumbers[0] > userNumbers[1]) {
            int number3 = userNumbers[0];
            userNumbers[0] = userNumbers[1];
            userNumbers[1] = number3;
        }
        while (userNumbers.length == 2 && f2 <= userNumbers[1]) {
            if (userNumbers[0] == f1) {
                if (userNumbers[1] == f2) {
                    flagNum = true;
                } else
                    flagNum = false;
            }
            f1 = f2;
            f2 = f3;
            f3 = f2 + f1;
        }

        if (flagNum)
            return "ДА";
        else {
            if (userNumbers.length != 2) {
                return "НЕТ, введите 2 числа!";
            } else
                return "НЕТ";
        }
    }
}
