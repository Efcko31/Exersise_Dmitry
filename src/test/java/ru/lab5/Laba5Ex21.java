package ru.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba5Ex21 {
    //Дана квадратная матрица. Найти наименьшее из значений элементов побочной диагонали матрицы
    // и соседних с ними справа и слева.
    @Test
    public void test() {
        Assertions.assertEquals(1, findSmallestElementLateralDiagonal(new int[][]{
                {1, 2, 3, 5, 6},
                {7, 5, 3, 4, 9},
                {6, 3, 8, 1, 9},
                {1, 2, 9, 4, 3},
                {7, 5, 3, 9, 1}}));

        Assertions.assertEquals(1, findSmallestElementLateralDiagonal(new int[][]{
                {1, 1, 1, 3, 2},
                {1, 1, 3, 2, 3},
                {1, 3, 2, 3, 1},
                {1, 2, 3, 1, 1},
                {2, 3, 1, 1, 1}}));

        Assertions.assertEquals(18, findSmallestElementLateralDiagonal(new int[][]{
                {1, 1, 1, 20, 19},
                {1, 1, 20, 21, 20},
                {1, 20, 22, 20, 1},
                {20, 23, 20, 1, 1},
                {24, 18, 1, 1, 1}}));

    }

    private static int findSmallestElementLateralDiagonal(int[][] matrixArray) {
        return findSideDiagonal(matrixArray);
    }

    private static int findSideDiagonal(int[][] matrixArray) {
        int minElement = 999999999;
        for (int i = 0; i < matrixArray.length; i++) {
            int j = matrixArray[i].length - 1 - i;
            minElement = findMinElement(matrixArray, i, j, minElement);
        }
        return minElement;
    }

    private static int findMinElement(int[][] matrixArray, int row, int colones, int minElem) {
        for (int i = -1; i < 2; i++) {
            if (colones + i != matrixArray[0].length && colones + i != -1 && minElem > matrixArray[row][colones + i]) {
                minElem = matrixArray[row][colones + i];
            }
        }
        return minElem;
    }


}
