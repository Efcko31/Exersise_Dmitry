package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;
import ru.dto.LinkedListByEfckoTypeInteger;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise6UsingLinkedListByEckoTypeInteger {
     /*Определить, можно ли, переставив члены данной целочисленной последовательности,
    получить арифметическую прогрессию.*/

    @Test
    public void test() {
        assertTrue(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{9, 3, 12, 6, 15}));
        assertFalse(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{9, 3, 7, 6, 4, 2}));
        assertFalse(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{9, 3, 12, 6, 15, 16}));
        assertTrue(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{3, 6, 9, 12, 15}));
        assertFalse(determinesWhetherAnArithmeticProgressionExistsInArray(new Integer[]{1, 2, 3, 4, 15}));
        assertThrows(NullPointerException.class, () -> determinesWhetherAnArithmeticProgressionExistsInArray
                (new Integer[]{}));
    }

    public boolean determinesWhetherAnArithmeticProgressionExistsInArray(Integer[] numbers) {
        try {
            Laba4Util.checkArrayIsEmpty(numbers);
            LinkedListByEfckoTypeInteger numbersArray = new LinkedListByEfckoTypeInteger();
            addToLinkedList(numbers, numbersArray);
            insertingAnElementByValue(numbersArray);

            int diff = numbersArray.get(1) - numbersArray.get(0);
            for (int i = 2; i < numbersArray.size(); i++) {
                if (numbersArray.get(i) - numbersArray.get(i - 1) != diff) {
                    return false;
                }
            }
            return true;

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void addToLinkedList(Integer[] numbers, LinkedListByEfckoTypeInteger numbersArray) {
        for (Integer number : numbers) {
            numbersArray.add(number);
        }
    }

    public void insertingAnElementByValue(LinkedListByEfckoTypeInteger numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            int x = numbersList.get(i);
            int j = i;
            while (j > 0 && numbersList.get(j - 1) > x) {
                numbersList.set(j, numbersList.get(j - 1));
                --j;
            }
            numbersList.set(j, x);
        }
    }
}
