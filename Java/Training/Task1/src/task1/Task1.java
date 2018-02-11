/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.awt.Graphics;

/**
 *
 * @author Saia
 */
public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Print your name:");
        String name = in.next();
        System.out.println("Hello, " + name);
        
        System.out.print("Command line args: ");
        Integer sum = 0, product = 1;
        for (int i = 0; i < args.length; ++i) {
            System.out.print(args[i] + ' ');
            sum += Integer.parseInt(args[i]);
            product *= Integer.parseInt(args[i]);
        }
        System.out.println();
        System.out.println("Sum of args: " + String.valueOf(sum));
        System.out.println("Product of args: " + String.valueOf(product));
        
        Calendar calendar = new GregorianCalendar(2013,0,31);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
	System.out.println(sdf.format(calendar.getTime()));
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
