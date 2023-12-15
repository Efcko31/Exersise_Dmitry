package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex12 {
//    С клавиатуры вводятся целые числа. Признак конца ввода — ноль.
//    Определить количество введённых нечётных чисел после последнего отрицательного.
    @Test
    void test(){
        Assertions.assertEquals(3,test(new int[] {1, 2, -1, 3, 5, 7}));
        Assertions.assertEquals(4,test(new int[] {1, 2, -1, 3, 5, 7, -6, 5, 7, 9, 11}));
        Assertions.assertEquals(1,test(new int[] {1, 2, -1, 3, 0, 7}));
        Assertions.assertEquals(0,test(new int[] {0, 2, -1, 3, 0, 7}));
        Assertions.assertEquals(1,test(new int[] {-1, 2, -1, 3, 0, 7}));
        Assertions.assertEquals(0,test(new int[] {1, 2, 1, 3, 10, -7}));

    }
    private int test(int [] UserNumber){
        int total = 0;
        boolean negativeFlag = false;

        for(int i=0; i<UserNumber.length; i++) {
            if (UserNumber[i] == 0)
                break;
            else if (UserNumber[i] < 0) {
                if(negativeFlag){
                    total = 0;
                    continue;
                } else  {
                    negativeFlag = true;
                    total = 0;
                    continue;
                }
            }
            if (negativeFlag){
                if(UserNumber[i] % 2 != 0){
                    total++;
                }
            }
        }
    return total;}
}
