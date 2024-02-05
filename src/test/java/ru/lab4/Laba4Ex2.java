package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Laba4Ex2 {
    //. Дана целочисленная последовательность. Определить количество вхождений каждого числа в последовательность.
    @Test
    void test() {
        Assertions.assertEquals("3 = 1; 4 = 1; 5 = 1; 6 = 1; 8 = 2; ", totalOfEachNumberInArray(new int[]{3, 5, 8, 8, 4, 6}));
        Assertions.assertEquals("3 = 6; ", totalOfEachNumberInArray(new int[]{3, 3, 3, 3, 3, 3}));
        Assertions.assertEquals("3 = 1; ", totalOfEachNumberInArray(new int[]{3}));
        Assertions.assertEquals("3 = 2; 4 = 2; 8 = 2; ", totalOfEachNumberInArray(new int[]{3, 3, 8, 8, 4, 4}));
        Assertions.assertEquals("1 = 1; 2 = 1; 3 = 1; 4 = 1; 5 = 1; 6 = 1; 7 = 1; 8 = 1; 9 = 1; ", totalOfEachNumberInArray(new int[]{3, 2, 4, 1, 5, 6, 9, 8, 7}));
    }

    private String totalOfEachNumberInArray(int[] arrayNumber) {
        for (int step = 0; step < arrayNumber.length; step++) {
            int index = min(arrayNumber, step);

            int numberReplace = arrayNumber[step];
            arrayNumber[step] = arrayNumber[index];
            arrayNumber[index] = numberReplace;
        }

        String answer = arrayNumber[0] + " = ";
        int total = 1;

        for (int j = 1; j < arrayNumber.length; j++) {
            if (arrayNumber[j] == arrayNumber[j - 1]) {
                total++;
            } else {
                answer = answer + total + "; " + arrayNumber[j] + " = ";
                total = 1;
            }
        }
        answer = answer + total + "; ";
        return answer;
    }

    private static int min(int[] arrayNumber, int start) {
        int minIndex = start, minValue = arrayNumber[start];
        for (int i = start; i < arrayNumber.length; i++) {
            if (minValue > arrayNumber[i]) {
                minValue = arrayNumber[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
