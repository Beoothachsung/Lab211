/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailayloc0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Duongtuandu
 */
public class Bailayloc0001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = inputPostiveInteger();

        int[] arr = generateRandomArray(n);

        System.out.println("Unsorted array:");
        displayArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted array:");
        displayArray(arr);
    }

    public static int inputPostiveInteger() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nunber of aray: ");
        int n;
        while (true) {
            try {

                n = Integer.parseInt(sc.nextLine());
                if (n > 0) {

                    break;
                } else {
                    System.out.println("input must be greater than 0");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error!");
            }
        }
        return n;

    }

    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            try {
                arr[i] = random.nextInt(100);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }

        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {

                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
