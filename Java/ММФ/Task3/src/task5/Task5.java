package task5;

import java.util.Scanner;

/**
 * @Task Определить класс Дробь в виде пары (m,n). Класс должен содержать
несколько конструкторов. Реализовать методы для сложения, вычитания,
умножения и деления дробей. Объявить массив из k дробей, ввести/вы-
вести значения для массива дробей. Создать массив объектов и передать
его в метод, который изменяет каждый элемент массива с четным
индексом путем добавления следующего за ним элемента массива.
 * @author Saia
 */

public class Task5 {
    
    private static Fraction[] changeFractions(Fraction[] a, int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                a[i].add(a[i-1]);
            }
        }
        return a;
    }
    
    public static void main(String[] args) {
        System.out.print("Print the number of fractions: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x, y;
        Fraction a[] = new Fraction[n];
        System.out.println("Print the fractions \"m n\": ");
        for (int i = 0; i < n; i++) {
            x = in.nextInt();
            y = in.nextInt();
            a[i] = new Fraction(x, y);
        }
        
        a = changeFractions(a, n);
        System.out.println("The changed array of fractions: ");
        for (int i = 0; i < n; i++) {
            a[i].print();
            System.out.print(" ");
        }
        
        System.out.println("\nPrint two fractions \"m n\": ");
        x = in.nextInt();
        y = in.nextInt();
        Fraction f1 = new Fraction(x,y);
        
        x = in.nextInt();
        y = in.nextInt();
        Fraction f2 = new Fraction(x,y);
        Fraction f3 = new Fraction();
        f3.set(f1);

        f1.multiply(f2);
        System.out.println();
        
        f1.set(f3);
        f1.substract(f2);
        System.out.println();
        
        f1.set(f3);
        f1.add(f2);
        System.out.println();
        
        f1.set(f3);
        f1.divide(f2);
         System.out.println();
    }
    
}
