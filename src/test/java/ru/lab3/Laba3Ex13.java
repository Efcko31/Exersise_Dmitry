package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex13 {
//    Дано целое неотрицательное число n, удовлетворяющее условию 0 < n <= 2 · 10**9.
//Определить количество нулей, которыми заканчивается запись числа n. Вывести n в виде a*10^k,
// где a — целое, не содержащее нуля в конце записи числа; k — количество нулей в конце записи числа n.
// Например, 130 000 = 13*10^4.

    @Test
    void test(){
        Assertions.assertEquals("13*10^4", test(130000));
        Assertions.assertEquals("2345*10^2", test(234500));
        Assertions.assertEquals("1*10^6", test(1000000));
        Assertions.assertEquals("1*10^0", test(1));
        Assertions.assertEquals("0*10^0", test(0000));
        Assertions.assertEquals("1*10^1", test(10));
    }
    private String test(int userNumber){
        int total_zero = 0;
        String answer = "";
        for(int i=0; i<userNumber; i++){
            if(userNumber % 10 == 0){
                userNumber /= 10;
                total_zero++;
            } else
                break;
        }
        answer = answer.concat(Integer.toString(userNumber));
        answer = answer.concat("*10^");
        answer = answer.concat(Integer.toString(total_zero));

    return answer; }
}
