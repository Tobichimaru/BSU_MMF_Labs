/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task5;

/**
 *
 * @author Saia
 */
public class Surgeon implements Doctor {
    int salary;
    int age;
    
    Surgeon() {
        salary = 0;
        age = 0;
    }
    
     Surgeon(int a, int s) {
        salary = s;
        age = a;
    }
    
    @Override
    public int getSalary() {
        return salary;
    }
    
    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    @Override
    public int getAge() {
        return age;
    }
    
    @Override
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public void whoIsIt() {
        System.out.println("I am a surgeon! Age:" + Integer.toString(age) +
                "; Salary:" + Integer.toString(salary));
    }
    
}
