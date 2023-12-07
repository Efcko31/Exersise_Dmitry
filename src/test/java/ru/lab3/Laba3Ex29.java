package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex29 {

    @Test
    void into7Countingsystem(){
        String result = into7Countingsystem(0);
        Assertions.assertEquals("0", result);
        Assertions.assertEquals("1", 1);
    }
    private String into7Countingsystem(int number){
        StringBuilder s = new StringBuilder();
        while ( number >= 7 ) {
            s.insert(0, number % 7);
            number = number / 7;
        }
        s.insert(0, number);
        return s.toString();
    }
}
