package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex6 {
    //Установить, является ли данное натуральное число n совершенным (равным сумме
    //всех его делителей, меньших n).
    @Test
    void test(){
        Assertions.assertEquals("Является", Ex6(6));
        Assertions.assertEquals("НЕ Является", Ex6(0));
        Assertions.assertEquals("Является", Ex6(28));
        Assertions.assertEquals("Является", Ex6(496));
        Assertions.assertEquals("Является", Ex6(33550336));
        Assertions.assertEquals("НЕ Является", Ex6(666));

    }
    private String Ex6(int userNumb){
        int sumDivisors = userNumb - 1;
        int totalNum = 2;
        while(totalNum != userNumb) {
            if (userNumb % totalNum == 0) {
                sumDivisors -= totalNum;
                totalNum++;
            } else {
                totalNum++;
            }
        }
    if (sumDivisors == 0)
        return "Является";
    else
        return "НЕ Является";
    }

}
