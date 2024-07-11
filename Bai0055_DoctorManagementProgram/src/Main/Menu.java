/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import bai0055_doctormanagementprogram.Validation;
import bai0055_doctormanagementprogram.managementDoctors;

/**
 *
 * @author Duongtuandu
 */
public class Menu {
    private static String[] ops = {
        "Add doctors",
        "Update doctors",
        "Delete doctors",
        "Search doctors",
        "Exit"
    };
    
    public static int getChoice() {
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i + 1) + "." + ops[i]);
        }
        return Validation.getInt("Input your choice: ", 1, ops.length);
    }
    
    public static void display() {
        managementDoctors d = new managementDoctors();
        int choice;
        do {
            System.out.println("");
            System.out.println("DOCTORS MANAGEMENT");
            choice = getChoice();
            switch (choice) {
                case 1:
                    d.addDoctors();
                    break;
                case 2:
                    d.updateDoctors();
                    break;
                case 3:
                    d.delete();
                    break;
                case 4:
                    d.searchDoctor();
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}
