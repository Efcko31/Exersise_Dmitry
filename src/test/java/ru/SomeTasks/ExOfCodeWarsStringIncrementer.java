package ru.SomeTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExOfCodeWarsStringIncrementer {

    /*Ваша задача — написать функцию, которая увеличивает строку, чтобы создать новую строку.
Если строка уже заканчивается цифрой, то число следует увеличить на 1.
Если строка не заканчивается цифрой, к новой строке следует добавить цифру 1.
Примеры:
foo -> foo1
foobar23 -> foobar24
foo0042 -> foo0043
foo9 -> foo10
foo099 -> foo100
Внимание: если число имеет начальные нули, следует учитывать количество цифр.*/

    @Test
    void test() {
        assertEquals("foo1", incrementString("foo"));
        assertEquals("foobar24", incrementString("foobar23"));
        assertEquals("foo0043", incrementString("foo0042"));
        assertEquals("foo10", incrementString("foo9"));
        assertEquals("foo100", incrementString("foo099"));
        assertEquals("1000", incrementString("999"));
        assertEquals("foo0123456790", incrementString("foo0123456789"));
        assertEquals("foo100000000000000000", incrementString("foo99999999999999999"));
        assertEquals("foo100000000000000000", incrementString("foo099999999999999999"));
        assertEquals("foo0100000000000000000", incrementString("foo0099999999999999999"));
        assertEquals("eTx,H0[d|9(+gQ.&{:bs^/W#N_[bp>1a#Jw}!.1", incrementString("eTx,H0[d|9(+gQ.&{:bs^/W#N_[bp>1a#Jw}!."));

    }

    public String incrementString(String str) {
        char[] strArray = str.toCharArray();
        StringBuilder strSB = new StringBuilder(str);
        int n = 0;

        for (int i = strArray.length - 1; i >= 0; i--) {
            if (Character.isDigit(strArray[i])) {
                if (Character.getNumericValue(strArray[i]) < 9) {
                    strSB.replace(i, i+1, (char) ((int) strArray[i] + 1) + "");
                    //strArray[i] = (char) ((int) strArray[i] + 1);
                    //return new String(strArray);
                    return strSB.toString();
                } else if (Character.getNumericValue(strArray[i]) == 9) {
                    strSB.replace(i, i+1, "0");
                    n = 1;

                }
            } else if (n > 0) {
                strSB.insert(i + 1, "1");
                return strSB.toString();
            } else if (i == strArray.length - 1) {
                return str + 1;
            }
        }
    return n > 0 ? strSB.insert(0, "1").toString() : str + 1;
    }
}
