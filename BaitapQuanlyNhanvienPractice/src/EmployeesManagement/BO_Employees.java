/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeesManagement;

import Mode.employees;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Duongtuandu
 */
public class BO_Employees {

    ArrayList<employees> employ = new ArrayList<>();

    public void addEmployees(employees e) {
        employ.add(e);
    }

    public boolean isEmpty() {
        if (employ.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean checkDuplicateId(String id) {
        for (employees e : employ) {
            if (e.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicateEmail(String email) {
        for (employees e : employ) {
            if (e.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public void updateEmployees(String id, employees e2) {
        for (employees e : employ) {
            if (e.getId().equalsIgnoreCase(id)) {
                e.setFirstName(e2.getFirstName());
                e.setLastName(e2.getLastName());
                e.setPhone(e2.getPhone());
                e.setEmail(e2.getEmail());
                e.setAddress(e2.getAddress());
                e.setDOB(e.getDOB());
                e.setSex(e2.getSex());
                e.setSalary(e2.getSalary());
                e.setAgency(e2.getAgency());
            }
        }
    }

    public employees findEmployees(String id) {
        for (employees e : employ) {
            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    public void removeEmployees(String id) {
        for (int i = 0; i < employ.size(); i++) {
            String delete = employ.get(i).getId();
            if (id.equalsIgnoreCase(delete)) {
                employ.remove(i);
            }
        }
    }

    public void sortEmployees() {
        Collections.sort(employ, new Comparator<employees>() {
            @Override
            public int compare(employees o1, employees o2) {
                if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                } else if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

}
