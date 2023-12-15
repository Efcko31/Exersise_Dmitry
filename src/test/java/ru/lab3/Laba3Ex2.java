package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex2 {

// С клавиатуры вводятся целые числа. Признак конца ввода — ноль. Определить число,
// следующее за последним из введённых минимальных значений.
    @Test
    void test() {
        Assertions.assertEquals(2, test(new int[] {1, 2, 3, 0, 7, 8}));
        Assertions.assertEquals(0, test(new int[] {0, 2, 3, 9, 7, 8}));
        Assertions.assertEquals(7, test(new int[] {7, 7, 7, 7, 7, 7}));
        Assertions.assertEquals(6, test(new int[] {5, 6, 4, 0, 7, 8}));
        Assertions.assertEquals(0, test(new int[] {0}));
        Assertions.assertEquals(7, test(new int[] {5, 6, 4, 7, 8, 0}));
        Assertions.assertEquals(3, test(new int[] {2, 4, 6, 1, 3, 5}));
        // ex - ожидаешь, ac - передаешь. Без Scanner.
    }
    private int test(int[] list_num){
        int answer = list_num[0];
        int minNum = list_num[0] + 1;
        for(int i = 0; i < list_num.length; i++){
            if((list_num[i] != 0)){
                if(list_num[i] <= minNum){
                    minNum = list_num[i];
                    if (i + 1 != list_num.length)
                        if ((list_num[i + 1] != 0))
                            answer = list_num[i + 1];
                }
            } else
                break;
            }
        return answer;
    }
}
