package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex12 {
    // Если члены данной последовательности не упорядочены по возрастанию, то удалить
    //все последующие вхождения каждого числа.
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[] {1, 2, 3, 6, 0}, checkForOrder(new int[]{1, 2, 3, 6, 5}));
        Assertions.assertArrayEquals(new int[] {1, 4, 0, 0, 0}, checkForOrder(new int[]{1, 4, 3, 5, 6}));
        Assertions.assertArrayEquals(new int[] {1, 2}, checkForOrder(new int[]{1, 2}));

    }

    private int[] checkForOrder(int[] numberArray) {
        for (int i = 1; i < numberArray.length; i++) {
            if (numberArray[i] <= numberArray[i - 1] | numberArray[i - 1] == 0) {
                numberArray[i] = 0;
            }
        }
        return numberArray;
    }

}
