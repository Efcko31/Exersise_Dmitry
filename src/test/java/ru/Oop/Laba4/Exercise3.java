package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise3 {
    /* Если число x встречается в последовательности, то упорядочить по убыванию часть последовательности до последнего
    вхождения x */
    @Test
    public void test() {
        assertArrayEquals(new Integer[]{9, 7, 6, 3, 4, 2}, checksForPresenceNumberX(
                new Integer[]{9, 3, 7, 6, 4, 2}, 4));
        assertArrayEquals(new Integer[]{9, 7, 3, 6, 4, 1, 2}, checksForPresenceNumberX(
                new Integer[]{9, 3, 7, 6, 4, 1, 2}, 6));
        assertArrayEquals(new Integer[]{1, 3, 5, 4, 2, 9, 7}, checksForPresenceNumberX(
                new Integer[]{1, 3, 5, 4, 2, 9, 7}, 0));
        assertThrows(NullPointerException.class, () -> checksForPresenceNumberX(new Integer[]{}, 0));
    }

    public Integer[] checksForPresenceNumberX(Integer[] numberArray, Integer x) {
        try {
            Laba4Util.checkArrayIsEmpty(numberArray);
            ArrayList<Integer> array = new ArrayList<>();
            Laba4Util.addArrayInArrayList(array, numberArray, numberArray.length);
            int indexX = array.lastIndexOf(x);
            return indexX == -1 ? numberArray : sortsAllNumbersUpNumberXInDescendingOrder(numberArray, array, indexX);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public Integer[] sortsAllNumbersUpNumberXInDescendingOrder(Integer[] numberArray,
                                                               ArrayList<Integer> array,
                                                               int indexX) {
        array.clear();
        Laba4Util.addArrayInArrayList(array, numberArray, indexX);
        array.sort(Comparator.reverseOrder());

        for (int i = indexX; i < numberArray.length; i++) {
            array.add(numberArray[i]);
        }
        return array.toArray(new Integer[0]);
    }

}
