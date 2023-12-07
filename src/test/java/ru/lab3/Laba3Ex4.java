package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex4 {
    // Определить, является ли данное натуральное число простым числом
    @Test
    void test(){
        Assertions.assertEquals("Является", test(17));
        Assertions.assertEquals("Не является", test(12));
        Assertions.assertEquals("Ни простое, Ни составное",test(0));
        Assertions.assertEquals("Ни простое, Ни составное",test(1));
    }
    private String test(int user_number){
        int totalNum = 0;
        for (int i = 2; i <= user_number / 2; i++){
            if(user_number % i == 0)
                totalNum++;
            if (totalNum >= 2)
                break;
        }
        if (totalNum >= 2)
            return "Не является";
        else if (user_number == 0 | user_number == 1) {
            return "Ни простое, Ни составное";
        } else
            return "Является";
    }


}
