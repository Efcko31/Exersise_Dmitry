package ru.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba5Ex13 {
    //Дана матрица. Упорядочить её строки по убыванию первых элементов строк, если это возможно.
    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[][] {
                        {7, 8, 9},
                        {4, 5, 6},
                        {1, 2, 3}},
                sortsRowsInDescendingOrderFirstElementEachRow(new int[][] {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}));
        Assertions.assertArrayEquals(new int[][]{
                        {4, 5, 8, 3},
                        {4, 8, 9, 7},
                        {4, 5, 6, 10},
                        {4, 2, 3, 5}},
                sortsRowsInDescendingOrderFirstElementEachRow(new int[][]{
                        {4, 5, 8, 3},
                        {4, 8, 9, 7},
                        {4, 5, 6, 10},
                        {4, 2, 3, 5}}));
    }

    private static int[][] sortsRowsInDescendingOrderFirstElementEachRow(int[][] matrixArray) {

    return sortByInsertion(matrixArray, writeFirstElementsEachLine(matrixArray));
    }
    private static int[] writeFirstElementsEachLine(int[][] matrixArray){
    int[] arrayFirstElement = new int[matrixArray.length];
    for (int i = 0; i < matrixArray.length; i++) {
        arrayFirstElement[i] = matrixArray[i][0];
    }
    return arrayFirstElement;
    }

    private static int[][] sortByInsertion(int[][] matrixArray, int[] arrayFirstElement) {
        for (int i = 0; i < arrayFirstElement.length; i++) {
            int numForReaplace = arrayFirstElement[i];
            int[] stringForReaplace = matrixArray[i];
            int j = i;
            while (j > 0 && arrayFirstElement[j - 1] < numForReaplace) {
                arrayFirstElement[j] = arrayFirstElement[j - 1];
                matrixArray[j] = matrixArray[j - 1];
                j--;
            }
            arrayFirstElement[j] = numForReaplace;
            matrixArray[j] = stringForReaplace;
        }
    return matrixArray;
    }
}
