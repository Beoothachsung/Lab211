/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0063;

/**
 *
 * @author Duongtuandu
 */
import java.util.Scanner;

public class Main {

    public static Person inputPersonInfo(String inputName, String inputAddress, String inputSalary) throws Exception {
        if (inputName.isEmpty() || inputAddress.isEmpty() || inputSalary.isEmpty()) {
            throw new Exception("You must input all fields.");
        }
        double salary;
        try {
            salary = Double.parseDouble(inputSalary);
            if (salary <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new Exception();
        }
        return new Person(inputName, inputAddress, salary);
    }

    private static boolean isValidNameAddress(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    public static void displayPersonInfo(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Salary: " + person.getSalary());
    }

    public static Person[] sortBySalary(Person[] people) {
        int n = people.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (people[i].getSalary() > people[i + 1].getSalary()) {
                    Person temp = people[i];
                    people[i] = people[i + 1];
                    people[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return people;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person[] people = new Person[3];

        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Enter information for Person " + (i + 1));
                System.out.print("Name: ");
                String name = sc.nextLine().trim();
                System.out.print("Address: ");
                String address = sc.nextLine().trim();
                System.out.print("Salary: ");
                String Salary = sc.nextLine().trim();

                if (!isValidNameAddress(name)) {
                    throw new Exception();
                }

                people[i] = inputPersonInfo(name, address, Salary);
            } catch (Exception e) {
                System.out.println("Invalid!");
                i--;
            }
        }

        System.out.println("Displaying information for all people:");
        for (Person person : people) {
            displayPersonInfo(person);
        }

        people = sortBySalary(people);
        System.out.println("\nDisplaying information sorted by salary:");
        for (Person person : people) {
            displayPersonInfo(person);
        }

        sc.close();
    }
}
