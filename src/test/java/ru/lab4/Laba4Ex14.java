package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex14 {
    //Если возможно, то упорядочить данную последовательность целых чисел по возрастанию.
    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 9}, arrangeInAscendingOrder(new int[]{9, 3, 2, 7, 6, 4, 1, 5}));
        Assertions.assertArrayEquals(new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4}, arrangeInAscendingOrder(new int[]{3, -3, -2, 2, 0, -4, -1, 1, 4}));
        Assertions.assertArrayEquals(new int[]{3, 3}, arrangeInAscendingOrder(new int[]{3, 3}));
    }

    private int[] arrangeInAscendingOrder(int[] numberArray) {
        boolean flagForStop = true;
        while (flagForStop) {
            flagForStop = false;
            for (int i = 1; i < numberArray.length; i++) {
                if (numberArray[i] < numberArray[i - 1]) {
                    int numberReplace = numberArray[i];
                    numberArray[i] = numberArray[i - 1];
                    numberArray[i - 1] = numberReplace;
                    flagForStop = true;
                }
            }
        }
        return numberArray;
    }
}
