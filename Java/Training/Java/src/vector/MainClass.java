/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Saia
 */
public class MainClass {
    private static final Logger logger = Logger.getLogger(MainClass.class.getName());
    
    public static void main(String[] args) {   
        
        try {
            LogManager.getLogManager().readConfiguration(
                MainClass.class.getResourceAsStream("./logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        
        double[] v = {1, 2, 3};
        
        Vector v1 = null;
        try {
            v1 = new Vector(v);
        } catch (ArrayException exp) {
            System.out.println(exp.getMessage());
            return;
        } 
        String message = new String();
        
        System.out.print("v1 = ");
        message = v1.output();
        System.out.println(message);
        logger.log(Level.FINE, "v1 = {0}", message);
    
        System.out.print("v2 | v2[i]->[0;10] = ");
        Vector v2 = Vector.random();
        message = v2.output();
        System.out.println(message);
        logger.log(Level.FINE, "v2 = {0}", message);
            
        System.out.print("v2[1]<->v2[2] = ");
        Vector v3 = v2;
        v3.swap(1, 2);
        message = v3.output();
        System.out.println(message);
        logger.log(Level.FINE, "v2[1]<->v2[2] = ", message);
        
        System.out.print("v1 + v2 = ");
        message = v1.plus(v2).output();
        System.out.println(message);
        logger.log(Level.FINE, "v1 + v2 = {0}", message);
        
        System.out.print("v1 - v2 = ");
        message = v1.minus(v3).output();
        System.out.println(message);
        logger.log(Level.FINE, "v1 - v2 = {0}", message);
        
        System.out.print("v1 * 4 = ");
        message = v1.times(4).output();
        System.out.println(message);
        logger.log(Level.FINE, "v1 * 4 = {0}", message);
        
        System.out.print("v1 * v2 = ");
        int res0 = v1.skaltimes(v2);
        System.out.println(res0);
        logger.log(Level.FINE, "v1 * v2 = {0}", Integer.toString(res0));
       
        System.out.print("v1 x v2 = ");
        message = v1.vecttimes(v2).output();
        System.out.println(message);
        logger.log(Level.FINE, "v1 x v2 = {0}", message);
        
        System.out.print("|v1| = ");
        double res1 = v1.module();
        System.out.println(res1);
        logger.log(Level.FINE, "v1 - v2 = {0}", Double.toString(res1));
    }
}
