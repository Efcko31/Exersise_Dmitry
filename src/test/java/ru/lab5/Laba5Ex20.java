package ru.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba5Ex20 {
    //Дана прямоугольная матрица. Упорядочить столбцы матрицы по невозрастанию (убыванию) минимальных элементов столбцов.
    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[][]{{9, 7, 2, 3, 1}, {8, 5, 4, 7, 3}, {9, 7, 4, 2, 6}},
                sortsColumnsInDescendingOrder(new int[][]{{1, 7, 2, 9, 3}, {3, 5, 4, 8, 7}, {6, 7, 4, 9, 2}}));
    }

    private static int[][] sortsColumnsInDescendingOrder(int[][] matrixArray) {
        return sortsColumns(matrixArray, searchMinElementInColumn(matrixArray));
    }

    private static int[] searchMinElementInColumn(int[][] matrixArray) {
        int[] minElemInColumn = new int[matrixArray[0].length];

        for (int i = 0; i < matrixArray[0].length; i++) {
            int minElem = 9999999;
            for (int j = 0; j < matrixArray.length; j++) {
                if (minElem > matrixArray[j][i]) {
                    minElem = matrixArray[j][i];
                }
            }
            minElemInColumn[i] = minElem;
        }
        return minElemInColumn;
    }

    private static int[][] sortsColumns(int[][] matrixArray, int[] minElemInColumn) {
       for (int i = 0; i < matrixArray[0].length; i++) {
           int maxIndex = sortByChoise(minElemInColumn, i);
           int numberForReaplace = minElemInColumn[i];
           minElemInColumn[i] = minElemInColumn[maxIndex];
           minElemInColumn[maxIndex] = numberForReaplace;
           for (int j = 0; j < matrixArray.length; j++) {
               int numberForReaplaceForMatrix = matrixArray[j][i];
               matrixArray[j][i] = matrixArray[j][maxIndex];
               matrixArray[j][maxIndex] = numberForReaplaceForMatrix;
           }
       }
        return matrixArray;
    }

    private static int sortByChoise(int[] minElemInColumn, int start) {
        int maxValue = minElemInColumn[start], maxIndex = start;
        for (int i = start; i < minElemInColumn.length; i++) {
            if (maxValue < minElemInColumn[i]) {
                maxValue = minElemInColumn[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
