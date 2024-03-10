package ru.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

public class Laba5Ex27 {
    //Дана квадратная матрица, все элементы которой различны.
    // Поменять местами строки, в которых находятся максимальный и минимальный элементы.
    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[][]{
                        {7, 8, 9},
                        {4, 5, 6},
                        {1, 2, 3}},
                swapsRowsWithMaximumAndMinimumElements(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}));
        Assertions.assertArrayEquals(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {1, 2, 3}},
                swapsRowsWithMaximumAndMinimumElements(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {1, 2, 3}}));
    }

    private static int[][] swapsRowsWithMaximumAndMinimumElements(int[][] matrixArray) {
        return selectingLines(matrixArray);
    }

    private static int[][] selectingLines(int[][] matrixArray) {
        int maxElem = matrixArray[0][0], minElem = matrixArray[0][0];
        int indexMaxElem = 0, indexMinElem = 0;
        boolean flagDuplicate = false;

        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[i].length && !flagDuplicate; j++) {
                if (i > 0 && (matrixArray[i][j] == maxElem | matrixArray[i][j] == minElem)) {
                    flagDuplicate = true;
                    indexMaxElem = 0;
                    indexMinElem = 0;
                } else {
                    if (maxElem < matrixArray[i][j]) {
                        maxElem = matrixArray[i][j];
                        indexMaxElem = i;
                    } else if (minElem > matrixArray[i][j]) {
                        minElem = matrixArray[i][j];
                        indexMinElem = i;
                    }
                }
            }
        }
        return swapRowMatrixArray(matrixArray, indexMaxElem, indexMinElem);
    }

    private static int[][] swapRowMatrixArray(int[][] matrixArray, int indexMaxElem, int indexMinElem) {
        int[] rowForReaplace = matrixArray[indexMaxElem];
        matrixArray[indexMaxElem] = matrixArray[indexMinElem];
        matrixArray[indexMinElem] = rowForReaplace;
        return matrixArray;
    }
}
