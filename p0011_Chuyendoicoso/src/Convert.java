
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duongtuandu
 */
public class Convert {
    
    Validation vli = new Validation();
    
    public BigInteger anotherToDecimal(String convert, int base){
        if(convert.equals("0")){
            return BigInteger.ZERO;
        }
        BigInteger power = BigInteger.ONE;
        BigInteger decimal = BigInteger.ZERO;
        for(int i = convert.length() - 1; i>=0; i--){
            int digit = Character.getNumericValue(convert.charAt(i));
            decimal = decimal.add(BigInteger.valueOf(digit).multiply(power));
            power = power.multiply(BigInteger.valueOf(base));
        }
        return decimal;
    }
    
    public String decimalToAnother(BigInteger decimal, int base){
        if(decimal.equals(BigInteger.ZERO)){
            return "0";
        }
        String result = "";
        while (decimal.compareTo(BigInteger.ZERO) > 0){
            BigInteger remainder = decimal.mod(BigInteger.valueOf(base));
            result += Character.forDigit(Integer.parseInt(remainder.toString()), base);
            decimal = decimal.divide(BigInteger.valueOf(base));
        }
        return (new StringBuilder(result).reverse().toString().toUpperCase());
    }
    
    public BigInteger binToDec(String bin) {
        return anotherToDecimal(bin, 2);
    }

    //2->16
    public String binToHex(String bin) {
        BigInteger dec = anotherToDecimal(bin, 2);
        return decimalToAnother(dec, 16);
    }

    //10->2
    public String decToBin(BigInteger dec) {
        return decimalToAnother(dec, 2);
    }

    //10->16
    public String decToHex(BigInteger dec) {
        return decimalToAnother(dec, 16);
    }

    //16->2
    public String hexToBin(String hex) {
        BigInteger dec = anotherToDecimal(hex, 16);
        return decimalToAnother(dec, 2);
    }

    //16->10
    public BigInteger hexToDec(String hex) {
        return anotherToDecimal(hex, 16);
    }
    
    public void displayBinaryTo() {
        System.out.println("OUTPUT BASE: \n1.Binary\n2.Decimal\n3.Hexadecimal");
        int choice = vli.getChoice("Your choice: ", 1, 3);
        String bin = vli.inputBinary();
        switch (choice) {
            case 1:
                System.out.println(bin);
                break;
            case 2:
                System.out.println(binToDec(bin));
                break;
            case 3:
                System.out.println(binToHex(bin));
                break;

        }

    }

    public void displayDecimalTo() {
        System.out.println("OUTPUT BASE: \n1.Binary\n2.Decimal\n3.Hexadecimal");
        int choice = vli.getChoice("Your choice: ", 1, 3);
        BigInteger dec = vli.inputDecimal();
        switch (choice) {
            case 1:
                System.out.println(decToBin(dec));
                break;
            case 2:
                System.out.println(dec);
                break;
            case 3:
                System.out.println(decToHex(dec));
                break;

        }

    }

    public void displayHexaTo() {
        System.out.println("OUTPUT BASE: \n1.Binary\n2.Decimal\n3.Hexadecimal");
        int choice = vli.getChoice("Your choice: ", 1, 3);
        String hex = vli.inputHexa();
        switch (choice) {
            case 1:
                System.out.println(hexToBin(hex));
                break;
            case 2:
                System.out.println(hexToDec(hex));
                break;
            case 3:
                System.out.println(hex);
                break;

        }

    }

    public void displayMenu() {
        int choice;
        while (true) {
            System.out.println("Change base number system");
            System.out.println("1. Convert Binary");
            System.out.println("2. Convert Decimal");
            System.out.println("3. Convert Hexadecimal");
            choice = vli.getChoice("Enter your choice: ", 1, 3);
            switch (choice) {
                case 1:
                    displayBinaryTo();
                    break;
                case 2:
                    displayDecimalTo();
                    break;
                case 3:
                    displayHexaTo();
                    break;
            }
        }
    }
    
}
