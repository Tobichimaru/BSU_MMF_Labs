/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;
import java.util.Scanner;

/**
 * @author Saia
 */
public class Task2 {

    /**
     * @param args the command line arguments
     */
    private static int GCD(int a, int b) {
        if (a == b || b == 0)
            return a;
        else if (a == 0) 
            return b;
        else if (a > b) 
            return GCD(a % b, b);
        else 
            return GCD(a, b % a);
    }
    
    private static int LCM(int a, int b) {
        return (a*b)/GCD(a,b);
    }
        
    public static void main(String[] args) {
        System.out.print("Print the number of elements: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1) {
            System.out.println("Incorrect number of elements!");
            return;
        }
        System.out.print("Print elements: ");
        int[] a = new int[n];
        int gcd = a[0], lcm = 1;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            gcd = GCD(gcd, a[i]);
            lcm = LCM(lcm, a[i]);
        }
        System.out.printf("Great common divisor: %d \n", gcd);
        System.out.printf("Least common multiplicator: %d \n", lcm);
    }
        
}
