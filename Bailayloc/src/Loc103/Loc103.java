/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loc103;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Duongtuandu
 */
public class Loc103 {

    public static void main(String[] args) {
        Nhap();
    }

    private static boolean Check(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(dateString);
            return true;
        } catch (ParseException e) {
            System.err.println("Invalid date format! Please re-enter in the format [dd/MM/yyyy]");
            return false;
        }
    }

    public static void compare(Date date1, Date date2) {

        if (date1.equals(date2)) {
            System.out.println("2 days are the same");
        } else if (date1.before(date2)) {
            System.out.println("Date1 is before Date2");
        } else {
            System.out.println("Date1 is after Date2");
        }

    }

    public static void Nhap() {
        Scanner scanner = new Scanner(System.in);
        String date1String;
        String date2String;

        do {
            System.out.print("Please enter the first date: ");
            date1String = scanner.nextLine();
        } while (!Check(date1String));

        do {
            System.out.print("Please enter the second date: ");
            date2String = scanner.nextLine();
        } while (!Check(date2String));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = format.parse(date1String);
            Date date2 = format.parse(date2String);
            compare(date1, date2);
        } catch (ParseException e) {
            System.err.println("An error occurred while parsing the dates.");
        }

    }

}
