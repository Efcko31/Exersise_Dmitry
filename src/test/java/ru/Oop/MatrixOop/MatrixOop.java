package ru.Oop.MatrixOop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatrixOop {

    private Integer row;
    private Integer column;
    private ArrayList<ArrayList<Double>> matrix = new ArrayList<>();

    public ArrayList<ArrayList<Double>> multiplyMatrixByMatrix(ArrayList<ArrayList<Double>> matrix1,
                                                               ArrayList<ArrayList<Double>> matrix2) {
        ArrayList<ArrayList<Double>> multMatrices = new ArrayList<>();

            if (checkTheSizeMatrix("*", matrix2, matrix1)) {
                multiply(multMatrices, matrix1, matrix2);
            } else {
                return null;
            }
        return multMatrices;
    }

    public ArrayList<ArrayList<Double>> multiplyMatrixByNumber(int number) {
        ArrayList<ArrayList<Double>> multMatrix = new ArrayList<>();

        for (int i = 0; i < matrix.size(); i++) {
            multMatrix.add(new ArrayList<>());
            for (int j = 0; j < matrix.get(i).size(); j++) {
                multMatrix.get(i).add(j, matrix.get(i).get(j) * number);
            }
        }
        return multMatrix;
    }


    public ArrayList<ArrayList<Double>> getAddUpMatrices(ArrayList<ArrayList<Double>> matrix1,
                                                         ArrayList<ArrayList<Double>> matrix2) {
        ArrayList<ArrayList<Double>> sumMatrices = new ArrayList<>();

            if (checkTheSizeMatrix("+", matrix2, matrix1)) {
                for (int i = 0; i < matrix2.size(); i++) {
                    sumMatrices.add(new ArrayList<>());
                    for (int j = 0; j < matrix2.get(i).size(); j++) {
                        sumMatrices.get(i).add(j, matrix2.get(i).get(j) + matrix1.get(i).get(j));
                    }
                }
            } else {
                return null;
            }
        return sumMatrices;
    }


    public void multiply(ArrayList<ArrayList<Double>> multMatrices,
                         ArrayList<ArrayList<Double>> matrix1,
                         ArrayList<ArrayList<Double>> matrix2) {

        for (int m = 0; m < matrix1.size(); m++) {
            multMatrices.add(new ArrayList<>());
            for (int g = 0; g < matrix1.size(); g++) {
                multMatrices.get(m).add(0d);
            }
        }

        for (int i = 0; i < matrix2.size(); i++) {
            for (int j = 0; j < matrix2.get(i).size(); j++) {
                multMatrices.get(j).set(i,
                        multMatrices.get(j).get(i) + matrix2.get(i).get(j) * matrix1.get(j).get(i));
            }
            // multMatrices.get(i).add(j, matrix1.get(i).get(n) * matrix2.get(n).get(j));
        }
    }


    public boolean checkTheSizeMatrix(String operation,
                                      ArrayList<ArrayList<Double>> matrix1,
                                      ArrayList<ArrayList<Double>> matrix2) {
        if (operation.equals("*")) {
            if (matrix1.get(0).size() != matrix2.size()) {
                System.out.println("Эти матрицы нельзя перемножить!");
                return false;
            }
        } else if (operation.equals("+")) {
            if (matrix1.get(0).size() != matrix2.get(0).size() | matrix1.size() != matrix2.size()) {
                System.out.println("Эти матрицы нельзя сложить!");
                return false;
            }
        }
        return true;
    }


    public void printMatrix() {
        try {
            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    System.out.printf("%.2f ", matrix.get(i).get(j));
                }
                System.out.println();
            }
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Переделывай!");

        }
    }
}
