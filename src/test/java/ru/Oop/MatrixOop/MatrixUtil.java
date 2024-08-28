package ru.Oop.MatrixOop;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class MatrixUtil {
    public static void fillsMatrixWithOriginalData(ArrayList<ArrayList<Double>> matrix,
                                                   Integer row,
                                                   Integer column,
                                                   Double[] numbers) {
        int indexOfNumbers = 0;
         if (row * column != numbers.length) {
             System.out.printf("Ошибка! В матрице размером %dx%d должно быть %d чисел\n", row, column, row * column);
         } else {
             for (int i = 0; i < row; i++) {
                 matrix.add(new ArrayList<>());
                 for (int j = 0; j < column; j++) {
                     matrix.get(i).add(numbers[indexOfNumbers]);
                     indexOfNumbers++;
                 }
             }
         }
    }
}
