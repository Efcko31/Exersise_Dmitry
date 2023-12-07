package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex5 {
    // Даны натуральные числа a и b. Определить, могут ли эти числа быть соседними
    //членами последовательности Фибоначчи. Последовательность Фибоначчи задаётся
    //следующим образом:
    //f1 = f2 = 1, fi = fi−1 + fi−2 для i > 2.

    @Test
    void test(){
        Assertions.assertEquals("ДА", test(new int[] {3, 5}));
    }
    private String test(int[] userNumbers){
        int f1 = 1, f2 = 1, f3 = f1 + f2;
        boolean flagNum = false;
        if (userNumbers[0] > userNumbers[1]){
            int number3 = userNumbers[0];
            userNumbers[0] = userNumbers[1];
            userNumbers[1] = number3;
        }
        while (f3 <= userNumbers[1]){
            if(userNumbers[0] == f1){
                if(userNumbers[1] == f2){
                    flagNum = true;
                } else
                    flagNum = false;
            }
        f1 = f2 + f3;
        f2 = f1 + f3;
        f3 = f2 + f1;
        }
        if (flagNum)
            return "ДА";
        else
            return "НЕТ";
    }
}
