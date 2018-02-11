/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;
import java.util.Scanner;

/**
 * @author Kate Zabelova
 */
public class Task3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Print the number of strings: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s[] = new String[n];
        String answer = "Isn't exist!", str;
        int f = 1;
        System.out.println("Print the strings: ");
        for (int i = 0; i < n; i++) {
            s[i] = in.next();
            if (f == 1) {
                f = 0;
                for (int j = 0; j < s[i].length(); j++) {
                    for (int k = j + 1; k < s[i].length(); k++) {
                        if (s[i].charAt(j) == s[i].charAt(k)) {
                            f = 1;
                            break;
                        }
                    }
                    if (f == 1) break;
                }
                if (f == 0) {
                    answer = s[i];
                }
            }
        }
        System.out.print("The answer is: ");
        System.out.println(answer);
    }
}
