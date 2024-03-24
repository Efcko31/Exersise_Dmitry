package ru.lab5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.lab5.exception.EmptyMatrixExclusion;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba5Ex7 {
    @SneakyThrows
    @Test
// Упорядочить строки данной вещественной матрицы по возрастанию наибольших элементов строк
    public void test() {
        assertThrows(EmptyMatrixExclusion.class, () -> accessEachLine(new int[][]{}));

        assertArrayEquals(new int[][]{
                        {1, 2, 3, 8},
                        {3, 4, 5, 6},
                        {7, 8, 9, 12}},
                accessEachLine(new int[][]{
                        {8, 3, 1, 2},
                        {4, 5, 6, 3},
                        {9, 7, 8, 12}}));

        assertArrayEquals(new int[][]{
                        {1, 2},
                        {3, 4}},
                accessEachLine(new int[][]{
                        {2, 1},
                        {3, 4}}));

        assertArrayEquals(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}},
                accessEachLine(new int[][]{
                        {2, 3, 1},
                        {4, 5, 6},
                        {9, 7, 8}}));

        assertArrayEquals(new int[][]{
                        {-1, 2, 2, 3},
                        {-5, 4, 5, 6},
                        {7, 8, 8, 9},
                        {10, 11, 11, 12}},
                accessEachLine(new int[][]{
                        {2, 3, -1, 2},
                        {6, 4, -5, 5},
                        {8, 8, 9, 7},
                        {10, 11, 11, 12}}));
    }

    private void checkMatrixForTaskConditions(int[][] matrixArray) throws EmptyMatrixExclusion {
        if (matrixArray.length == 0) {
            throw new EmptyMatrixExclusion("Матрица - пуста!");
        }
    }

    private int[][] accessEachLine(int[][] matrixArray) throws EmptyMatrixExclusion {
        try {
            checkMatrixForTaskConditions(matrixArray);
        } catch (EmptyMatrixExclusion e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < matrixArray.length; i++) {
            sortMatrixArrayByInsertion(matrixArray[i]);
        }
        return matrixArray;
    }

    private void sortMatrixArrayByInsertion(int[] matrixArray) {
        for (int i = 0; i < matrixArray.length; i++) {
            int x = matrixArray[i];
            int j = i;
            while (j > 0 && matrixArray[j - 1] > x) {
                matrixArray[j] = matrixArray[j - 1];
                j--;
            }
            matrixArray[j] = x;
        }
    }
}
