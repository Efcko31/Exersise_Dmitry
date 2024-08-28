package ru.Oop.MatrixOop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class MatrixOopTest {
    MatrixOop matrix1 = new MatrixOop(2, 2, new ArrayList<>());

    MatrixOop matrix2 = new MatrixOop(2, 2, new ArrayList<>());
    MatrixOop matrix3 = new MatrixOop();
    MatrixOop matrix4 = new MatrixOop();
    MatrixOop matrix5 = new MatrixOop();
    MatrixOop matrix6 = new MatrixOop();
    MatrixOop sumMatrix = new MatrixOop();
    MatrixOop multMatrix = new MatrixOop();

    @Test
    public void testMatrix() {
        matrix1.setRow(matrix1.getRow());
        matrix1.setColumn(matrix1.getColumn());
        MatrixUtil.fillsMatrixWithOriginalData(matrix1.getMatrix(), matrix1.getRow(),
                                               matrix1.getColumn(), new Double[] {1.0, 2.0, 3.0, 4.0});
        System.out.println("Матрица №1: ");
        matrix1.printMatrix();

        matrix2.setRow(matrix2.getRow());
        matrix2.setColumn(matrix2.getColumn());
        MatrixUtil.fillsMatrixWithOriginalData(matrix2.getMatrix(),
                                               matrix2.getRow(),
                                               matrix2.getColumn(),
                                               new Double[] {6.0, 7.0, 8.0, 9.0});
        System.out.println("Матрица №2: ");
        matrix2.printMatrix();

        matrix3.setRow(3);
        matrix3.setColumn(3);
        matrix3.setMatrix(new ArrayList<>());
        MatrixUtil.fillsMatrixWithOriginalData(matrix3.getMatrix(),
                                                matrix3.getRow(),
                                                matrix3.getColumn(),
                                                new Double[] {10.0,11.0,12.0,13.0,14.0,15.0,16.0,17.0,18.0});
        System.out.println("Матрица №3: ");
        matrix3.printMatrix();

        matrix4.setRow(3);
        matrix4.setColumn(3);
        matrix4.setMatrix(new ArrayList<>());
        MatrixUtil.fillsMatrixWithOriginalData(matrix4.getMatrix(), matrix4.getRow(),
                matrix4.getColumn(), new Double[] {10.0,9.0,8.0,7.0,6.0,5.0,4.0,3.0,2.0});
        System.out.println("Матрица №4: ");
        matrix4.printMatrix();

        matrix5.setRow(3);
        matrix5.setColumn(2);
        matrix5.setMatrix(new ArrayList<>());
        MatrixUtil.fillsMatrixWithOriginalData(matrix5.getMatrix(), matrix5.getRow(),
                matrix5.getColumn(), new Double[] {10.0,9.0,7.0,6.0,4.0,3.0});
        System.out.println("Матрица №5: ");
        matrix5.printMatrix();

        matrix6.setRow(2);
        matrix6.setColumn(3);
        matrix6.setMatrix(new ArrayList<>());
        MatrixUtil.fillsMatrixWithOriginalData(matrix6.getMatrix(), matrix6.getRow(),
                matrix6.getColumn(), new Double[] {8.0,3.0,2.0,4.0,7.0,1.0});
        System.out.println("Матрица №6: ");
        matrix6.printMatrix();

        System.out.println("Сложение матриц: ");
        sumMatrix.setMatrix(sumMatrix.getAddUpMatrices(matrix1.getMatrix(), matrix2.getMatrix()));
        sumMatrix.printMatrix();

        sumMatrix.setMatrix(sumMatrix.getAddUpMatrices(matrix3.getMatrix(), matrix4.getMatrix()));
        sumMatrix.printMatrix();

        sumMatrix.setMatrix(sumMatrix.getAddUpMatrices(matrix5.getMatrix(), matrix6.getMatrix()));
        sumMatrix.printMatrix();

        System.out.println();
        System.out.println("Умножение матрицы на число: ");
        multMatrix.setMatrix(matrix1.multiplyMatrixByNumber(5));
        multMatrix.printMatrix();

        multMatrix.setMatrix(matrix3.multiplyMatrixByNumber(10));
        multMatrix.printMatrix();

        System.out.println("Умножение матрицы на матрицу: ");
        multMatrix.setMatrix(multMatrix.multiplyMatrixByMatrix(matrix1.getMatrix(), matrix2.getMatrix()));
        multMatrix.printMatrix();

        multMatrix.setMatrix(multMatrix.multiplyMatrixByMatrix( matrix3.getMatrix(), matrix4.getMatrix()));
        multMatrix.printMatrix();

        multMatrix.setMatrix(multMatrix.multiplyMatrixByMatrix( matrix5.getMatrix(), matrix6.getMatrix()));
        multMatrix.printMatrix();


    }
}