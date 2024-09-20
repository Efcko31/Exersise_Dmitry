package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise6 {
    /*Определить, можно ли, переставив члены данной целочисленной последовательности,
    получить арифметическую прогрессию.*/

    @Test
    public void test() {
        assertTrue(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{9, 3, 12, 6, 15}));
        assertFalse(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{9, 3, 7, 6, 4, 2}));
        assertFalse(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{9, 3, 12, 6, 15, 16}));
        assertTrue(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{3, 6, 9, 12, 15}));
        assertFalse(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{1, 2, 3, 4, 15}));
    }

    public boolean determinesWhetherAnArithmeticProgressionExistsInArray(Integer[] numberArray) {
        try {
            Laba4Util.checkArrayIsEmpty(numberArray);

            ArrayList<Integer> array = new ArrayList<>();

            Laba4Util.addArrayInArrayList(array, numberArray, numberArray.length);
            array.sort(Comparator.naturalOrder());

            return lookingForAnArithmeticProgression(array);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public boolean lookingForAnArithmeticProgression(ArrayList<Integer> array) {
        Integer step = array.get(1) - array.get(0);

        for (int i = 2; i < array.size(); i++) {
            if (!step.equals(array.get(i) - array.get(i - 1))) {
                return false;
            }
        }
        return true;
    }
}
