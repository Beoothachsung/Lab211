/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai0055_doctormanagementprogram;

import Mode.Doctors;
import java.util.ArrayList;

/**
 *
 * @author Duongtuandu
 */
public class BO_Doctors {
    ArrayList<Doctors> doctor = new ArrayList();
    
    public boolean addDoctor(Doctors d){
        if(!checkDuplicateCode(d.getCode())){
            doctor.add(d);
            return true;
        }
        return false;
    }
    
    public boolean isEmpty() {
        if (doctor.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean checkDuplicateCode(String code) {
        for (Doctors e : doctor) {
            if (e.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean updateDoctor(String code, Doctors d2) {
        for (Doctors d : doctor) {
            if (d.getCode().equalsIgnoreCase(code)) {
                d.setName(d2.getName());
                d.setSpecialization(d2.getSpecialization());
                d.setAvailability(d2.getAvailability());
                return true;
            }
        }
        return false;
    }
    
    public Doctors findDoctor(String code) {
        for (Doctors d : doctor) {
            if (d.getCode().equalsIgnoreCase(code)) {
                return d;
            }
        }
        return null;
    }

    public boolean deleteDoctor(String code) {
        for (int i = 0; i < doctor.size(); i++) {
            String delete = doctor.get(i).getCode();
            if (code.equalsIgnoreCase(delete)) {
                doctor.remove(i);
                return true;
            }
        }
        return false;
    }
    
}
