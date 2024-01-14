package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
// Дано целое число n, удовлетворяющее условию 0 < |n| 6 2 · 109
//. Найти максимальную цифру в записи этого числа
public class Laba3Ex3 {
    @Test
    void test(){
        Assertions.assertEquals(7, Ex3(275));
        Assertions.assertEquals(0, Ex3(0));
        Assertions.assertEquals(7, Ex3(752));
        Assertions.assertEquals(7, Ex3(7));
        Assertions.assertEquals(9, Ex3(987654321));
        Assertions.assertEquals(9, Ex3(123456789));
        Assertions.assertEquals(9, Ex3(123496785));
    }
    private int Ex3(int number){
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
