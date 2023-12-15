package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Laba3Ex1 {
    // Найти все простые делители данного натурального числа.
    // 1 тоже входит в простые делители? Как проверить число, на то, что это число?
    @Test
    void testEx1(){

        Assertions.assertEquals("2 2 ", testEx1(4));
        Assertions.assertEquals("2 3 5 5 31 ",testEx1(4650));
        Assertions.assertEquals("", testEx1(0));
        Assertions.assertEquals("",testEx1(1));
        Assertions.assertEquals("61 ",testEx1(61));
        Assertions.assertEquals("1279 ",testEx1(1279));
    }

    private String testEx1(int nubmer) {
        String answer = new String("");
        int totalNum = 2;
        while(nubmer > 1) {
            if (nubmer % totalNum == 0){
                answer = answer.concat(Integer.toString(totalNum));
                answer = answer.concat(" ");
                nubmer = nubmer / totalNum;
            } else { totalNum++;
            }
        }
        return answer.toString();
    }
}
