package ru.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba7Ex5 {
    //Вывести данное натуральное число в восьмеричном виде.
    @Test
    void test() {
        assertEquals(226, convertNumberIntoAnOctalSystemCalculation(150));

        assertEquals(36132, convertNumberIntoAnOctalSystemCalculation(15450));

        assertEquals(0, convertNumberIntoAnOctalSystemCalculation(0));

        assertEquals(46113177, convertNumberIntoAnOctalSystemCalculation(9999999));

        assertEquals(1, convertNumberIntoAnOctalSystemCalculation(1));


        assertEquals(226, convertNumberIntoAnOctalSystemCalculationByRecursion(150));

        assertEquals(0, convertNumberIntoAnOctalSystemCalculationByRecursion(0));

        assertEquals(36132, convertNumberIntoAnOctalSystemCalculationByRecursion(15450));

        assertEquals(10, convertNumberIntoAnOctalSystemCalculationByRecursion(8));

        assertEquals(1, convertNumberIntoAnOctalSystemCalculationByRecursion(1));
    }

    private int convertNumberIntoAnOctalSystemCalculation(int number) {
        StringBuilder sentenceWithNumbers = new StringBuilder();

        for (int i = number; i > 0; i /= 8) {
            sentenceWithNumbers.append(i % 8);
        }

        return sentenceWithNumbers.isEmpty() ? Integer.parseInt(sentenceWithNumbers.append(0).toString()) :
                Integer.parseInt(sentenceWithNumbers.reverse().toString());
    }


    private int convertNumberIntoAnOctalSystemCalculationByRecursion(int number) {
        StringBuilder sentenceWithNumbers = new StringBuilder();

        return convertNumber(sentenceWithNumbers, number);
    }

    private int convertNumber(StringBuilder sentenceWithNumbers, int i) {
        if (i <= 0) {
            return sentenceWithNumbers.isEmpty() ? Integer.parseInt(sentenceWithNumbers.append(0).toString()) :
                    Integer.parseInt(sentenceWithNumbers.reverse().toString());
        }

        sentenceWithNumbers.append(i % 8);
        i /= 8;
        return convertNumber(sentenceWithNumbers, i);
    }
}
