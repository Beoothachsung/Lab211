/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai0055_doctormanagementprogram;

import Mode.Doctors;

/**
 *
 * @author Duongtuandu
 */
public class managementDoctors {

    BO_Doctors bo = new BO_Doctors();

    public static final String StringVALID = "[a-zA-Z0-9]+";
    public static final String NameVALID = "[a-zA-Z ]+";

    public managementDoctors() {
    }

    public boolean addDoctors() {
        String code;
        while (true) {
            code = Validation.getString("Input code: ", StringVALID);
            if (!bo.checkDuplicateCode(code)) {
                break;
            }
            System.out.println("Code must unique!");
        }

        //Enter all attribute of Doctors
        String name = Validation.getString("Input name: ", NameVALID);

        String specialization = Validation.getString("Input Specialization: ", NameVALID);

        int Availability = Validation.getAvailability("Input Availability: ");

        Doctors d = new Doctors(code, name, specialization, Availability);
        bo.addDoctor(d);
        System.out.println("Add successful");
        return true;
    }

    public boolean updateDoctors() {
        if (bo.isEmpty()) {
            System.out.println("\nThere are no new update\n");
            return false;
        }
        String code;
        while (true) {
            code = Validation.getUpdateString("Input code: ", StringVALID);
            if (bo.checkDuplicateCode(code)) {
                break;
            }
            System.out.println("Code must exits in database!");
        }
        Doctors doctor = bo.findDoctor(code);
        String name = Validation.getUpdateString("Input name: ", NameVALID);
        if (name.isEmpty()) {
            name = doctor.getName();
        }
        String specialization = Validation.getUpdateString("Input Specialization: ", NameVALID);
        if (specialization.isEmpty()) {
            specialization = doctor.getSpecialization();
        }

        Integer Availability = Validation.getUpdateAvailability("Input Availability: ");
        if (Availability == null) {
            Availability = doctor.getAvailability();
        }

        Doctors d = new Doctors(code, name, specialization, Availability);
        bo.updateDoctor(code, d);
        System.out.println("\nUPDATE SUCCESSFUL\n");
        return true;//cập nhật thành công
    }

    public boolean delete() {
        if (bo.isEmpty()) {
            System.out.println("\nThere's nothing to delete\n");
            return false;
        }
        String code;
        while (true) {
            code = Validation.getString("Enter Code: ", StringVALID);
            if (bo.checkDuplicateCode(code)) {
                bo.deleteDoctor(code);
                System.out.println("DELETE SUCCESSFUL!");
                return true;
            }
            System.out.println("Id must exist in database!");
        }
    }

    public void searchDoctor() {
        if (bo.isEmpty()) {
            System.out.println("\nThere's nothing to find\n");
            return;
        }
        //input name or a part of name to display
        String name = Validation.getString("Input name: ", NameVALID);
        System.out.println("");

        System.out.println("All employees have name or part of name: ");
        System.out.printf("| %-10s| %-15s| %-15s| %-7s|\n", "code", "name", "Specialization", "Availability");

        for (Doctors d : bo.doctor) {
            if (d.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(d);
            }
        }
    }

}
