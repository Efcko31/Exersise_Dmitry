package ru.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba7Ex9 {

    // Вывести двоичное представление данного натурального числа.

    @Test
    void test() {
        assertEquals(110, convertNumberIntoAnBinarySystemCalculation(6, new StringBuilder()));
        assertEquals(110, convertNumberIntoAnBinarySystemCalculationByRecursion
                (6, 6, new StringBuilder()));

        assertEquals(10111, convertNumberIntoAnBinarySystemCalculation(23, new StringBuilder()));
        assertEquals(10111, convertNumberIntoAnBinarySystemCalculationByRecursion
                (23, 23, new StringBuilder()));

        assertThrows(NullPointerException.class, () -> convertNumberIntoAnBinarySystemCalculation(0, new StringBuilder()));
        assertThrows(NullPointerException.class, () -> convertNumberIntoAnBinarySystemCalculationByRecursion
                (0, 0, new StringBuilder()));

        assertEquals(1111011, convertNumberIntoAnBinarySystemCalculation(123, new StringBuilder()));
        assertEquals(1111011, convertNumberIntoAnBinarySystemCalculationByRecursion
                (123, 123, new StringBuilder()));

        assertEquals(1, convertNumberIntoAnBinarySystemCalculation(1, new StringBuilder()));
        assertEquals(1, convertNumberIntoAnBinarySystemCalculationByRecursion
                (1, 1, new StringBuilder()));
    }

    private int convertNumberIntoAnBinarySystemCalculation(int number, StringBuilder numberSB) {
        try {
            if (number == 0) {
                throw new NullPointerException("Ноль - есть Ноль!");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        for (int i = number; i > 0; i /= 2) {
            numberSB.append(i % 2);
        }
        return Integer.parseInt(numberSB.reverse().toString());
    }


    private int convertNumberIntoAnBinarySystemCalculationByRecursion(int number, int i, StringBuilder numberSB) {
        try {
            if (number == 0) {
                throw new NullPointerException("Ноль - есть ноль!");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        if (i <= 0) {
            return Integer.parseInt(numberSB.reverse().toString());
        }

        numberSB.append(i % 2);
        i /= 2;

        return convertNumberIntoAnBinarySystemCalculationByRecursion(number, i, numberSB);
    }
}
