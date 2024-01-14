package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex11 {
    //С клавиатуры вводятся символы. Признак конца ввода — точка. Определить символ,
    //следующий за последним вхождением цифры.
    @Test
    void test() {
        Assertions.assertEquals('*', Ex11(new char[]{'+', '1', '*'}));
        Assertions.assertEquals(' ', Ex11(new char[]{'.', '1', '*'}));
        Assertions.assertEquals('*', Ex11(new char[]{'+', '1', '2', '3', '*', '1', '.'}));
        Assertions.assertEquals(' ', Ex11(new char[]{'7', '1', '2', '3', '5', '1', '2'}));
        Assertions.assertEquals('%', Ex11(new char[]{'7', '1', '2', '3', '5', '1', '%'}));
        Assertions.assertEquals(' ', Ex11(new char[]{'/', '1', '2', '3', '5', '1', '2'}));
        Assertions.assertEquals('/', Ex11(new char[]{'/', '1', '-', '3', '/', '1', '.', '*'}));
    }

    private char Ex11(char[] UserNumber) {
        char answer = ' ';
        boolean flag = false;
        for (int i = 0; i < UserNumber.length; i++) {
            if (UserNumber[i] == '.')
                break;
            else if (Character.isDigit(UserNumber[i])) {
                flag = true;
            } else if (flag) {
                answer = UserNumber[i];
                flag = false;
            }
        }
        return answer;
    }
}
