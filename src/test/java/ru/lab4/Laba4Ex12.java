package ru.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba4Ex12 {
    // Если члены данной последовательности не упорядочены по возрастанию, то удалить
    //все последующие вхождения каждого числа.
    private static final String NEGATIVE = "нет";
    private static final String POSITIVE = "да";
    @Test
    void test(){
        Assertions.assertEquals(NEGATIVE, checkingForOrder(new int[]{0, 1, 2, 3, 6, 5}));
        Assertions.assertEquals(NEGATIVE, checkingForOrder(new int[]{0, 1, 4, 3, 5, 6}));
        Assertions.assertEquals(POSITIVE, checkingForOrder(new int[]{0, 1}));

    }

    private String checkingForOrder(int[] numberArray) {
        boolean flagCheckingForOrder = true;
        for (int i = 1; i < numberArray.length; i++) {
            if (flagCheckingForOrder && (numberArray[i] < numberArray[i - 1])){
                flagCheckingForOrder = false;
            }
        }
        return flagCheckingForOrder ? POSITIVE : NEGATIVE;
    }

}
