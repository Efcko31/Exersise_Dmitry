package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex16 {
    //  С клавиатуры вводятся вещественные числа. Признак конца ввода — ноль. Определить, является ли вводимая
//  последовательность упорядоченной по невозрастанию или по неубыванию.
    @Test
    void testEx16() {
        Assertions.assertEquals("Упорядочена по невозрастанию", testEx16(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
        Assertions.assertEquals("Упорядочена по неубыванию", testEx16(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assertions.assertEquals("Никак не упорядоченна", testEx16(new int[]{1, 2, 3, 3, 5, 6, 7, 6, 4}));
        Assertions.assertEquals("Никак не упорядоченна", testEx16(new int[]{1, 2, 3, 3, 3, 6, 7, 8, 9}));
        Assertions.assertEquals("Упорядочена по неубыванию", testEx16(new int[]{1, 2}));
        Assertions.assertEquals("Упорядочена по неубыванию", testEx16(new int[]{1, 2, 3, 0, 3, 6, 7, 8, 9}));
    }

    private String testEx16(int[] UserNum) {
        boolean decreasing = false, increasing = false;
        for (int i = 1; i < UserNum.length && UserNum[i] != 0; i++) {
            if (UserNum[i] < UserNum[i - 1])
                decreasing = true; // невозрастание (убывание)
            else if (UserNum[i] > UserNum[i - 1])
                increasing = true; // неубывание (возрастание)
            else if (UserNum[i] == UserNum[i - 1]) {
                decreasing = true;
                increasing = true;
            }
        }
        if (decreasing && !increasing)
            return "Упорядочена по невозрастанию";
        else if (!decreasing && increasing)
            return "Упорядочена по неубыванию";
        else
            return "Никак не упорядоченна";
    }
}
