package ru.lab5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.lab5.exception.WrongMatrixSizeException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba5Ex8DmitryMethod {
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

        for (int i = 0; i < matrixArray.length; i++) {

            int[] rowForReplace = matrixArray[i];
            int j = i;
            while (j > 0 && sumElementRow(matrixArray[j - 1]) > sumElementRow(rowForReplace)) {
                matrixArray[j] = matrixArray[j - 1];
                j--;
            }
            matrixArray[j] = rowForReplace;
        }
        return matrixArray;
    }

    private int sumElementRow(int[] matrixArray) {
        int sumElement = 0;
        for (int j = 0; j < matrixArray.length; j++) {
            sumElement += matrixArray[j];
        }
        return sumElement;
    }
}