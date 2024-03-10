package ru.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba5Ex2 {
    //Дана квадратная матрица. Заменить предпоследний столбец первой из строк, в которой находится максимальный элемент.
    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[][]{
                        {3, 1},
                        {4, 2}},
                replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{
                        {3, 4},
                        {1, 2}}));

        Assertions.assertArrayEquals(new int[][]{
                        {1, 7, 3},
                        {4, 8, 6},
                        {2, 9, 5}},
                replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}));

        Assertions.assertArrayEquals(new int[][]{
                        {1, 2, 4, 5},
                        {3, 6, 9, 8},
                        {7, 8, 5, 7},
                        {4, 5, 10, 3}},
                replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{
                        {1, 2, 3, 5},
                        {4, 5, 6, 10},
                        {7, 8, 9, 7},
                        {4, 5, 8, 3}}));

        Assertions.assertArrayEquals(new int[][]{
                        {3, 3, 3},
                        {3, 3, 3},
                        {3, 3, 3}},
                replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{
                        {3, 3, 3},
                        {3, 3, 3},
                        {3, 3, 3}}));
    }

    private static int[][] replacesPenultimateColumnFirstRowWithMaximumElement(int[][] matrixArray) {
        return replacementAccordingCondition(matrixArray,
                searchIndexStringWithMaxElement(matrixArray));
    }

    private static int searchIndexStringWithMaxElement(int[][] matrixArray) {
        int maxElement = -1, indexStringWithMaxElement = -1;

        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[i].length; j++) {
                if (maxElement < matrixArray[i][j]) {
                    indexStringWithMaxElement = i;
                    maxElement = matrixArray[i][j];
                }
            }
        }
        return indexStringWithMaxElement;
    }

    private static int[][] replacementAccordingCondition(int[][] matrixArray, int indexStringWithMaxelement) {
        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[i].length; j++) {
                if (i == indexStringWithMaxelement) {
                    int numberForReaplace = matrixArray[i][j];
                    matrixArray[i][j] = matrixArray[j][matrixArray.length - 2];
                    matrixArray[j][matrixArray.length - 2] = numberForReaplace;
                }
            }
        }
        return matrixArray;
    }
}
