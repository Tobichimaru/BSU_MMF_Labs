/*
 * 7. Создать форму с набором кнопок так, чтобы надпись на первой кнопке
при ее нажатии передавалась на следующую, и т.д.
 */
package task6;

import java.util.Scanner;

/**
 *
 * @author Saia
 */
public class Task6 {

    public static void main(String[] args) {
       System.out.println("Print the number of buttons: ");
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       if (n > 0) {
           new MyFrame(n);
       } else {
           System.out.println("Incorrect number of buttons!");
       }
    }
    
}
