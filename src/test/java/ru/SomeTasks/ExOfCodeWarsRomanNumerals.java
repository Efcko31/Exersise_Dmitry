package ru.SomeTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExOfCodeWarsRomanNumerals {
    @Test
    void test() {
        assertEquals("II", convertRomanNumerals(2));
        assertEquals("IV", convertRomanNumerals(4));
        assertEquals("VII", convertRomanNumerals(7));
        assertEquals("IX", convertRomanNumerals(9));
        assertEquals("", convertRomanNumerals(0));

        assertEquals("XXIII", convertRomanNumerals(23));
        assertEquals("XLVIII", convertRomanNumerals(48));
        assertEquals("LXXIX", convertRomanNumerals(79));
        assertEquals("XCIV", convertRomanNumerals(94));
        assertEquals("LXX", convertRomanNumerals(70));

        assertEquals("CCXXXIV", convertRomanNumerals(234));
        assertEquals("CDLXXVII", convertRomanNumerals(477));
        assertEquals("DCCLXXVII", convertRomanNumerals(777));
        assertEquals("CMXXVIII", convertRomanNumerals(928));
        assertEquals("CI", convertRomanNumerals(101));

        assertEquals("MCCXXXIV", convertRomanNumerals(1234));
        assertEquals("MXXVIII", convertRomanNumerals(1028));
        assertEquals("MCDVII", convertRomanNumerals(1407));
        assertEquals("M", convertRomanNumerals(1000));
    }

    public String convertRomanNumerals(int n) {
        StringBuilder answer = new StringBuilder("");
        if (n >= 1000) {
            thousands(answer, n);
        } else if (n > 100) {
            hundreds(answer, n);
        } else if (n > 10) {
            tens(answer, n);
        } else {
            units(answer, n);
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
