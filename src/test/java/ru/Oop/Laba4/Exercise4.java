package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise4 {
/*Дана последовательность целых чисел, содержащая как положительные, так и отрицательные элементы. Упорядочить последовательность следующим образом: сначала
идут отрицательные числа, упорядоченные по убыванию, потом положительные, упорядоченные по возрастанию.*/

    @Test
    public void test() {
        assertArrayEquals(new Integer[]{-7, -9, 2, 3, 4, 5, 6},
                returnsSortedNumbers(new Integer[]{3, -9, 5, -7, 2, 4, 6}));
        assertArrayEquals(new Integer[]{-9, 2, 3, 4, 6, 7}, returnsSortedNumbers(new Integer[]{-9, 3, 7, 6, 4, 2}));
        assertArrayEquals(new Integer[]{-3, -4, -6, -7, -9, 2},
                returnsSortedNumbers(new Integer[]{-9, -3, -7, -6, -4, 2}));
        assertArrayEquals(new Integer[]{2, 3, 4, 6, 7, 9}, returnsSortedNumbers(new Integer[]{9, 3, 7, 6, 4, 2}));
        assertArrayEquals(new Integer[]{-6, -7, -8, -9, 1, 2, 3, 4, 5},
                returnsSortedNumbers(new Integer[]{1, -8, 4, -6, 5, -9, 3, 2, -7}));
        assertThrows(NullPointerException.class, () -> returnsSortedNumbers(new Integer[]{}));
    }

    public Integer[] returnsSortedNumbers(Integer[] numberArray) {
        try {

            Laba4Util.checkArrayIsEmpty(numberArray);

            ArrayList<Integer> arrayNegativeNumber = new ArrayList<>();
            ArrayList<Integer> arrayPositiveNumber = new ArrayList<>();

            sortsNegativeNumbersFromPositiveOnes(numberArray, arrayNegativeNumber, arrayPositiveNumber);
            arrayNegativeNumber.sort(Comparator.reverseOrder());
            arrayPositiveNumber.sort(Comparator.naturalOrder());
            arrayNegativeNumber.addAll(arrayPositiveNumber);

            return arrayNegativeNumber.toArray(new Integer[0]);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void sortsNegativeNumbersFromPositiveOnes(Integer[] numberArray, ArrayList<Integer> arrayNegativeNumber,
                                                     ArrayList<Integer> arrayPositiveNumber) {
        for (Integer i : numberArray) {
            if (i >= 0) {
                arrayPositiveNumber.add(i);
            } else {
                arrayNegativeNumber.add(i);
            }
        }
    }
}
