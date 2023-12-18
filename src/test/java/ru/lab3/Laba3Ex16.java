package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex16 {
//  С клавиатуры вводятся вещественные числа. Признак конца ввода — ноль. Определить, является ли вводимая
//  последовательность упорядоченной по невозрастанию или по неубыванию.
    @Test
    void testEx16(){
        Assertions.assertEquals("Упорядочена по невозрастанию", testEx16(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1}));
        Assertions.assertEquals("Упорядочена по неубыванию", testEx16(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assertions.assertEquals("Никак не упорядоченна", testEx16(new int[] {1, 2, 3, 3, 5, 6, 7, 6, 4}));
        Assertions.assertEquals("Никак не упорядоченна", testEx16(new int[] {1, 2, 3, 3, 3, 6, 7, 8, 9}));
        Assertions.assertEquals("Упорядочена по неубыванию", testEx16(new int[] {1, 2}));
    }
    private String testEx16(int[] UserNum){
        int total_1 = 0, total_2 = 0;
        for(int i=1; i < UserNum.length; i++){
            if(UserNum[i] < UserNum[i - 1])
                total_1++; // невозрастание (убывание)
            else if (UserNum[i] > UserNum[i - 1])
                total_2++; // неубывание (возрастание)
            else if (UserNum[i] == UserNum[i - 1]) {
                total_1++;
                total_2++;
            }
        }
        if(total_1 > 0 && total_2 == 0)
            return "Упорядочена по невозрастанию";
        else if (total_2 > 0 && total_1 == 0)
            return "Упорядочена по неубыванию";
        else
            return "Никак не упорядоченна";
    }
}
