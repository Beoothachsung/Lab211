/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mode;

/**
 *
 * @author Duongtuandu
 */
public class Doctors {
    private String code;
    private String name;
    private String Specialization;//khoa nào  VD: khoa phụ sản, chỉnh hình
    private int Availability;

    public Doctors() {
    }

    public Doctors(String code, String name, String Specialization, int Availability) {
        this.code = code;
        this.name = name;
        this.Specialization = Specialization;
        this.Availability = Availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    @Override
    public String toString() {
        return String.format("| %-10s| %-15s| %-15s| %-7s|\n", 
                code, name, Specialization, Availability);//định dạng chuỗi
    }
    
}
