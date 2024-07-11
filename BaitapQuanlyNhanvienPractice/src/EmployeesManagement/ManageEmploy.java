/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeesManagement;

import Mode.employees;
import java.time.LocalDateTime;
import java.util.Formatter;

/**
 *
 * @author Duongtuandu
 */
public class ManageEmploy {

    BO_Employees bo = new BO_Employees();

    public static final String StringVALID = "[a-zA-Z0-9]+";
    public static final String NameVALID = "[a-zA-Z]+";
    public static final String PhoneVALID = "[0-9]+";
    public static final String AddressVALID = "[a-zA-Z0-9 ]+";
    public static final String EmailVALID = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z0-9]+)$";

    public ManageEmploy() {
    }

    public void addEmployees() {
        String id;
        while (true) {
            id = Validation.getString("Input id: ", StringVALID);
            if (!bo.checkDuplicateId(id)) {
                break;
            }
            System.out.println("Id must unique!");
        }

        //Enter all employees attributes
        String firstName = Validation.getString("Input first name: ", NameVALID);
        String lastName = Validation.getString("Input last name: ", NameVALID);
        String phone = Validation.getPhone("Input phone number: ");
        String email;
        while (true) {
            email = Validation.getEmail("Input email: ", EmailVALID);
            if (!bo.checkDuplicateEmail(email)) {
                break;
            }
            System.out.println("Email already exists");
        }
        String address = Validation.getString("Input address: ", AddressVALID);
        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        //
        int dob = Validation.getBirth("Input your birth from " + (currentYear - 60) + " to " + (currentYear - 18) + ": ", 18, 60);
        String sex = Validation.getSex("Input your sex: ");
        double salary = Validation.getSalary("Input salary: ", 1, 1000000);
        String agency = Validation.getString("Input agency: ", StringVALID);

        //create an employees contain all atribute
        employees e = new employees(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
        bo.addEmployees(e);
        System.out.println("Add successful");
    }

    public void updateEmployees() {
        if (bo.isEmpty()) {
            System.out.println("\nThere are no new update\n");
            return;
        }
        //find id to update
        String id;
        while (true) {
            id = Validation.getString("Input id to update: ", StringVALID);
            if (bo.checkDuplicateId(id)) {
                break;
            }
            System.out.println("Id must exits in database");
        }
        //get employee
        employees employ = bo.findEmployees(id);

        //update employ
        String firstName = Validation.getUpdateString("Input first name: ", NameVALID);
        if (firstName.isEmpty()) {
            firstName = employ.getFirstName();
        }
        String lastName = Validation.getUpdateString("Input last name: ", NameVALID);
        if (lastName.isEmpty()) {
            lastName = employ.getLastName();
        }
        String phone = Validation.getupdatePhone("Input phone number: ");
        if (phone.isEmpty()) {
            phone = employ.getPhone();
        }
        String email;
        while (true) {
            email = Validation.updateEmail("Input email: ", EmailVALID);
            if (!bo.checkDuplicateEmail(email)) {
                break;
            }
            System.err.println("Email already exists!");
        }
        if (email.isEmpty()) {
            email = employ.getEmail();
        }
        String address = Validation.getUpdateString("Input address: ", AddressVALID);
        if (address.isEmpty()) {
            address = employ.getAddress();
        }
        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        Integer dob = Validation.getupdateBirth("Input your birth from " + (currentYear - 60) + " to " + (currentYear - 18) + ": ", 18, 60);
        if (dob == null) {
            dob = employ.getDOB();
        }
        String sex = Validation.getupdateSex("Input your sex: ");
        if (sex.isEmpty()) {
            sex = employ.getSex();
        }
        Double salary = Validation.getUpdateSalary("Input salary: ", 1, 1000000);
        if (salary == null) {
            salary = employ.getSalary();
        }
        String agency = Validation.getUpdateString("Input agency: ", StringVALID);
        if (agency.isEmpty()) {
            agency = employ.getAgency();
        }

        employees e = new employees(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
        bo.updateEmployees(id, e);
        System.out.println("\nUPDATE SUCCESSFUL\n");
    }

    public void remove() {
        if (bo.isEmpty()) {
            System.out.println("\nthere are no new update\n");
            return;
        }
        String id;
        while (true) {
            id = Validation.getString("Enter Id: ", StringVALID);
            if (bo.checkDuplicateId(id)) {
                break;
            }
            System.out.println("Id must exist in database");
        }
        bo.removeEmployees(id);
        System.out.println("Remove SUCCESSFUL!");
    }

    public void searchEmployees() {
        if (bo.isEmpty()) {
            System.out.println("\nthere are no new update\n");
            return;
        }
        String name = Validation.getUpdateString("Input name: ", NameVALID);
        System.out.println("");

        System.out.println("All employees have name or part of name: ");
        System.out.printf("| %-5s| %-10s| %-10s| %-12s| %-25s| %-20s| %-10s| %-7s| %-10s| %-15s|\n",
                "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "SEX", "Salary", "Agency");

        for (employees e : bo.employ) {
            if (e.getFirstName().toLowerCase().contains(name) || e.getLastName().toLowerCase().contains(name)) {
                System.out.println(e);
            }
        }
    }

    public void sortSalary() {
        if (bo.isEmpty()) {
            System.out.println("\nthere are no new update\n");
            return;
        }
        System.out.println("Employees after sort: ");
        bo.sortEmployees();
        System.out.printf("| %-5s| %-10s| %-10s| %-12s| %-25s| %-20s| %-10s| %-7s| %-10s| %-15s|\n",
                "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "SEX", "Salary", "Agency");
        for (employees e : bo.employ) {
            System.out.println(e);
        }
    }

}
