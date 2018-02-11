/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task5;

import static java.lang.Math.abs;

/**
 * @author Saia
 */

public class Fraction {
    /**
     * Implements class of Fractions (m/n).
     */
    
    private int m;
    private int n;
    
    public Fraction() {
        m = 0;
        n = 1;
    }
    
    public Fraction(int m, int n) {
        this.m = m;
        this.n = n;
    }
    
    public void add(Fraction other) {
        print();
        System.out.print('+');
        other.print();
        
        m = m * other.n + other.m * n;
        n = n * other.n;
        simplify();
        
        System.out.print('=');
        print();      
    }
    
    public void substract(Fraction other) {
        print();
        System.out.print('-');
        other.print();
        
        m = m * other.n - other.m * n;
        n = n * other.n;
        simplify();
        
        System.out.print('=');
        print();
    }
    
    public void multiply(Fraction other) {
        print();
        System.out.print('*');
        other.print();
        
        m = m * other.m;
        n = n * other.n;
        simplify();
        
        System.out.print('=');
        print();
    }
    
    public void divide(Fraction other) {
        print();
        System.out.print('/');
        other.print();
        
        m = m * other.n;
        n = n * other.m;
        simplify();
        
        System.out.print('=');
        print();
    }
    
    public void print() {
        System.out.print(m);
        System.out.print("/");
        System.out.print(n);
    }
    
    public void set(int m, int n) {
        this.m = m;
        this.n = n;
    }
    
    public void set(Fraction other) {
        this.m = other.m;
        this.n = other.n;
    }
    
    private void simplify() {
        int i = 2;
        while (i <= abs(m) ) {
            while (m % i == 0 && n % i == 0) {
                m = m/i;
                n = n/i;
            }
            i++;
        }
    }
}
