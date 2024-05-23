package ru.lab7;

import org.junit.jupiter.api.Test;
import ru.lab7.exception.WrongSequenceSizeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba7Ex4 {
    /* С клавиатуры вводятся целые числа. Признак конца ввода — ноль.
    Найти произведение введённых нечётных чисел. */

    @Test
    void test() {
        assertEquals(15, findProductNumbers(new int[]{1, 2, 3, 4, 5}));
        assertEquals(15, findProductNumbersByRecursion(new int[]{1, 2, 3, 4, 5}, 0, 1));

        assertEquals(7, findProductNumbers(new int[]{4, 2, 7, 8, 6}));
        assertEquals(7, findProductNumbersByRecursion(new int[]{4, 2, 7, 8, 6}, 0, 1));

        assertEquals(1, findProductNumbers(new int[]{1}));
        assertEquals(1, findProductNumbersByRecursion(new int[]{1}, 0, 1));

        assertThrows(WrongSequenceSizeException.class, () -> findProductNumbers(new int[2000]));
        assertThrows(WrongSequenceSizeException.class, () -> findProductNumbersByRecursion
                    (new int[2000], 0, 1));

        assertThrows(WrongSequenceSizeException.class, () -> findProductNumbers(new int[]{}));
        assertThrows(WrongSequenceSizeException.class, () -> findProductNumbersByRecursion
                    (new int[]{}, 0, 1));

        assertEquals(147, findProductNumbers(new int[]{4, 1, 7, 7, 3}));
        assertEquals(147, findProductNumbersByRecursion(new int[]{4, 1, 7, 7, 3}, 0, 1));
    }

    private int findProductNumbers(int[] numberArray) throws WrongSequenceSizeException {
        try {
            if (numberArray.length == 0 || numberArray[0] == 0) {
                throw new WrongSequenceSizeException("Последовательность пуста!");
            }
        } catch (WrongSequenceSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        int product = 1;

        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] % 2 != 0) {
                product *= numberArray[i];
            }
        }
        return product;
    }

    private int findProductNumbersByRecursion(int[] numberArray, int i, int product) throws WrongSequenceSizeException {
        try {
            if (numberArray.length == 0 || numberArray[0] == 0) {
                throw new WrongSequenceSizeException("Последовательность пуста!");
            } else if (i == numberArray.length) {
                throw new IndexOutOfBoundsException();
            }
        } catch (WrongSequenceSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            return product;
        }

        if (numberArray[i] % 2 != 0) {
            product *= numberArray[i];
        }
        i++;

        return findProductNumbersByRecursion(numberArray, i, product);
    }
}
