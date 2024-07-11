/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import EmployeesManagement.ManageEmploy;
import EmployeesManagement.Validation;


/**
 *
 * @author Duongtuandu
 */
public class Menu {
    private static String[] ops = {
        "Add employees",
        "Update employees",
        "Remove employees",
        "Search employees",
        "Sort employees by salary",
        "Exit"
    };
    
    public static int getChoice() {
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i + 1) + "." + ops[i]);
        }
        return Validation.getInt("Input your choice: ", 1, ops.length);
    }
    
    public static void display() {
        ManageEmploy e = new ManageEmploy();
        int choice;
        do {
            System.out.println("");
            System.out.println("EMPLOYEES MANAGEMENT");
            choice = getChoice();
            switch (choice) {
                case 1:
                    e.addEmployees();
                    break;
                case 2:
                    e.updateEmployees();
                    break;
                case 3:
                    e.remove();
                    break;
                case 4:
                    e.searchEmployees();
                    break;
                case 5:
                    e.sortSalary();
                    break;
                case 6:
                    break;
            }
        } while (choice != 6);
    }
}
