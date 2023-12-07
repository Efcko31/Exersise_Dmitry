package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
// Дано целое число n, удовлетворяющее условию 0 < |n| 6 2 · 109
//. Найти максимальную цифру в записи этого числа
public class Laba3Ex3 {
    @Test
    void test(){
        Assertions.assertEquals(7, test(275));
        Assertions.assertEquals(0, test(0));
        Assertions.assertEquals(7, test(752));
        Assertions.assertEquals(7, test(7));
        Assertions.assertEquals(9, test(987654321));
        Assertions.assertEquals(9, test(123456789));
        Assertions.assertEquals(9, test(123496785));
    }
    private int test(int number){
        int maxNumber = 0;
        for(int i = 0; i < 10; i++){
            if(number != 0 && maxNumber < number % 10){
                maxNumber = number % 10;
                number = number / 10;
            } else {
                number = number / 10;
            }
            if (maxNumber == 9)
                break;
        }
    return maxNumber;
    }
}
