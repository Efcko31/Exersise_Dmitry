package ru.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba5Ex7 {
    @Test
// Упорядочить строки данной вещественной матрицы по неубыванию наибольших элементов строк
    public void test() {
        Assertions.assertArrayEquals(new int[][]{
                        {1, 2},
                        {3, 4}},
                sortingRowsInAscendingOrder(new int[][]{
                        {2, 1},
                        {3, 4}}));

        Assertions.assertArrayEquals(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}},
                sortingRowsInAscendingOrder(new int[][]{
                        {2, 3, 1},
                        {4, 5, 6},
                        {9, 7, 8}}));

        Assertions.assertArrayEquals(new int[][]{
                        {1, 2, 2, 3},
                        {4, 5, 5, 6},
                        {7, 8, 8, 9},
                        {10, 11, 11, 12}},
                sortingRowsInAscendingOrder(new int[][]{
                        {2, 3, 1, 2},
                        {6, 4, 5, 5},
                        {8, 8, 9, 7},
                        {10, 11, 11, 12}}));
    }

    private static int[][] sortingRowsInAscendingOrder(int[][] matrixArray) {
        return sortLines(matrixArray);
    }

    private static int[][] sortLines(int[][] matrixArray) {
        for (int i = 0; i < matrixArray.length; i++) {
            sortByInsertion(matrixArray[i]);
        }
        return matrixArray;
    }

    private static int[] sortByInsertion(int[] matrixArray) {
        for (int i = 0; i < matrixArray.length; i++) {
            int x = matrixArray[i];
            int j = i;
            while (j > 0 && matrixArray[j - 1] > x) {
                matrixArray[j] = matrixArray[j - 1];
                j--;
            }
            matrixArray[j] = x;
        }
        return matrixArray;
    }
}
