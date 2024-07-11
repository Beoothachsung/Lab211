/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duongtuandu
 */
public class Calculator {

    Validation v = new Validation();

    public int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        if (v.checkAddSub(matrix1, matrix2) == false) {
            return null;
        }
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int addMT[][] = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                addMT[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return addMT;
    }

    public int[][] subMatrix(int[][] matrix1, int[][] matrix2) {
        if (v.checkAddSub(matrix1, matrix2) == false) {
            return null;
        }
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int subMT[][] = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                subMT[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return subMT;
    }

    public int[][] multiMatrix(int[][] matrix1, int[][] matrix2) {
        if (v.checkMulti(matrix1, matrix2) == false) {
            return null;
        }
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int multiMT[][] = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    multiMT[i][j] += matrix1[i][k] * matrix2[k][j]; 
                }
            }
        }
        return multiMT;
    }
}
