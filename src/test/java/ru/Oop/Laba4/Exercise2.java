package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Exercise2 {
    /*Дана целочисленная последовательность. Определить количество вхождений каждого числа в последовательность.*/

    @Test
    public void test() {
        assertArrayEquals(new Integer[]{1, 1, 2, 2, 3, 3, 4, 3, 5, 4, 6, 2, 7, 1, 8, 1, 9, 2},
                numberOccurrencesEachNumberInArray(new Integer[]{3, 7, 8, 6, 4, 5, 5, 5, 4, 6, 4, 9, 2, 9, 2, 1, 3, 5, 3}));
        assertArrayEquals(new Integer[]{3, 6},
                numberOccurrencesEachNumberInArray(new Integer[]{3, 3, 3, 3, 3, 3}));
        assertArrayEquals(new Integer[]{3, 1},
                numberOccurrencesEachNumberInArray(new Integer[]{3}));
        assertArrayEquals(new Integer[]{0, 6},
                numberOccurrencesEachNumberInArray(new Integer[]{0, 0, 0, 0, 0, 0}));
        assertArrayEquals(new Integer[]{3, 2, 4, 2, 8, 2},
                numberOccurrencesEachNumberInArray(new Integer[]{3, 3, 8, 8, 4, 4}));
        assertArrayEquals(new Integer[]{1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 1, 9, 1},
                numberOccurrencesEachNumberInArray(new Integer[]{3, 2, 4, 1, 5, 6, 9, 8, 7}));
        assertThrows(NullPointerException.class, () -> numberOccurrencesEachNumberInArray
                (new Integer[]{}));
    }

    public Integer[] numberOccurrencesEachNumberInArray(Integer[] numberArray) throws NullPointerException {
        try {
            Laba4Util.checkArrayIsEmpty(numberArray);
            ArrayList<Integer> array = new ArrayList<>();
            return countsNumberEachNumberInArray(array, numberArray);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public Integer[] countsNumberEachNumberInArray(ArrayList<Integer> array, Integer[] numberArray) {
        ArrayList<Integer> arrayForNumber = new ArrayList<>();
        
        Laba4Util.addArrayInArrayList(arrayForNumber, numberArray, numberArray.length);
        arrayForNumber.sort(Comparator.naturalOrder());

        for (int i = 0; i < arrayForNumber.size(); i++) {

            if (i > 0 && arrayForNumber.get(i).equals(arrayForNumber.get(i - 1))) {
                array.set(array.size() - 1, array.get(array.size() - 1) + 1);
            } else {
                array.add(arrayForNumber.get(i));
                array.add(1);
            }
        }
    return array.toArray(new Integer[0]);}
}
