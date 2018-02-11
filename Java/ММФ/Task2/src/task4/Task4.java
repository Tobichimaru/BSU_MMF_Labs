package task4;
import java.util.Scanner;
/**
 * @author Saia
 * @task Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки
 */
public class Task4 {
    
    private static int[][] rotateArray(int [][] a, int n) {
        int b[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[n-j-1][i] = a[i][j];
            }
        }
        return b;
    }
    
    private static void printArray(int [][] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Print the dimension of square matrix: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1) {
            System.out.print("Incorrect dimension!");
            return;
        }
        int a[][] = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) (Math.round(2*n*Math.random()) - n);
            }
        }
        
        System.out.println("The original matrix is: ");
        printArray(a, n);
 
        a = rotateArray(a, n);
        System.out.println();
        System.out.println("The matrix with 90 degree rotation: ");
        printArray(a, n);
        
        a = rotateArray(a, n);
        System.out.println();
        System.out.println("The matrix with 180 degree rotation: ");
        printArray(a, n);
        
        a = rotateArray(a, n);
        System.out.println();
        System.out.println("The matrix with 270 degree rotation: ");
        printArray(a, n);
        
        a = rotateArray(a, n);
        System.out.println();
        System.out.println("The matrix with 360 degree rotation: ");
        printArray(a, n);
        
    }
}
