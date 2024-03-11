package ru.lab5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.lab5.exception.WrongMatrixSizeException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba5Ex8 {
    //Дана квадратная матрица. Упорядочить её строки по неубыванию сумм элементов строк.
    // Переделать так, чтобы каждая суммированная строка становилась на свое место без массива сумм строки
    @SneakyThrows
    @Test
    public void test() {
        assertThrows(WrongMatrixSizeException.class, () -> sortsSumElementsInAscendingOrderByInsertion(new int[][]{}));
        assertThrows(WrongMatrixSizeException.class, () -> sortsSumElementsInAscendingOrderByInsertion(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        }));

        assertArrayEquals(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}},
                sortsSumElementsInAscendingOrderByInsertion(new int[][]{
                        {7, 8, 9},
                        {4, 5, 6},
                        {1, 2, 3}}));

        assertArrayEquals(new int[][]{
                        {1, 2, 3, 5},
                        {4, 5, 8, 3},
                        {4, 5, 6, 10},
                        {7, 8, 9, 7}},
                sortsSumElementsInAscendingOrderByInsertion(new int[][]{
                        {4, 5, 8, 3},//20
                        {7, 8, 9, 7},//31
                        {4, 5, 6, 10},//25
                        {1, 2, 3, 5}}));//11

        assertArrayEquals(new int[][]{
                        {1, 9},
                        {7, 8}},
                sortsSumElementsInAscendingOrderByInsertion(new int[][]{
                        {7, 8},
                        {1, 9}}));

        assertArrayEquals(new int[][]{
                        {3, 3, 3},
                        {3, 3, 3},
                        {3, 3, 3}},
                sortsSumElementsInAscendingOrderByInsertion(new int[][]{
                        {3, 3, 3},
                        {3, 3, 3},
                        {3, 3, 3}}));
    }

    private void checkMatrixIsSquad(int[][] matrixArray) throws WrongMatrixSizeException {
        if (matrixArray.length == 0 || matrixArray.length != matrixArray[0].length) {
            throw new WrongMatrixSizeException("Матрица не удовлетворяет условиям задачи!");
        }
    }
    private int[][] sortsSumElementsInAscendingOrderByInsertion(int[][] matrixArray) throws WrongMatrixSizeException {
        try {
            checkMatrixIsSquad(matrixArray);
        } catch (WrongMatrixSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException();
        }
        return sortRowMatrixArrayByInsertion(matrixArray, sumElementRow(matrixArray));
    }

    private int[] sumElementRow(int[][] matrixArray) {
        int[] arraySumElementString = new int[matrixArray.length];
        for (int i = 0; i < matrixArray.length; i++) {
            int sumElement = 0;
            for (int j = 0; j < matrixArray[i].length; j++) {
                sumElement += matrixArray[i][j];
            }
            arraySumElementString[i] = sumElement;
        }
        return arraySumElementString;
    }

    private int[][] sortRowMatrixArrayByInsertion(int[][] matrixArray, int[] arraySumElementString) {
        for (int i = 0; i < arraySumElementString.length; i++) {
            int elemForReplace = arraySumElementString[i];
            int[] elemForReplaceForMatrix = matrixArray[i];
            int j = i;
            while (j > 0 && arraySumElementString[j - 1] > elemForReplace) {
                arraySumElementString[j] = arraySumElementString[j - 1];
                matrixArray[j] = matrixArray[j - 1];
                j--;
            }
            arraySumElementString[j] = elemForReplace;
            matrixArray[j] = elemForReplaceForMatrix;
        }
        return matrixArray;
    }
}
