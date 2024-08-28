package ru.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Laba7Ex5 {
    //Вывести данное натуральное число в восьмеричном виде.
    @Test
    void test()  {
        assertEquals(10, convertNumberIntoAnOctalSystemCalculation(8));
        assertEquals(10, convertNumberIntoAnOctalSystemCalculationByRecursion(new StringBuilder(), 8));

        assertEquals(226, convertNumberIntoAnOctalSystemCalculation(150));
        assertEquals(226, convertNumberIntoAnOctalSystemCalculationByRecursion(new StringBuilder(), 150));

        assertEquals(36132, convertNumberIntoAnOctalSystemCalculation(15450));
        assertEquals(36132, convertNumberIntoAnOctalSystemCalculationByRecursion
                (new StringBuilder(), 15450));

        assertThrows(NullPointerException.class, () -> convertNumberIntoAnOctalSystemCalculation(0));
        assertThrows(NullPointerException.class, () -> convertNumberIntoAnOctalSystemCalculationByRecursion
                (new StringBuilder(), 0));

        assertThrows(NullPointerException.class, () -> convertNumberIntoAnOctalSystemCalculation(0));
        assertThrows(NullPointerException.class, () -> convertNumberIntoAnOctalSystemCalculationByRecursion
                (new StringBuilder(), 0));

        assertEquals(1, convertNumberIntoAnOctalSystemCalculation(1));
        assertEquals(1, convertNumberIntoAnOctalSystemCalculationByRecursion(new StringBuilder(), 1));

        assertEquals(46113177, convertNumberIntoAnOctalSystemCalculation(9999999));
        assertEquals(46113177, convertNumberIntoAnOctalSystemCalculationByRecursion
                (new StringBuilder(), 9999999));

    }

    private int convertNumberIntoAnOctalSystemCalculation(int number) {
        try {
            if (number == 0) {
                throw new NullPointerException("Число не должно равняться нулю!");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        StringBuilder sentenceWithNumbers = new StringBuilder().append(number % 8);
        for (int i = number / 8; i > 0; i /= 8) {
            sentenceWithNumbers.insert(0, i % 8);
        }

        return Integer.parseInt(sentenceWithNumbers.toString());
    }


    private int convertNumberIntoAnOctalSystemCalculationByRecursion(StringBuilder sentenceWithNumbers, int number)
            throws NullPointerException {
        try {
            if (number == 0) {
                throw new NullPointerException("Число не должно равняться нулю!");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        sentenceWithNumbers.insert(0,number % 8);
        number /= 8;
        return number == 0 ? Integer.parseInt(sentenceWithNumbers.toString()) :
                convertNumberIntoAnOctalSystemCalculationByRecursion(sentenceWithNumbers, number);
    }
}
