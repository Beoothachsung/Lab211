
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Duongtuandu
 */
public class Validation {

    public int getInteger(String input) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            System.out.print(input);
            try {
                n = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid!");
            }
        }
        return n;
    }

    public int[][] inputMatrix(String input, int n) {
        int row, col;

        while (true) {
            System.out.print(input);
            row = getInteger("Enter row matrix " + n + ":  ");
            col = getInteger("Ente col matrix " + n + ": ");

            if (row <= 0 || col <= 0) {
                System.out.println("Rows and columns must be greater than 0.");
            } else {
                break;
            }
        }

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = getInteger("Enter matrix[" + (i + 1) + "][" + (j + 1) + "] : ");
            }
        }
         
        return matrix;
    }

    public int getRow(int[][] matrix) {
        return matrix.length;
    }

    public int getCol(int[][] matrix) {
        return matrix[0].length;
    }

    public void printMatrix(int matrix[][]) {
        int row = getRow(matrix);
        int col = getCol(matrix);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public boolean checkAddSub(int[][] matrix1, int[][] matrix2) {
        int row1 = getRow(matrix1);
        int col1 = getCol(matrix1);
        int row2 = getRow(matrix2);
        int col2 = getCol(matrix2);
        if (row1 == row2 && col1 == col2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkMulti(int[][] matrix1, int[][] matrix2) {
        int row1 = getRow(matrix1);
        int col1 = getCol(matrix1);
        int row2 = getRow(matrix2);
        int col2 = getCol(matrix2);
        if (col1 == row2) {
            return true;
        } else {
            return false;
        }
    }

    public void printResult(int[][] matrix1, int[][] matrix2, int[][] result, char operator) {
        System.out.println("=============RESULT================");
        printMatrix(matrix1);
        System.out.println(operator);
        printMatrix(matrix2);
        System.out.println("=");
        printMatrix(result);
    }

    public void menu() {
        System.out.println("=====Caculator program====");
        System.out.println("1. Addition matrix");
        System.out.println("2. Subtraction matrix");
        System.out.println("3. Multion matrix");
        System.out.println("4. Quit");
    }

}
