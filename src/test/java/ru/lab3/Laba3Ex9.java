package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex9 {
    //С клавиатуры вводятся целые числа. Признак конца ввода — ноль. Определить число, предшествующее первому из введённых максимальных значений.
    @Test
    void test(){
        Assertions.assertEquals(3, test(new int[] {1, 2, 3, 4, 0, 6, 8, 9, 0}));
        Assertions.assertEquals(0, test(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0}));
        Assertions.assertEquals(9, test(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1}));
        Assertions.assertEquals(2, test(new int[] {1, 2, 3}));
        Assertions.assertEquals(1, test(new int[] {1, 3, 3}));
    }

    private int test(int[] userNumber){
        int answer = userNumber[0], maxNumber = userNumber[0] - 1;
            for(int i=0; i<userNumber.length; i++){
                if (userNumber[i] != 0){
                    if(userNumber[i] > maxNumber){
                        maxNumber = userNumber[i];
                        if(i > 0)
                            answer = userNumber[i - 1];
                    }
                } else {
                    break;
                }
            }
    return answer;
    }
}
