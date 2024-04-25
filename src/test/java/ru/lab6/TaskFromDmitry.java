package ru.lab6;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.lab6.exception.emptyMatrixException;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskFromDmitry {
    //Дана двухмерная матрица, вывести на экран повторяющиеся строки и количество их повторений в матрице.
    //Для вывода используй String.format. Посчитать количество повторений каждой строки в массиве данных.
    @SneakyThrows
    @Test
    public void test() {
        assertThrows(emptyMatrixException.class, () ->
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{}));

        assertEquals("В матрице 1: " +
                        "Строка [1, 2, 3, 4], повторяется 2 раза. " +
                        "Строка [5, 6, 7, 8], повторяется 2 раза. " +
                        "В матрице 2: " +
                        "Строка [10, 0, 0, 0], повторяется 1 раз. " +
                        "Строка [1, 2, 3, 4], повторяется 2 раза. " +
                        "Строка [0, 0, 2, 0], повторяется 1 раз. " +
                        "В матрице 3: " +
                        "Строка [1, 2, 3, 4], повторяется 2 раза. " +
                        "Строка [0, 3, 0, 0], повторяется 1 раз. " +
                        "Строка [0, 0, 0, 1], повторяется 1 раз. ",
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{
                        {       {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {1, 2, 3, 4},
                                {5, 6, 7, 8}
                        },
                        {
                                {10, 0, 0, 0},
                                {1, 2, 3, 4},
                                {0, 0, 2, 0},
                                {1, 2, 3, 4}
                        },
                        {
                                {1, 2, 3, 4},
                                {0, 3, 0, 0},
                                {0, 0, 0, 1},
                                {1, 2, 3, 4}
                        }}));

        assertEquals("В матрице 1: " +
                        "Строка [1, 2, 3, 4], повторяется 1 раз. " +
                        "Строка [5, 6, 7, 8], повторяется 1 раз. " +
                        "Строка [9, 10, 11, 12], повторяется 1 раз. " +
                        "Строка [13, 14, 15, 16], повторяется 1 раз. " +
                        "В матрице 2: " +
                        "Строка [1, 2, 3, 4], повторяется 1 раз. " +
                        "Строка [5, 6, 7, 8], повторяется 1 раз. " +
                        "Строка [9, 10, 11, 12], повторяется 1 раз. " +
                        "Строка [13, 14, 15, 16], повторяется 1 раз. " +
                        "В матрице 3: " +
                        "Строка [1, 2, 3, 4], повторяется 1 раз. " +
                        "Строка [5, 6, 7, 8], повторяется 1 раз. " +
                        "Строка [9, 10, 11, 12], повторяется 1 раз. " +
                        "Строка [13, 14, 15, 16], повторяется 1 раз. ",
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{
                        {
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        },
                        {
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        },
                        {
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        }
                }));

        assertEquals("В матрице 1: " +
                        "Строка [4, 3, 2, 1], повторяется 4 раза. " +
                        "В матрице 2: " +
                        "Строка [1, 3, 4, 2], повторяется 4 раза. " +
                        "В матрице 3: " +
                        "Строка [1, 2, 3, 4], повторяется 4 раза. ",
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{
                        {
                                {4, 3, 2, 1},
                                {4, 3, 2, 1},
                                {4, 3, 2, 1},
                                {4, 3, 2, 1}
                        },
                        {
                                {1, 3, 4, 2},
                                {1, 3, 4, 2},
                                {1, 3, 4, 2},
                                {1, 3, 4, 2}},
                        {
                                {1, 2, 3, 4},
                                {1, 2, 3, 4},
                                {1, 2, 3, 4},
                                {1, 2, 3, 4}
                        }}));

        assertEquals("В матрице 1: " +
                        "Строка [1, 3, 3, 4], повторяется 2 раза. " +
                        "Строка [4, 3, 2, 1], повторяется 2 раза. " +
                        "В матрице 2: " +
                        "Строка [1, 3, 2, 4], повторяется 4 раза. " +
                        "В матрице 3: " +
                        "Строка [3, 2, 4, 1], повторяется 2 раза. " +
                        "Строка [2, 4, 1, 3], повторяется 2 раза. ",
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{
                        {
                                {1, 3, 3, 4},
                                {4, 3, 2, 1},
                                {1, 3, 3, 4},
                                {4, 3, 2, 1}
                        },
                        {
                                {1, 3, 2, 4},
                                {1, 3, 2, 4},
                                {1, 3, 2, 4},
                                {1, 3, 2, 4}
                        },
                        {
                                {3, 2, 4, 1},
                                {3, 2, 4, 1},
                                {2, 4, 1, 3},
                                {2, 4, 1, 3}
                        }}));

        assertEquals("В матрице 1: " +
                        "Строка [0, 0, 0, 0], повторяется 4 раза. " +
                        "В матрице 2: " +
                        "Строка [0, 0, 0, 0], повторяется 4 раза. " +
                        "В матрице 3: " +
                        "Строка [0, 0, 0, 0], повторяется 4 раза. ",
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{
                        {
                                {0, 0, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0}
                        },
                        {
                                {0, 0, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0}
                        },
                        {
                                {0, 0, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0}
                        }}));

    }


    private String showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(int[][][] matrixArray) throws emptyMatrixException {
        checkMatrixForTaskConditions(matrixArray);

        String answer = "";

        for (int i = 0; i < matrixArray.length; i++) {
            answer += "В матрице " + (i + 1) + ": ";
            int[][] rowsMatrixArray = new int[(matrixArray[0].length) * 2][matrixArray[0].length];
            for (int j = 0; j < matrixArray[i].length; j++) {
                findDuplicateInRowsMatrixArray(rowsMatrixArray, matrixArray[i][j]);
            }
            answer += messageFormation(rowsMatrixArray);
        }
        return answer;
    }

    private void checkMatrixForTaskConditions(int[][][] matrixArray) throws emptyMatrixException {
        if (matrixArray.length == 0) {
            throw new emptyMatrixException("Матрица - пуста!");
        }
    }

    private void findDuplicateInRowsMatrixArray(int[][] rowsMatrixArray, int[] matrixArrayRow) {
        for (int i = 0; i < rowsMatrixArray.length; i += 2) {
            if (Arrays.equals(rowsMatrixArray[i], matrixArrayRow)) {
                rowsMatrixArray[i + 1][0] += 1;
                i = rowsMatrixArray.length;
            } else if (IntStream.of(rowsMatrixArray[i + 1]).sum() == 0) {
                rowsMatrixArray[i] = matrixArrayRow;
                rowsMatrixArray[i + 1][0] += 1;
                i = rowsMatrixArray.length;
            }
        }
    }

    private String messageFormation(int[][] rowsMatrixArray) {
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < rowsMatrixArray.length; i += 2) {
            if (rowsMatrixArray[i + 1][0] > 0) {
                String messageConstructor = String.format("Строка %s, повторяется %d ",
                        Arrays.toString(rowsMatrixArray[i]), rowsMatrixArray[i + 1][0]);
                answerBuilder.append(messageConstructor);
                if (rowsMatrixArray[i + 1][0] > 4 || rowsMatrixArray[i + 1][0] <= 1) {
                    answerBuilder.append("раз. ");
                } else {
                    answerBuilder.append("раза. ");
                }
            }
        }
        return answerBuilder.toString();
    }
}
