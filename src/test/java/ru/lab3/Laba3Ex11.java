package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex11 {
    //С клавиатуры вводятся символы. Признак конца ввода — точка. Определить символ,
    //следующий за последним вхождением цифры.
    @Test
    void test() {
        Assertions.assertEquals('*', searchingCharacterAfterLastDigit(new char[]{'+', '1', '*'}));
        Assertions.assertEquals('*', searchingCharacterAfterLastDigit(new char[]{'.', '1', '*'}));
        Assertions.assertEquals('&', searchingCharacterAfterLastDigit(new char[]{'+', '1', '2', '3', '*', '1', '&'}));
        Assertions.assertEquals(' ', searchingCharacterAfterLastDigit(new char[]{'7', '1', '2', '3', '5', '1', '2'}));
        Assertions.assertEquals('%', searchingCharacterAfterLastDigit(new char[]{'7', '1', '2', '3', '5', '1', '%'}));
        Assertions.assertEquals(' ', searchingCharacterAfterLastDigit(new char[]{'/', '1', '2', '3', '5', '1', '2'}));
        Assertions.assertEquals('/', searchingCharacterAfterLastDigit(new char[]{'/', '1', '-', '3', '-', '1', '/', '*'}));
    }

    private char searchingCharacterAfterLastDigit(char[] UserNumber) {
        char answer = ' ';

        for (int i = UserNumber.length - 1; i != 0  && answer == ' '; i--) {
            if (Character.isDigit(UserNumber[i]) && !Character.isDigit(UserNumber[UserNumber.length - 1])) {
                answer = UserNumber[i + 1];
            }
        }
        return answer;
    }
}
