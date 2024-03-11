package ru.lab5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.lab5.exception.WrongMatrixSizeException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba5Ex2 {
    //Дана квадратная матрица. Заменить предпоследний столбец первой из строк, в которой находится максимальный элемент.
    @SneakyThrows
    @Test
    public void test() {
        assertThrows(WrongMatrixSizeException.class, () -> replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{}));
        assertThrows(WrongMatrixSizeException.class, () -> replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{
                {3, 4, 5},
                {1, 2, 5}}));
        assertArrayEquals(new int[][]{
                        {3, 1},
                        {4, 2}},
                replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{
                        {3, 4},
                        {1, 2}}));

        assertArrayEquals(new int[][]{
                        {1, 7, 3},
                        {4, 8, 6},
                        {2, 9, 5}},
                replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}));

        assertArrayEquals(new int[][]{
                        {1, 2, 4, 5},
                        {3, 6, 9, 8},
                        {7, 8, 5, 7},
                        {4, 5, 10, 3}},
                replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{
                        {1, 2, 3, 5},
                        {4, 5, 6, 10},
                        {7, 8, 9, 7},
                        {4, 5, 8, 3}}));

        assertArrayEquals(new int[][]{
                        {3, 3, 3},
                        {3, 3, 3},
                        {3, 3, 3}},
                replacesPenultimateColumnFirstRowWithMaximumElement(new int[][]{
                        {3, 3, 3},
                        {3, 3, 3},
                        {3, 3, 3}}));
    }


    private void checkMatrixIsSquare(int[][] matrixArray) throws WrongMatrixSizeException {
        if (matrixArray.length == 0 || matrixArray.length != matrixArray[0].length) {
            throw new WrongMatrixSizeException("Матрица не удовлетворят условиям задачи");
        }
    }


    private int[][] replacesPenultimateColumnFirstRowWithMaximumElement(int[][] matrixArray) throws WrongMatrixSizeException {
        try {
            checkMatrixIsSquare(matrixArray);
        } catch (WrongMatrixSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        return swapPenultimateColumnWithStringByIndex(matrixArray,
                searchIndexStringWithMaxElement(matrixArray));
    }

    private int searchIndexStringWithMaxElement(int[][] matrixArray) {
        int maxElement = matrixArray[0][0];
        int indexStringWithMaxElement = 0;

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

    private int[][] swapPenultimateColumnWithStringByIndex(int[][] matrixArray, int indexStringWithMaxelement) {
        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[i].length; j++) {
                if (i == indexStringWithMaxelement) {
                    swapTwoCellsInMatrix(matrixArray, i, j);
                }
            }
        }
        return matrixArray;
    }

    private static void swapTwoCellsInMatrix(int[][] matrixArray, int i, int j) {
        int numberForReplace = matrixArray[i][j];
        matrixArray[i][j] = matrixArray[j][matrixArray.length - 2];
        matrixArray[j][matrixArray.length - 2] = numberForReplace;
    }
}
