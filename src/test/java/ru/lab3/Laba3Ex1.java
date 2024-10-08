package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class Laba3Ex1 {
    // Найти все простые делители данного натурального числа.
    // Как проверить число, на то, что это число?
    @Test
    void testEx1() {

        Assertions.assertArrayEquals(new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0}, searchAllPrimeDivisorsNumber(4));
        Assertions.assertArrayEquals(new int[]{2, 3, 5, 31, 0, 0, 0, 0, 0, 0}, searchAllPrimeDivisorsNumber(4650));
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, searchAllPrimeDivisorsNumber(0));
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, searchAllPrimeDivisorsNumber(1));
        Assertions.assertArrayEquals(new int[]{61, 0, 0, 0, 0, 0, 0, 0, 0, 0}, searchAllPrimeDivisorsNumber(61));
        Assertions.assertArrayEquals(new int[]{1279, 0, 0, 0, 0, 0, 0, 0, 0, 0}, searchAllPrimeDivisorsNumber(1279));
    }

    private int[] searchAllPrimeDivisorsNumber(int number) {
        int[] answer = new int[10];
        int indexAnswer = 0, totalNum = 2;

        while (totalNum <= number) {
            if (number % totalNum == 0) {
                answer[indexAnswer] = totalNum;
                number /= totalNum;
                indexAnswer++;
                totalNum++;
            } else {
                totalNum++;
            }
        }
        return answer;
    }
}
