package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex13 {
//    Дано целое неотрицательное число n, удовлетворяющее условию 0 < n <= 2 · 10**9.
//Определить количество нулей, которыми заканчивается запись числа n. Вывести n в виде a*10^k,
// где a — целое, не содержащее нуля в конце записи числа; k — количество нулей в конце записи числа n.
// Например, 130 000 = 13*10^4.

    @Test
    void test() {
        Assertions.assertEquals("13*10^4", definesNumberZerosAndOutputNumber(130000));
        Assertions.assertEquals("2345*10^2", definesNumberZerosAndOutputNumber(234500));
        Assertions.assertEquals("1*10^6", definesNumberZerosAndOutputNumber(1000000));
        Assertions.assertEquals("1*10^0", definesNumberZerosAndOutputNumber(1));
        Assertions.assertEquals("202*10^3", definesNumberZerosAndOutputNumber(202000));
        Assertions.assertEquals("1*10^1", definesNumberZerosAndOutputNumber(10));
    }

    private String definesNumberZerosAndOutputNumber(int userNumber) {
        int total_zero = 0;
        String answer = "";

        while (userNumber % 10 == 0) {
            userNumber /= 10;
            total_zero++;
        }
        answer = answer.concat(Integer.toString(userNumber));
        answer = answer.concat("*10^");
        answer = answer.concat(Integer.toString(total_zero));

        return answer;
    }
}
