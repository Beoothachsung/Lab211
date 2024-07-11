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
public class employees {

    private String Id;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Email;
    private String Address;
    private int DOB;
    private String Sex;
    private double Salary;
    private String Agency;

    public employees() {
    }

    public employees(String Id, String FirstName, String LastName, String Phone, String Email, String Address, int DOB, String Sex, double Salary, String Agency) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.DOB = DOB;
        this.Sex = Sex;
        this.Salary = Salary;
        this.Agency = Agency;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getDOB() {
        return DOB;
    }

    public void setDOB(int DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getAgency() {
        return Agency;
    }

    public void setAgency(String Agency) {
        this.Agency = Agency;
    }

    @Override
    public String toString() {
        return String.format("| %-5s| %-10s| %-10s| %-12s| %-25s| %-20s| %-10s| %-7s| %-10s| %-15s|\n",
                Id, FirstName, LastName, Phone, Email, Address, DOB, Sex, Salary, Agency);
    }
}
