
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Duongtuandu
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public int getChoice(String input, int min, int max) {
        while (true) {
            System.out.println(input);
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Please input again.");
            }
        }

    }

    public String inputBinary() {
        String binary;
        while (true) {
            System.out.print("Enter Binary: ");
            binary = sc.nextLine().trim();
            if (binary.matches("[0-1]+")) {
                return binary;
            }
            System.err.println("Invalid, try again");
        }
    }
    
    public BigInteger inputDecimal() {
        String decimal;
        while (true) {
            System.out.print("Enter Decimal: ");
            decimal = sc.nextLine().trim();
            if (decimal.matches("[0-9]+")) {
                return new BigInteger(decimal);
        }
            System.err.println("Invalid, try again");
        }
    }
    
     public String inputHexa() {
        String s;
        while (true) {
            System.out.print("Enter Hexadecimal: ");
            s = sc.nextLine().trim();
            if (s.matches("[0-9A-Fa-f]+")) {
                return s.toUpperCase();
            }
            System.err.println("Invalid, try again");
        }
    }
    
    
}
