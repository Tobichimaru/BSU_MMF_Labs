/*
 * Изобразить в приложении правильные треугольники, вращающиеся в плоскости 
 * экрана вокруг своего центра. Каждому объекту соответ-ствует поток с 
 * заданным приоритетом.
 */
package task7;

import java.util.Scanner;

/**
 *
 * @author Saia
 */
public class Task7 {

    public static void main(String[] args) {
        System.out.println("Print the number of triangles: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0) {
           new MyFrame(n);
        } else {
           System.out.println("Incorrect number of triangles!");
        }
    }
    
}
