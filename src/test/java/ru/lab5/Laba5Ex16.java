package ru.lab5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.lab5.exception.EmptyMatrixExclusion;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba5Ex16 {
    //Дан массив целочисленных матриц. Вывести матрицы, имеющие наибольшее число нулевых строк.
    @SneakyThrows
    @Test
    public void test() {
        assertThrows(EmptyMatrixExclusion.class, () -> searchingMatricesWithLargestNumberZeros(new int[][][]{}));

        assertArrayEquals(new int[][][]{
                        {{0, 0, 0}, {4, 9, 1}, {0, 0, 0}},
                        {{1, 3, 5}, {0, 0, 0}, {0, 0, 0}},
                        null},
                searchingMatricesWithLargestNumberZeros(new int[][][]{
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        {{0, 0, 0}, {4, 9, 1}, {0, 0, 0}},
                        {{1, 3, 5}, {0, 0, 0}, {0, 0, 0}}}));

        assertArrayEquals(new int[][][]{
                        {{0, 0, 0, 0}, {4, 9, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
                        null,
                        null},
                searchingMatricesWithLargestNumberZeros(new int[][][]{
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        {{0, 0, 0, 0}, {4, 9, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
                        {{1, 3, 5}, {0, 0, 0}, {0, 0, 0}}}));

        assertArrayEquals(new int[][][]{
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {4, 8, 2, 0}},
                        {{0, 0, 0, 0}, {4, 9, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
                        {{1, 3, 5, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}},
                searchingMatricesWithLargestNumberZeros(new int[][][]{
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {4, 8, 2, 0}},
                        {{0, 0, 0, 0}, {4, 9, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
                        {{1, 3, 5, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}}));

        assertArrayEquals(new int[][][]{
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}},
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}},
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 3}}},
                searchingMatricesWithLargestNumberZeros(new int[][][]{
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}},
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}},
                        {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 3}}}));

        assertArrayEquals(new int[][][]{
                        null,
                        null,
                        null},
                searchingMatricesWithLargestNumberZeros(new int[][][]{
                        {{1, 0, 0, 0}, {0, 0, 0, 6}, {7, 0, 0, 0}, {0, 0, 0, 12}},
                        {{0, 2, 0, 0}, {0, 0, 5, 0}, {0, 8, 0, 0}, {0, 0, 11, 0}},
                        {{0, 0, 3, 0}, {0, 4, 0, 0}, {0, 0, 9, 0}, {0, 10, 0, 0}}}));

        assertArrayEquals(new int[][][]{
                        {{0}, {0}, {0}, {0}, {0}, {0}, {0}},
                        null,
                        null},
                searchingMatricesWithLargestNumberZeros(new int[][][]{
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        {{0, 0, 0, 0}, {4, 9, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
                        {{0}, {0}, {0}, {0}, {0}, {0}, {0}}}));
    }

    private void checkMatrixForTaskConditions(int[][][] matrixArray) throws EmptyMatrixExclusion{
        if (matrixArray.length == 0) {
        throw new EmptyMatrixExclusion("Матрица - пуста!");
        }
    }

    private int[][][] searchingMatricesWithLargestNumberZeros(int[][][] matrixArray) throws EmptyMatrixExclusion {
        try {
            checkMatrixForTaskConditions(matrixArray);
        } catch (EmptyMatrixExclusion e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        int[][][] MatrixArrayForAnswer = new int[matrixArray.length][][];
        int[] totalStringWithZeroInMatrixArray = new int[matrixArray.length];
        int maxTotal = 0;

        for (int i = 0; i < matrixArray.length; i++) {
            totalStringWithZeroInMatrixArray[i] = countingNumberZeroRowsInMatrix(matrixArray[i]);
            if (maxTotal < totalStringWithZeroInMatrixArray[i]) {
                maxTotal = totalStringWithZeroInMatrixArray[i];
            }
        }
        return writeMatricesWithLargeNumberZerosIntoMatrixArrayForAnswer(totalStringWithZeroInMatrixArray,
                MatrixArrayForAnswer, maxTotal, matrixArray);
    }

    private static int countingNumberZeroRowsInMatrix(int[][] matrixArray) {
        int totalZeroRowInMatrix = 0;
        for (int i = 0; i < matrixArray.length; i++) {
            int sumElemString = 0;
            for (int j = 0; j < matrixArray[i].length; j++) {
                sumElemString += matrixArray[i][j];
            }
            if (sumElemString == 0) {
                totalZeroRowInMatrix++;
            }
        }
        return totalZeroRowInMatrix;
    }

    private static int[][][] writeMatricesWithLargeNumberZerosIntoMatrixArrayForAnswer(int[] totalRowWithZeroInMatrixArray,
                                    int[][][] MatrixArrayForAnswer, int maxTotal, int[][][] matrixArray) {

        int indexAnswerMatrixArray = 0;
        for (int i = 0; i < totalRowWithZeroInMatrixArray.length && maxTotal != 0; i++) {
            if (totalRowWithZeroInMatrixArray[i] == maxTotal) {
                MatrixArrayForAnswer[indexAnswerMatrixArray] = matrixArray[i];
                indexAnswerMatrixArray++;
            }
        }
        while (indexAnswerMatrixArray != totalRowWithZeroInMatrixArray.length) {
            MatrixArrayForAnswer[indexAnswerMatrixArray] = null;
            indexAnswerMatrixArray++;
        }
        return MatrixArrayForAnswer;
    }
}
