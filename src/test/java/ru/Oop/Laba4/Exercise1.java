package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;


public class Exercise1 {
    /*Дана последовательность целых чисел. Вывести упорядоченную по возрастанию
последовательность, состоящую из чисел данной последовательности, стоящих на
нечётных местах и встречающихся в ней только один раз.*/
    @Test
    public void test() {
        assertArrayEquals(new Integer[]{7, 15, 32}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{3, 4, 4, 4, 5, 5, 5, 2, 2, 2, 6, 7, 45, 32, 122, 15}));
        assertArrayEquals(new Integer[]{4, 5, 6, 8}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{1, 2, 3, 8, 1, 6, 7, 7, 7, 9, 9, 5, 2, 4}));
        assertArrayEquals(new Integer[]{}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
        assertArrayEquals(new Integer[]{}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{2, 2, 3, 3, 7, 4, 5, 5, 6, 6, 7, 6, 4, 4}));
        assertArrayEquals(new Integer[]{0, 2, 4, 6, 8}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{1, 8, 3, 6, 5, 2, 7, 0, 9, 4}));
        assertThrows(NullPointerException.class, () -> sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{}));
    }


    public Integer[] sortsNumbersInAscendingOrderStandingInOddPlaces(Integer[] numbersArray) throws NullPointerException {
        try {
            Laba4Util.checkArrayIsEmpty(numbersArray);
            ArrayList<Integer> array = new ArrayList<>();

            addingNumbersInOddPositionsArray(array, numbersArray);
            array.sort(Comparator.naturalOrder());

            return removeDuplicateNumbers(array, numbersArray);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void addingNumbersInOddPositionsArray(ArrayList<Integer> array, Integer[] numbersArray) {
        for (int i = 0; i < numbersArray.length; i++) {
            if (i % 2 != 0) {
                array.add(numbersArray[i]);
            }
        }
    }

    public Integer[] removeDuplicateNumbers(ArrayList<Integer> array, Integer[] numberArray) {
        ArrayList<Integer> arrayWithDuplicate = new ArrayList<>();
        ArrayList<Integer> sortedArray = new ArrayList<>();

        Laba4Util.addArrayInArrayList(sortedArray, numberArray, numberArray.length);
        sortedArray.sort(Comparator.naturalOrder());

        for (int i = 1; i < sortedArray.size(); i++) {
            if (sortedArray.get(i).equals(sortedArray.get(i - 1))) {
                arrayWithDuplicate.add(sortedArray.get(i));
            }
        }
        array.removeAll(arrayWithDuplicate);
    return array.toArray(new Integer[0]);
    }
}

