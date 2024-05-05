package ru.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba7Ex9 {

    // Вывести двоичное представление данного натурального числа.

    @Test
    void test() {
        assertEquals(110, convertNumberIntoAnBinarySystemCalculation(6));

        assertEquals(10111, convertNumberIntoAnBinarySystemCalculation(23));

        assertEquals(0, convertNumberIntoAnBinarySystemCalculation(0));

        assertEquals(1111011, convertNumberIntoAnBinarySystemCalculation(123));


        assertEquals(110, convertNumberIntoAnBinarySystemCalculationByRecursion(6));

        assertEquals(10111, convertNumberIntoAnBinarySystemCalculationByRecursion(23));

        assertEquals(0, convertNumberIntoAnBinarySystemCalculationByRecursion(0));

        assertEquals(1111011, convertNumberIntoAnBinarySystemCalculationByRecursion(123));
    }

    private int convertNumberIntoAnBinarySystemCalculation(int number) {
        StringBuilder numberSB = new StringBuilder();

        for (int i = number; i > 0; i /= 2) {
            numberSB.append(i % 2);
        }
        return number == 0 ? 0 : Integer.parseInt(numberSB.reverse().toString());
    }


    private int convertNumberIntoAnBinarySystemCalculationByRecursion(int number) {
        StringBuilder numberSB = new StringBuilder();

        return number == 0 ? 0 : recursion(number, numberSB);
    }

    private int recursion(int i, StringBuilder numberSB) {
        if (i <= 0) {
            return Integer.parseInt(numberSB.reverse().toString());
        }

        numberSB.append(i % 2);
        i /= 2;

        return recursion(i, numberSB);
    }
}
