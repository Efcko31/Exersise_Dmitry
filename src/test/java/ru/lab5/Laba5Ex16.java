package ru.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba5Ex16 {
    //Дан массив целочисленных матриц. Вывести матрицы, имеющие наибольшее число
    //нулевых строк.
    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[][][]{
                        {{0, 0, 0}, {4, 9, 1}, {0, 0, 0}},
                        {{1, 3, 5}, {0, 0, 0}, {0, 0, 0}},
                        null},
                searchingMatricesWithLargestNumberZeros(new int[][][]{
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        {{0, 0, 0}, {4, 9, 1}, {0, 0, 0}},
                        {{1, 3, 5}, {0, 0, 0}, {0, 0, 0}}}));

        Assertions.assertArrayEquals(new int[][][]{
                        {{0, 0, 0, 0}, {4, 9, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
                        null,
                        null},
                searchingMatricesWithLargestNumberZeros(new int[][][]{
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        {{0, 0, 0, 0}, {4, 9, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
                        {{1, 3, 5}, {0, 0, 0}, {0, 0, 0}}}));

        Assertions.assertArrayEquals(new int[][][]{
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {4, 8, 2, 0}},
                        {{0, 0, 0, 0}, {4, 9, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
                        {{1, 3, 5, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}},
                searchingMatricesWithLargestNumberZeros(new int[][][]{
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {4, 8, 2, 0}},
                        {{0, 0, 0, 0}, {4, 9, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
                        {{1, 3, 5, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}}));
    }

    private static int[][][] searchingMatricesWithLargestNumberZeros(int[][][] matrixArray) {
        return searchingInsideAnArrayWithMatrices(matrixArray);
    }

    private static int[][][] searchingInsideAnArrayWithMatrices(int[][][] matrixArray) {
        int[][][] answerMatrixArray = matrixArray;
        int[] totalStringWithZeroInMatrixArray = new int[matrixArray.length];
        int maxTotal = 0;

        for (int i = 0; i < matrixArray.length; i++) {
            totalStringWithZeroInMatrixArray[i] = searchInsideTheMatrix(matrixArray[i]);
            if (maxTotal < totalStringWithZeroInMatrixArray[i]) {
                maxTotal = totalStringWithZeroInMatrixArray[i];
            }
        }
        return answer(totalStringWithZeroInMatrixArray, answerMatrixArray,  maxTotal, matrixArray);
    }

    private static int searchInsideTheMatrix(int[][] matrixArray) {
        int totalZeroStringInMatrix = 0;
        for (int i = 0; i < matrixArray.length; i++) {
            int sumElemString = 0;
            for (int j = 0; j < matrixArray[i].length; j++) {
                sumElemString += matrixArray[i][j];
            }
            if (sumElemString == 0) {
                totalZeroStringInMatrix++;
            }
        }
        return totalZeroStringInMatrix;
    }

    private static int[][][] answer(int[] totalStringWithZeroInMatrixArray,
                                    int[][][] answerMatrixArray, int maxTotal, int[][][] matrixArray) {
        int indexAnswerMatrixArray = 0;
        for(int i = 0; i < totalStringWithZeroInMatrixArray.length; i++) {
            if(totalStringWithZeroInMatrixArray[i] == maxTotal){
                answerMatrixArray[indexAnswerMatrixArray] = matrixArray[i];
                indexAnswerMatrixArray++;
            }
        }
        while (indexAnswerMatrixArray != totalStringWithZeroInMatrixArray.length) {
            answerMatrixArray[indexAnswerMatrixArray] = null;
            indexAnswerMatrixArray++;
        }
    return answerMatrixArray;
    }
}
