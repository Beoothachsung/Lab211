/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai0055_doctormanagementprogram;

import java.util.Scanner;

/**
 *
 * @author Duongtuandu
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    
    public static String getString(String input, String valid) {
        while (true) {
            System.out.println(input);
            String s = sc.nextLine();
            if (s.matches(valid)) {
                return s;
            }
            System.out.println("Fail!");
        }
    }
    
    public static int getInt(String input, int min, int max) {
        while (true) {
            try {
                System.out.println(input);
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println("Please input in range" + min + "to" + max);
            }
        }
    }
    
    public static int getAvailability (String input){
        while(true){
            try{
                System.out.println(input);
                int n = Integer.parseInt(sc.nextLine());
                if (n>=0){
                    return n;
                }
                System.out.println("Invalid! Please input again");
            }catch(NumberFormatException e){
                System.out.println("Fail!");
            }
        }
    }
    
    public static Integer getUpdateAvailability (String input){
        Integer n;
        while(true){
            try{
                System.out.println(input);
                String s = sc.nextLine();
                if (s.isEmpty()){
                    return null;
                }
                n = Integer.parseInt(s);
                if (n>=0){
                    return n;
                }
                System.out.println("Invalid! Please input again");
            }catch(NumberFormatException e){
                System.out.println("Fail!");
            }
        }
    }
    
    public static String getUpdateString(String input, String valid) {
        while (true) {
            System.out.println(input);
            String s = sc.nextLine();
            if (s.matches(valid) || s.isEmpty()) {
                return s;
            }
            System.out.println("Fail!");
        }
    }
}
