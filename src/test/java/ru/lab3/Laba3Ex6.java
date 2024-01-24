package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex6 {
    //Установить, является ли данное натуральное число n совершенным (равным сумме
    //всех его делителей, меньших n).
    private static final String YES = "Является";
    private static final String NO = "Не является";

    @Test
    void test(){
        Assertions.assertEquals(YES, determinesPerfectNumberOrNot(6));
        Assertions.assertEquals(NO, determinesPerfectNumberOrNot(0));
        Assertions.assertEquals(YES, determinesPerfectNumberOrNot(28));
        Assertions.assertEquals(YES, determinesPerfectNumberOrNot(496));
        Assertions.assertEquals(YES, determinesPerfectNumberOrNot(33550336));
        Assertions.assertEquals(NO, determinesPerfectNumberOrNot(666));

    }
    private String determinesPerfectNumberOrNot(int userNumb) {
        int sumDivisors = userNumb - 1;
        int totalNum = 2;
        while (totalNum != userNumb) {
            if (userNumb % totalNum == 0) {
                sumDivisors -= totalNum;
                totalNum++;
            } else {
                totalNum++;
            }
        }
        return sumDivisors == 0 ? YES : NO;
    }
}
