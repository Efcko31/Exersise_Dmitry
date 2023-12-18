package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.parseInt;

public class Laba3Ex14 {
//    С клавиатуры вводятся целые числа. Признак конца ввода — ноль. Определить число,
//    следующее за последним из отрицательных чисел.

    @Test
    void testEx14(){
        Assertions.assertEquals("5", testEx14(new int[] {1, 3, -1, 2, -4, 5}));
        Assertions.assertEquals("2", testEx14(new int[] {1, 3, -1, 2, 0, -4, 5}));
        Assertions.assertEquals("NOTHING", testEx14(new int[] {0, 3, -1, 2, -4, 5}));
        Assertions.assertEquals("NOTHING", testEx14(new int[] {-1, 0, -1, 2, -4, 5}));
        Assertions.assertEquals("NOTHING", testEx14(new int[] {8, 3, -1, 2, -4, -1}));
        Assertions.assertEquals("NOTHING", testEx14(new int[] {-1, -10, -1, -2, -4, -5}));
    }

    private String testEx14(int[] UserNumber){
        boolean negative_flag = false;
        String answer_str = "NOTHING";
        int answer_int = 0;
        for(int i=0; i<UserNumber.length; i++) {
            if (UserNumber[i] == 0)
                break;
            else if (negative_flag) {
                answer_str = Integer.toString(UserNumber[i]);
                negative_flag = false;
                answer_int = UserNumber[i];
            } else if (UserNumber[i] < 0) {
                negative_flag = true;
            }
        }
        if(answer_int <= 0){
            answer_str = "NOTHING";
            return answer_str;
        }else
            return answer_str;
    }
}
