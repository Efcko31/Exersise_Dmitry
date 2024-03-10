package ru.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba5Ex8 {
    //Дана квадратная матрица. Упорядочить её строки по неубыванию сумм элементов строк.
    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}},
                sortsSumElementsInAscendingOrder(new int[][]{
                        {7, 8, 9},
                        {4, 5, 6},
                        {1, 2, 3}}));
        Assertions.assertArrayEquals(new int[][]{
                        {1, 2, 3, 5},
                        {4, 5, 8, 3},
                        {4, 5, 6, 10},
                        {7, 8, 9, 7}},
                sortsSumElementsInAscendingOrder(new int[][]{
                        {4, 5, 8, 3},//20
                        {7, 8, 9, 7},//31
                        {4, 5, 6, 10},//25
                        {1, 2, 3, 5}}));//11

        Assertions.assertArrayEquals(new int[][]{
                        {1, 9},
                        {7, 8}},
                sortsSumElementsInAscendingOrder(new int[][]{
                        {7, 8},
                        {1, 9}}));

        Assertions.assertArrayEquals(new int[][]{
                        {3, 3, 3},
                        {3, 3, 3},
                        {3, 3, 3}},
                sortsSumElementsInAscendingOrder(new int[][]{
                        {3, 3, 3},
                        {3, 3, 3},
                        {3, 3, 3}}));
    }

    private static int[][] sortsSumElementsInAscendingOrder(int[][] matrixArray) {

        return sortByInsertion(matrixArray, sumElementString(matrixArray));
    }

    private static int[] sumElementString(int[][] matrixArray) {
        int[] arraySumElementString = new int[matrixArray.length];
        for (int i = 0; i < matrixArray.length; i++) {
            int sumElement = 0;
            for (int j = 0; j < matrixArray[i].length; j++) {
                sumElement += matrixArray[i][j];
            }
            arraySumElementString[i] = sumElement;
        }
        return arraySumElementString;
    }

    private static int[][] sortByInsertion(int[][] matrixArray, int[] arraySumElementString) {
        for (int i = 0; i < arraySumElementString.length; i++) {
            int elemForReaplace = arraySumElementString[i];
            int[] elemForReaplaceForMatrix = matrixArray[i];
            int j = i;
            while (j > 0 && arraySumElementString[j - 1] > elemForReaplace) {
                arraySumElementString[j] = arraySumElementString[j - 1];
                matrixArray[j] = matrixArray[j - 1];
                j--;
            }
            arraySumElementString[j] = elemForReaplace;
            matrixArray[j] = elemForReaplaceForMatrix;
        }
        return matrixArray;
    }
}
