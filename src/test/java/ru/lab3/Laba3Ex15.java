package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex15 {
// Дано целое число n, удовлетворяющее условию 0 < |n| <= 2 · 10**9.
// Найти сумму цифр числа n.
    @Test
    void testEx15(){
        Assertions.assertEquals(10, sumDigitsNumber(1234));
        Assertions.assertEquals(30, sumDigitsNumber(918273));
        Assertions.assertEquals(0, sumDigitsNumber(0));
        Assertions.assertEquals(1, sumDigitsNumber(100000));
    }
    private int sumDigitsNumber(int UserNum){
        int answer = 0;
        while(UserNum >= 9){
            answer += UserNum % 10;
            UserNum /= 10;
        }
        answer += UserNum;
    return answer;
    }
}
