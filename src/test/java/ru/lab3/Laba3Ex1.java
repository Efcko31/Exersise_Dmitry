package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Laba3Ex1 {
    // Найти все простые делители данного натурального числа.
    // 1 тоже входит в простые делители? Как проверить число, на то, что это число?
    @Test
    void testEx1(){

        Assertions.assertEquals("2 2 ", testEx1(4));
        Assertions.assertEquals("2 3 5 5 31",testEx1(4650));
        Assertions.assertEquals("", testEx1(0));
        Assertions.assertEquals("",testEx1(1));

    }

    private String testEx1(int nubmer) {
        String answer = new String("");
        while(nubmer > 1) {
            if (nubmer % 2 == 0) {
                answer = answer.concat("2 ");
                nubmer = nubmer / 2;
            } else if (nubmer % 3 == 0) {
                answer = answer.concat("3 ");
                nubmer = nubmer / 3;
            } else if (nubmer % 5 == 0) {
                answer = answer.concat("5 ");
                nubmer = nubmer / 5;
            } else {
                answer = answer.concat(Integer.toString(nubmer));
                nubmer = 1;
            }
        }
        return answer.toString();
    }
}
