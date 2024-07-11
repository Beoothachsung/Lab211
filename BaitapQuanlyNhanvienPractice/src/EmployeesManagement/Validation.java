/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeesManagement;

import java.time.LocalDateTime;
import java.util.Scanner;
import Mode.employees;

/**
 *
 * @author Duongtuandu
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

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
                    System.out.println("Please input in range" + min + "to" + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Please input in range" + min + "to" + max);
            }
        }
    }

    public static String getEmail(String input, String valid) {
        while (true) {
            System.out.println(input);
            String s = sc.nextLine();
            if (s.matches(valid)) {
                return s;
            }
            System.out.println("Invalid!");
        }
    }

    public static String updateEmail(String input, String valid) {
        while (true) {
            System.out.println(input);
            String s = sc.nextLine();
            if (s.matches(valid) || s.isEmpty()) {
                return s;
            }
            System.out.println("Invalid!");
        }
    }

    public static String getPhone(String input) {
        while (true) {
            System.out.println(input);
            String s = sc.nextLine();
            if (s.matches("^0\\d{9,10}$")) {
                return s;
            }
            System.out.println("fail!");
        }
    }

    public static String getupdatePhone(String input) {
        while (true) {
            System.out.println(input);
            String s = sc.nextLine();
            if (s.matches("^0\\d{9,10}$") || s.isEmpty()) {
                return s;
            }
            System.out.println("fail!");
        }
    }

    public static int getBirth(String input, int min, int max) {
        int currentYear, n;
        while (true) {
            try {
                System.out.println(input);
                LocalDateTime now = LocalDateTime.now();
                currentYear = now.getYear();
                n = Integer.parseInt(sc.nextLine());
                if (n < currentYear - max || n > currentYear - min) {
                    System.out.println("Suitable year of birth to work is" + (currentYear - max) + " to " + (currentYear - min));
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Please input again!");
            }
        }
    }

    public static Integer getupdateBirth(String input, int min, int max) {
        int currentYear;
        Integer n;
        while (true) {
            try {
                System.out.println(input);
                LocalDateTime now = LocalDateTime.now();
                currentYear = now.getYear();
                String input2 = sc.nextLine();
                if (input2.isEmpty()) {
                    return null;
                }
                n = Integer.parseInt(input2);
                if (n < currentYear - max || n > currentYear - min) {
                    System.out.println("Suitable year of birth to work is " + (currentYear - max) + " to " + (currentYear - min));
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Please input again!");
            }
        }
    }

    public static double getSalary(String input, double min, double max) {
        while (true) {
            try {
                System.out.println(input);
                double n = Double.parseDouble(sc.nextLine());
                if (n < min || n > max) {
                    System.out.println("Please input in range " + min + "to" + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Please input in range " + min + "to" + max);
            }
        }

    }

    public static Double getUpdateSalary(String input, double min, double max) {
        while (true) {
            try {
                System.out.println(input);
                String input2 = sc.nextLine();
                if (input2.isEmpty()) {
                    return null;
                }
                double n = Double.parseDouble(input2);
                if (n < min || n > max) {
                    System.out.println("Please input in range " + min + " --> " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Please input again!");
            }
        }
    }

    public static String getSex(String input) {
        while(true){
            System.out.println(input);
            String s = sc.nextLine();
            if(s.equalsIgnoreCase("male") || s.equalsIgnoreCase("female")){
                return s;
            }
            System.out.println("Please input again!");
        }
    }

    public static String getupdateSex(String input) {
        while (true) {
            System.out.println(input);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("male") || s.equalsIgnoreCase("female") || s.isEmpty()) {
                return s;
            }
            System.out.println("Please input again!");
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
