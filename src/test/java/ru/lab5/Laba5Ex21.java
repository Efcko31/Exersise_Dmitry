package ru.lab5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.lab5.exception.WrongMatrixSizeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba5Ex21 {
    //Дана квадратная матрица. Найти наименьшее из значений элементов побочной диагонали матрицы
    // и соседних с ними справа и слева.
    @SneakyThrows
    @Test
    public void test() {
        assertThrows(WrongMatrixSizeException.class, () -> findSmallestElementSideAndAdjacentDiagonals(new int[][]{}));

        assertThrows(WrongMatrixSizeException.class, () -> findSmallestElementSideAndAdjacentDiagonals(new int[][]{
                {0, 2, 3, 4, 9, 8, 1, 2},
                {0, 2, 3, 4, 9, 8, 1, 2},
                {0, 2, 3, 4, 9, 8, 1, 2}}));

        assertEquals(1, findSmallestElementSideAndAdjacentDiagonals(new int[][]{
                {1, 2, 3, 5, 6},
                {7, 5, 3, 4, 9},
                {6, 3, 8, 1, 9},
                {1, 2, 9, 4, 3},
                {7, 5, 3, 9, 1}}));

        assertEquals(1, findSmallestElementSideAndAdjacentDiagonals(new int[][]{
                {1, 1, 1, 3, 2},
                {1, 1, 3, 2, 3},
                {1, 3, 2, 3, 1},
                {1, 2, 3, 1, 1},
                {2, 3, 1, 1, 1}}));

        assertEquals(18, findSmallestElementSideAndAdjacentDiagonals(new int[][]{
                {1, 1, 1, 20, 19},
                {1, 1, 20, 21, 20},
                {1, 20, 22, 20, 1},
                {20, 23, 20, 1, 1},
                {24, 18, 1, 1, 1}}));

    }

    private void checkMatrixForTaskConditions(int[][] matrixArray) throws WrongMatrixSizeException {
        if (matrixArray.length == 0 || matrixArray.length != matrixArray[0].length) {
            throw new WrongMatrixSizeException("Матрица не соответствует условмям задачи!");
        }
    }

    private int findSmallestElementSideAndAdjacentDiagonals(int[][] matrixArray) throws WrongMatrixSizeException {
        try {
            checkMatrixForTaskConditions(matrixArray);
        } catch (WrongMatrixSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < matrixArray.length; i++) {
            int j = matrixArray[i].length - 1 - i;
            minElement = findMinElement(matrixArray, i, j, minElement);
        }
        return minElement;
    }

    private int findMinElement(int[][] matrixArray, int row, int colones, int minElement) {
        for (int i = -1; i < 2; i++) {
            if (colones + i != matrixArray[0].length && colones + i != -1 && minElement > matrixArray[row][colones + i]) {
                minElement = matrixArray[row][colones + i];
            }
        }
        return minElement;
    }
}
