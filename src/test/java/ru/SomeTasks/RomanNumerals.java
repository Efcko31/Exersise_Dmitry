package ru.SomeTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RomanNumerals {
    @Test
    void test() {
        Assertions.assertEquals("II", convertRomanNumerals(2));
        Assertions.assertEquals("IV", convertRomanNumerals(4));
        Assertions.assertEquals("VII", convertRomanNumerals(7));
        Assertions.assertEquals("IX", convertRomanNumerals(9));
        Assertions.assertEquals("", convertRomanNumerals(0));

        Assertions.assertEquals("XXIII", convertRomanNumerals(23));
        Assertions.assertEquals("XLVIII", convertRomanNumerals(48));
        Assertions.assertEquals("LXXIX", convertRomanNumerals(79));
        Assertions.assertEquals("XCIV", convertRomanNumerals(94));
        Assertions.assertEquals("LXX", convertRomanNumerals(70));

        Assertions.assertEquals("CCXXXIV", convertRomanNumerals(234));
        Assertions.assertEquals("CDLXXVII", convertRomanNumerals(477));
        Assertions.assertEquals("DCCLXXVII", convertRomanNumerals(777));
        Assertions.assertEquals("CMXXVIII", convertRomanNumerals(928));
        Assertions.assertEquals("CI", convertRomanNumerals(101));

        Assertions.assertEquals("MCCXXXIV", convertRomanNumerals(1234));
        Assertions.assertEquals("MXXVIII", convertRomanNumerals(1028));
        Assertions.assertEquals("MCDVII", convertRomanNumerals(1407));
    }

    public String convertRomanNumerals(Integer number) {
        StringBuilder answer = new StringBuilder("");
        if (number > 1000) {
            thousands(answer, number);
        } else if (number > 100) {
            hundreds(answer, number);
        } else if (number > 10) {
            tens(answer, number);
        } else {
            units(answer, number);
        }
        return answer.toString();
    }

    public void units(StringBuilder answer, Integer number) {
        if (number <= 3) {
            for (int i = 0; i < number; i++) {
                answer.append("I");
            }
        } else if (number == 4) {
            answer.append("IV");
        } else if (number == 9) {
            answer.append("IX");
        } else {
            answer.append("V");
            for (int i = 0; i < number - 5; i++) {
                answer.append("I");
            }
        }
    }

    public void tens(StringBuilder answer, Integer number) {
        if (number / 10 <= 3) {
            for (int i = 0; i < number / 10; i++) {
                answer.append("X");
            }
        } else if (number / 10 == 4) {
            answer.append("XL");
        } else if (number / 10 == 9) {
            answer.append("XC");
        } else {
            answer.append("L");
            for (int i = 0; i < number / 10 - 5; i++) {
                answer.append("X");
            }
        }
        number %= 10;
        units(answer, number);
    }

    public void hundreds(StringBuilder answer, Integer number) {
        if (number / 100 <= 3) {
            for (int i = 0; i < number / 100; i++) {
                answer.append("C");
            }
        } else if (number / 100 == 4) {
            answer.append("CD");
        } else if (number / 100 == 9) {
            answer.append("CM");
        } else {
            answer.append("D");
            for (int i = 0; i < number / 100 - 5; i++) {
                answer.append("C");
            }
        }
        number %= 100;
        tens(answer, number);
    }

    public void thousands(StringBuilder answer, Integer number) {
        if (number / 1000 <= 3) {
            for (int i = 0; i < number / 1000; i++) {
                answer.append("M");
            }
        } else {
            System.out.println("Условие задачи не больше 3999!");
        }
        number %= 1000;
        hundreds(answer, number);
    }
}
