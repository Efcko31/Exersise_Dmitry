package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex15 {
// Дано целое число n, удовлетворяющее условию 0 < |n| <= 2 · 10**9.
// Найти сумму цифр числа n.
    @Test
    void testEx15(){
        Assertions.assertEquals(10, testEx15(1234));
        Assertions.assertEquals(30, testEx15(918273));
        Assertions.assertEquals(0, testEx15(0));
        Assertions.assertEquals(1, testEx15(100000));
    }
    private int testEx15(int UserNum){
        int answer = 0;
        while(UserNum >= 9){
            answer += UserNum % 10;
            UserNum /= 10;
        }
        answer += UserNum;
    return answer;
    }
}
