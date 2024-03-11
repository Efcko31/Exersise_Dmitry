package ru.lab5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.lab5.exception.WrongMatrixSizeException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba5Ex20 {
    //Дана прямоугольная матрица. Упорядочить столбцы матрицы по убыванию минимальных элементов столбцов.
    @SneakyThrows
    @Test
    public void test() {
        assertThrows(WrongMatrixSizeException.class, () -> sortsColumnsInDescendingOrderSmallerElements(new int[][]{}));

        assertThrows(WrongMatrixSizeException.class, () -> sortsColumnsInDescendingOrderSmallerElements(new int[][]{
                        {1, 2, 3, 0, 10},
                        {4, 3, 6, 7, 8},
                        {5, 8, 7, 5, 2},
                        {1, 2, 0, 9, 5},
                        {4, 2, 3, 9, 5}}));

        assertArrayEquals(new int[][]{
                        {9, 7, 2, 3, 1},
                        {8, 5, 4, 7, 3},
                        {9, 7, 4, 2, 6}},
                sortsColumnsInDescendingOrderSmallerElements(new int[][]{
                        {1, 7, 2, 9, 3},
                        {3, 5, 4, 8, 7},
                        {6, 7, 4, 9, 2}}));

        assertArrayEquals(new int[][]{
                        {9, 9, 9, 9, 9},
                        {5, 4, 3, 2, 1},
                        {7, 7, 7, 7, 7}},
                sortsColumnsInDescendingOrderSmallerElements(new int[][]{
                        {9, 9, 9, 9, 9},
                        {3, 1, 4, 2, 5},
                        {7, 7, 7, 7, 7}}));

        assertArrayEquals(new int[][]{
                        {5, 5, 5, 1, 9},
                        {1, 5, 1, 5, 1},
                        {7, 1, 7, 7, 5}},
                sortsColumnsInDescendingOrderSmallerElements(new int[][]{
                        {5, 5, 5, 1, 9},
                        {1, 5, 1, 5, 1},
                        {7, 1, 7, 7, 5}}));

        assertArrayEquals(new int[][]{
                        {5, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {7, 0, 0, 0, 0}},
                sortsColumnsInDescendingOrderSmallerElements(new int[][]{
                        {5, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {7, 0, 0, 0, 0}}));
    }

    private void checkMatrixForTaskConditions(int[][] matrixArray) throws WrongMatrixSizeException {
        if (matrixArray.length == 0 || matrixArray.length == matrixArray[0].length) {
            throw new WrongMatrixSizeException("Матрица не соответствует условиям задачи!");
        }
    }

    private int[][] sortsColumnsInDescendingOrderSmallerElements(int[][] matrixArray) throws WrongMatrixSizeException { // по убывания чего?
        try {
            checkMatrixForTaskConditions(matrixArray);
        } catch (WrongMatrixSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        int[] minElemInColumn = new int[matrixArray[0].length];

        for (int i = 0; i < matrixArray[0].length; i++) {
            int minElem = matrixArray[0][i];

            for (int j = 0; j < matrixArray.length; j++) {
                if (minElem > matrixArray[j][i]) {
                    minElem = matrixArray[j][i];
                }
            }
            minElemInColumn[i] = minElem;
        }
        return sortsColumnsMatrixArrayInDescendingOrderByChoice(matrixArray, minElemInColumn);
    }

    private int[][] sortsColumnsMatrixArrayInDescendingOrderByChoice(int[][] matrixArray, int[] minElemInColumn) { // по чему сортиурем?
        for (int i = 0; i < matrixArray[0].length; i++) {
            int maxIndexColumnInMatrixArray = searchMaxElement(minElemInColumn, i);
            changesElementsBetweenEachOther(minElemInColumn, maxIndexColumnInMatrixArray, i);

            for (int j = 0; j < matrixArray.length; j++) {
                changesColumnsBetweenEachOther(matrixArray, maxIndexColumnInMatrixArray, i, j);
            }
        }
        return matrixArray;
    }

    private int searchMaxElement(int[] minElemInColumn, int start) {
        int maxValue = minElemInColumn[start];
        int maxIndex = start;

        for (int i = start; i < minElemInColumn.length; i++) {
            if (maxValue < minElemInColumn[i]) {
                maxValue = minElemInColumn[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void changesColumnsBetweenEachOther(int[][] matrixArray, int maxIndexColumnInMatrixArray, int row, int colomn) {
        int numberForReplaceForMatrix = matrixArray[colomn][row];
        matrixArray[colomn][row] = matrixArray[colomn][maxIndexColumnInMatrixArray];
        matrixArray[colomn][maxIndexColumnInMatrixArray] = numberForReplaceForMatrix;

    }

    private void changesElementsBetweenEachOther(int[] minElemInColumn, int maxIndexColumnInMatrixArray, int row) {
        int numberForReplace = minElemInColumn[row];
        minElemInColumn[row] = minElemInColumn[maxIndexColumnInMatrixArray];
        minElemInColumn[maxIndexColumnInMatrixArray] = numberForReplace;
    }
}
