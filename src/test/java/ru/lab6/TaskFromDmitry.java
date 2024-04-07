package ru.lab6;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.lab6.EmptyMatrixExclusionForLaba6;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskFromDmitry {
    //Дана двухмерная матрица, вывести на экран повторяющиеся строки и количество их повторений в матрице.
    //Для вывода используй String.format
    @SneakyThrows
    @Test
    public void test() {
        assertThrows(EmptyMatrixExclusionForLaba6.class, () ->
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{}));

        assertEquals(" Строка: [1, 2, 3, 4], повторяется 5 раз. ",
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{
                        {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                        {{10, 0, 0, 0}, {1, 2, 3, 4}, {0, 0, 2, 0}, {1, 2, 3, 4}},
                        {{1, 2, 3, 4}, {0, 3, 0, 0}, {0, 0, 0, 1}, {1, 2, 3, 4}}}));

        assertEquals(" Строка: [1, 2, 3, 4], повторяется 3 раза. Строка: [5, 6, 7, 8], повторяется 3 раза. " +
                        "Строка: [9, 10, 11, 12], повторяется 3 раза. Строка: [13, 14, 15, 16], повторяется 3 раза. ",
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{
                        {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                        {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                        {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}}));

        assertEquals(" Строка: [1, 2, 3, 4], повторяется 2 раза. ",
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{
                        {{1, 2, 3, 4}, {4, 3, 2, 1}, {3, 4, 2, 1}, {2, 3, 4, 1}},
                        {{1, 3, 2, 4}, {1, 4, 3, 2}, {1, 3, 4, 2}, {1, 2, 4, 3}},
                        {{3, 2, 4, 1}, {3, 2, 1, 4}, {2, 4, 1, 3}, {1, 2, 3, 4}}}));

        assertEquals(" ",
                showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(new int[][][]{
                        {{1, 3, 3, 4}, {4, 3, 2, 1}, {3, 4, 2, 1}, {2, 3, 4, 1}},
                        {{1, 3, 2, 4}, {1, 4, 3, 2}, {1, 3, 4, 2}, {1, 2, 4, 3}},
                        {{3, 2, 4, 1}, {3, 2, 1, 4}, {2, 4, 1, 3}, {1, 4, 3, 4}}}));

    }

    private void checkMatrixForTaskConditions(int[][][] matrixArray) throws EmptyMatrixExclusionForLaba6 {
        if (matrixArray.length == 0) {
            throw new EmptyMatrixExclusionForLaba6("Матрица - пуста!");
        }
    }

    private String showsRepeatedRowsAndNumberTheirRepetitionsInMatrix(int[][][] matrixArray) throws EmptyMatrixExclusionForLaba6 {
        try {
            checkMatrixForTaskConditions(matrixArray);
        } catch (EmptyMatrixExclusionForLaba6 e) {
            System.out.println(e.getMessage());
            throw e;
        }

        String answer = " ";
        int[][] rowsMatrixArray = new int[(matrixArray.length * matrixArray[0].length) * 2][matrixArray[0].length];

        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[i].length; j++) {
                findDuplicateInRowsMatrixArray(rowsMatrixArray, matrixArray[i][j]);
            }
        }

        return messageFormation(rowsMatrixArray, answer);
    }

    private void findDuplicateInRowsMatrixArray(int[][] rowsMatrixArray, int[] matrixArrayRow) {
        for (int i = 0; i < rowsMatrixArray.length; i += 2) {
            if (Arrays.equals(rowsMatrixArray[i], matrixArrayRow)) {
                rowsMatrixArray[i + 1][0] += 1;
                i = rowsMatrixArray.length;
            } else if (IntStream.of(rowsMatrixArray[i]).sum() == 0) {
                rowsMatrixArray[i] = matrixArrayRow;
                rowsMatrixArray[i + 1][0] += 1;
                i = rowsMatrixArray.length;
            }
        }
    }

    private String messageFormation(int[][] rowsMatrixArray, String answer) {
        StringBuilder answerBuilder = new StringBuilder(answer);
        for (int i = 0; i < rowsMatrixArray.length; i += 2) {
            if (rowsMatrixArray[i + 1][0] > 1) {
                String messageConstructor = String.format("Строка: %s, повторяется %d ",
                        Arrays.toString(rowsMatrixArray[i]), rowsMatrixArray[i + 1][0]);
                answerBuilder.append(messageConstructor);
                if (rowsMatrixArray[i + 1][0] > 4) {
                    answerBuilder.append("раз. ");
                } else {
                    answerBuilder.append("раза. ");
                }
            }
        }
        answer = answerBuilder.toString();
        return answer;
    }
}
