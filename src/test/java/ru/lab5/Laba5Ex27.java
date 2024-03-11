package ru.lab5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.lab5.exception.WrongMatrixSizeException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba5Ex27 {
    //Дана квадратная матрица, все элементы которой различны.
    // Поменять местами строки, в которых находятся максимальный и минимальный элементы.
    @SneakyThrows
    @Test
    public void test() {
        assertThrows(WrongMatrixSizeException.class, () -> swapsRowsWithMaximumAndMinimumElements(new int[][]{}));

        assertThrows(WrongMatrixSizeException.class, () -> swapsRowsWithMaximumAndMinimumElements(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {0, 9, 8, 7, 6, 5, 4, 3, 2, 1}}));

        assertArrayEquals(new int[][]{
                        {7, 8, 9},
                        {4, 5, 6},
                        {1, 2, 3}},
                swapsRowsWithMaximumAndMinimumElements(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}));

        assertArrayEquals(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {1, 2, 3}},
                swapsRowsWithMaximumAndMinimumElements(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {1, 2, 3}}));

        assertArrayEquals(new int[][]{
                        {7, 8, 9},
                        {4, 5, 6},
                        {3, 2, 1}},
                swapsRowsWithMaximumAndMinimumElements(new int[][]{
                        {3, 2, 1},
                        {4, 5, 6},
                        {7, 8, 9}}));


        assertArrayEquals(new int[][]{
                        {4, 5, 6},
                        {9, 2, 1},
                        {7, 8, 3}},
                swapsRowsWithMaximumAndMinimumElements(new int[][]{
                        {4, 5, 6},
                        {9, 2, 1},
                        {7, 8, 3}}));

        assertArrayEquals(new int[][]{
                        {4, 5, 1},
                        {2, 9, 6},
                        {7, 8, 3}},
                swapsRowsWithMaximumAndMinimumElements(new int[][]{
                        {2, 9, 6},
                        {4, 5, 1},
                        {7, 8, 3}}));

        assertArrayEquals(new int[][]{
                        {4, 5, 1},
                        {2, 9, 6},
                        {7, 8, 7}},
                swapsRowsWithMaximumAndMinimumElements(new int[][]{
                        {2, 9, 6},
                        {4, 5, 1},
                        {7, 8, 7}}));


    }

    private void checkMatrixForTaskConditions(int[][] matrixArray) throws WrongMatrixSizeException {
        if (matrixArray.length == 0 || matrixArray.length != matrixArray[0].length) {
            throw new WrongMatrixSizeException("Матрица не соответствует условиям задачи!");
        }
    }

    private int[][] swapsRowsWithMaximumAndMinimumElements(int[][] matrixArray) throws WrongMatrixSizeException {
        try {
            checkMatrixForTaskConditions(matrixArray);
        } catch (WrongMatrixSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        int maxElem = matrixArray[0][0];
        int minElem = matrixArray[0][0];
        int indexMaxElem = 0;
        int indexMinElem = 0;

        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[i].length; j++) {
                if (i > 0 && (matrixArray[i][j] == maxElem | matrixArray[i][j] == minElem)) {
                    j = matrixArray[i].length;
                    i = matrixArray.length - 1;
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

    private int[][] swapRowMatrixArray(int[][] matrixArray, int indexMaxElem, int indexMinElem) {
        int[] rowForReplace = matrixArray[indexMaxElem];
        matrixArray[indexMaxElem] = matrixArray[indexMinElem];
        matrixArray[indexMinElem] = rowForReplace;
        return matrixArray;
    }
}
