package ru.lab7;

import org.junit.jupiter.api.Test;
import ru.lab7.exception.NumberIsMissingException;
import ru.lab7.exception.WrongSequenceSizeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba7Ex8 {
    /* Дана упорядоченная по убыванию последовательность целых чисел. Определить,
       есть ли среди членов данной последовательности число x, и если есть, найти номер
       этого члена. */

    @Test
    void test() throws Exception {
        assertEquals(2, findIndexNumberX(new int[]{9, 6, 5, 3, 2, 1}, 6));
        assertEquals(2, findIndexNumberXByRecursion(new int[]{9, 6, 5, 3, 2, 1}, 6, 0));

        assertThrows(NumberIsMissingException.class, () -> findIndexNumberX(new int[]{9, 7, 4, 3, 2, 1}, 6));
        assertThrows(NumberIsMissingException.class, () -> findIndexNumberXByRecursion
                (new int[]{9, 7, 4, 3, 2, 1}, 6, 0));

        assertThrows(WrongSequenceSizeException.class, () -> findIndexNumberX(new int[]{6}, 6));
        assertThrows(WrongSequenceSizeException.class, () -> findIndexNumberXByRecursion(new int[]{6}, 6, 0));

        assertThrows(WrongSequenceSizeException.class, () -> findIndexNumberX(new int[]{}, 6));
        assertThrows(WrongSequenceSizeException.class, () -> findIndexNumberXByRecursion(new int[]{}, 6, 0));

        assertEquals(3, findIndexNumberX(new int[]{1, 3, 4, 2, 7, 5, 6}, 4));
        assertEquals(3, findIndexNumberXByRecursion(new int[]{1, 3, 4, 2, 7, 5, 6}, 4, 0));


    }

    private int findIndexNumberX(int[] numbersArray, int x) throws Exception {
        try {
            if (numbersArray.length <= 1) {
                throw new WrongSequenceSizeException("Последовательность должна содержать минимум 2 числа!");
            }
        } catch (WrongSequenceSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] == x) {
                return i + 1;
            }
        }
        throw new NumberIsMissingException("Число не найдено!");
    }

    private int findIndexNumberXByRecursion(int[] numbersArray, int x, int i) throws Exception {
        try {
            if (numbersArray.length <= 1) {
                throw new WrongSequenceSizeException("Последовательность должна содержать минимум 2 числа!");
            } else if (i == numbersArray.length) {
                throw new NumberIsMissingException("Число не найдено!");
            }
        } catch (WrongSequenceSizeException | NumberIsMissingException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        if (numbersArray[i] == x) {
            return i + 1;
        }
        i++;
        return findIndexNumberXByRecursion(numbersArray, x, i);
    }
}
