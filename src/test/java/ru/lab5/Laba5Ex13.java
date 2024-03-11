package ru.lab5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.lab5.exception.EmptyMatrixExclusion;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba5Ex13 {
    //Дана матрица. Упорядочить её строки по убыванию первых элементов строк, если это возможно.
    @SneakyThrows
    @Test
    public void test() {
        assertThrows(EmptyMatrixExclusion.class, () -> sortsRowsInDescendingOrderFirstElementEachRowUseInsertionSorting(new int[][]{}));

        assertArrayEquals(new int[][] {
                        {7, 8, 9, 4},
                        {4, 5, 6, 8},
                        {1, 2, 3, -6}},
                sortsRowsInDescendingOrderFirstElementEachRowUseInsertionSorting(new int[][] {
                        {1, 2, 3, -6},
                        {4, 5, 6, 8},
                        {7, 8, 9, 4}}));

        assertArrayEquals(new int[][]{
                        {4, 5, 8, 3},
                        {4, 8, 9, 7},
                        {4, 5, 6, 10},
                        {4, 2, 3, 5}},
                sortsRowsInDescendingOrderFirstElementEachRowUseInsertionSorting(new int[][]{
                        {4, 5, 8, 3},
                        {4, 8, 9, 7},
                        {4, 5, 6, 10},
                        {4, 2, 3, 5}}));
    }

    private void checkMatrixForTaskConditions(int[][] matrixArray) throws EmptyMatrixExclusion {
        if (matrixArray.length == 0) {
        throw new EmptyMatrixExclusion("Матрица - пуста!");
        }
    }

    private int[][] sortsRowsInDescendingOrderFirstElementEachRowUseInsertionSorting(int[][] matrixArray)
            throws EmptyMatrixExclusion{
        try {
            checkMatrixForTaskConditions(matrixArray);
        } catch (EmptyMatrixExclusion e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < matrixArray.length; i++) {
            int[] stringForReplace = matrixArray[i];
            int arrayFirstElement = matrixArray[i][0];
            int j = i;

            while (j > 0 && matrixArray[j - 1][0] < arrayFirstElement) {
                matrixArray[j] = matrixArray[j - 1];
                j--;
            }
            matrixArray[j] = stringForReplace;
        }
    return matrixArray;
    }
}
