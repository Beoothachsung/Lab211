/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duongtuandu
 */
public class Main {

    public static void main(String[] args) {
        Validation v = new Validation();
        Calculator c = new Calculator();
        int choice;

        while (true) {
            int[][] matrix1, matrix2, result;
            v.menu();
            choice = v.getInteger("Your choice: ");
            switch (choice) {
                case 1:
                    System.out.println("-----Addition Matrix-----");
                    matrix1 = v.inputMatrix("Matrix 1:\n", 1);
                    matrix2 = v.inputMatrix("Matrix 2:\n", 2);
                    result = c.addMatrix(matrix1, matrix2);
                    if (result == null) {
                        System.out.println("2 row, column must equal!");
                        return;
                    }
                    v.printResult(matrix1, matrix2, result, '+');
                    break;
                case 2:
                    System.out.println("-----Subtraction Matrix-----");
                    matrix1 = v.inputMatrix("Matrix 1:\n", 1);
                    matrix2 = v.inputMatrix("Matrix 2:\n", 2);
                    result = c.subMatrix(matrix1, matrix2);
                    if (result == null) {
                        System.out.println("2 row, column must equal!");
                        return;
                    }
                    v.printResult(matrix1, matrix2, result, '-');

                    break;
                case 3:
                    System.out.println("-----Multiplication Matrix-----");
                    matrix1 = v.inputMatrix("Matrix 1:\n", 1);
                    matrix2 = v.inputMatrix("Matrix 2:\n", 2);
                    result = c.multiMatrix(matrix1, matrix2);
                    if (result == null) {
                        System.out.println("Column matrix 1 must equal row matrix 2!");
                        return;
                    }
                    v.printResult(matrix1, matrix2, result, '*');
                    break;
                case 4:
                    System.out.println("Exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choose from 1 to 4");
            }

            if (choice == 4) {
                break;
            }
        }
    }
}
