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
public class NeuroSurgeon extends Surgeon {
    NeuroSurgeon(int a, int s) {
        super(a, s);
    }
    
    @Override
    public void whoIsIt() {
        System.out.println("I am a neuro surgeon! Age:" + Integer.toString(age) +
                "; Salary:" + Integer.toString(salary));
    }
}
