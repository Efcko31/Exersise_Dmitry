package ru.lab7;

import org.junit.jupiter.api.Test;
import ru.lab7.exception.WrongSequenceSizeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba7Ex2 {
    /* Найти номер последнего вхождения минимального значения в последовательность
    длины n. */
    @Test
    void test() throws WrongSequenceSizeException {
        assertEquals(6, findIndexOfLastMinNumberIteratively(new int[]{89, 32, 16, 9, 33, 67, 9, 13, 24}));
        assertEquals(6, findIndexOfLastMinNumberRecursively
                    (new int[]{89, 32, 16, 9, 33, 67, 9, 13, 24}, 89, 0, 1));


        assertEquals(9, findIndexOfLastMinNumberIteratively(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(9, findIndexOfLastMinNumberRecursively
                    (new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1, 0, 1));


        assertEquals(9, findIndexOfLastMinNumberIteratively(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 1}));
        assertEquals(9, findIndexOfLastMinNumberRecursively
                    (new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 1}, 10, 0, 1));


        assertThrows(WrongSequenceSizeException.class, () -> findIndexOfLastMinNumberIteratively(new int[]{}));
        assertThrows(WrongSequenceSizeException.class, () -> findIndexOfLastMinNumberRecursively
                    (new int[]{}, 0, 0, 1));


        assertEquals(0, findIndexOfLastMinNumberIteratively(new int[]{1}));
        assertEquals(0, findIndexOfLastMinNumberRecursively(new int[]{1}, 0, 0, 1));


        assertEquals(4, findIndexOfLastMinNumberIteratively(new int[]{4, 6, 8, 2, 1, 9, 4}));
        assertEquals(4, findIndexOfLastMinNumberRecursively
                    (new int[]{4, 6, 8, 2, 1, 9, 4}, 4, 0, 1));


        assertEquals(0, findIndexOfLastMinNumberIteratively(new int[]{1, 6, 8, 2, 4, 9, 4}));
        assertEquals(0, findIndexOfLastMinNumberRecursively
                    (new int[]{1, 6, 8, 2, 4, 9, 4}, 1, 0, 1));


        assertEquals(6, findIndexOfLastMinNumberIteratively(new int[]{4, 6, 8, 2, 1, 9, 1}));
        assertEquals(6, findIndexOfLastMinNumberRecursively
                    (new int[]{4, 6, 8, 2, 1, 9, 1}, 4, 0, 1));
    }

    private int findIndexOfLastMinNumberIteratively(int[] numberArray) throws WrongSequenceSizeException {
        try {
            if (numberArray.length == 0) {
                throw new WrongSequenceSizeException("Последовательность пуста!");
            }
        } catch (WrongSequenceSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        int minNumber = numberArray[0];
        int indexMinNumber = 0;

        for (int i = 1; i < numberArray.length; i++) {
            if (minNumber >= numberArray[i]) {
                minNumber = numberArray[i];
                indexMinNumber = i;
            }
        }

        return indexMinNumber;
    }

    private int findIndexOfLastMinNumberRecursively(int[] numberArray, int minNumber, int indexMinNumber, int i)
            throws WrongSequenceSizeException {
        try {
            if (numberArray.length == 0) {
                throw new WrongSequenceSizeException("Последовательность пуста!");
            } else if (numberArray.length == i) {
                throw new IndexOutOfBoundsException();
            }
        } catch (WrongSequenceSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            return indexMinNumber;
        }

        if (minNumber >= numberArray[i]) {
            minNumber = numberArray[i];
            indexMinNumber = i;
        }

        i++;
        return i >= numberArray.length ? indexMinNumber : findIndexOfLastMinNumberRecursively
                (numberArray, minNumber, indexMinNumber, i);
    }
}
