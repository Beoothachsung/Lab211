/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailayloc102;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Duongtuandu
 */
public class Loc102 {

    public static void main(String[] args) {
        Nhap();
    }

    public static void Nhap() {
        Scanner scanner = new Scanner(System.in);
        String dateString;

        do {
            System.out.print("Please enter date with format [dd/mm/yyyy]:");
            dateString = scanner.nextLine();
        } while (!Check(dateString));

        Date date = parseDate(dateString);

        String dayOfWeek = getDayOfWeek(date);

        System.out.println("Your day is " + dayOfWeek);
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

    private static Date parseDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    private static String getDayOfWeek(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        return format.format(date);
    }

}
