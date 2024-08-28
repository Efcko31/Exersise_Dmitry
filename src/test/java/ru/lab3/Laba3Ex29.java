package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//Получить число n в семеричной системе счисления.

public class Laba3Ex29 {

    @Test

    void into7Countingsystem(){
        String result = into7CountingSystem(0);
        Assertions.assertEquals("0", result);
        Assertions.assertEquals("1", into7CountingSystem(1));
        Assertions.assertEquals("15", into7CountingSystem(12));
    }
    private String into7CountingSystem(int number){
        StringBuilder s = new StringBuilder();
        while ( number >= 7 ) {
            s.insert(0, number % 7);
            number = number / 7;
        }
        s.insert(0, number);
        return s.toString();
    }
}
