package ru.lab4;

import org.junit.jupiter.api.Test;
import ru.Oop.Laba4.Laba4Util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba4Ex3 {
    // Если число x встречается в последовательности, то упорядочить по невозрастанию
    //часть последовательности до последнего вхождения x
    @Test
    void test() {
        assertArrayEquals(new Integer[]{9, 3, 7, 6, 4, 2}, sortToNumber(new Integer[]{9, 3, 7, 6, 4, 2}, 1));
        assertArrayEquals(new Integer[]{9, 7, 6, 4, 3, 1, 2}, sortToNumber(new Integer[]{9, 3, 7, 6, 4, 1, 2}, 1));
        assertArrayEquals(new Integer[]{1, 3, 5, 4, 2, 9, 7}, sortToNumber(new Integer[]{1, 3, 5, 4, 2, 9, 7}, 1));
        assertArrayEquals(new Integer[]{55, 12, 9, 7, 5, 4, 3, 2, 1, 1, 647, 89},
                sortToNumber(new Integer[]{1, 3, 5, 4, 2, 9, 7, 12, 55, 1, 647, 89}, 1));
        assertThrows(NullPointerException.class, () -> sortToNumber(new Integer[]{}, 1));
    }

    private Integer[] sortToNumber(Integer[] listNumber, int x) {
        try {
            Laba4Util.checkArrayIsEmpty(listNumber);
            int lastEntranceX = 0;

            for (int i = listNumber.length - 1; i > 0; i--) {
                if (listNumber[i] == x) {
                    lastEntranceX = i;
                    i = 0;
                }
            }
            sortByChoise(listNumber, lastEntranceX);
            return listNumber;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static Integer[] sortByChoise(Integer[] numberArray, Integer lastEntranceX) {
        for (int i = 0; i < numberArray.length; i++) {
            int indexMinimum = searchMaximumValue(numberArray, i, lastEntranceX);
            int numberForReplace = numberArray[i];
            numberArray[i] = numberArray[indexMinimum];
            numberArray[indexMinimum] = numberForReplace;
        }
        return numberArray;
    }

    private static Integer searchMaximumValue(Integer[] numberArray, int start, int finish) {
        int minIndex = start, minValue = numberArray[start];
        for (int j = start; j < finish; j++) {
            if (minValue < numberArray[j]) {
                minValue = numberArray[j];
                minIndex = j;
            }
        }
        return minIndex;
    }
}
