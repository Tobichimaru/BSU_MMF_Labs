
package task7;

import java.awt.Color;
import java.util.Random;
import static task7.MyFrame.window_size;

/**
 * @author Saia
 */
public class Triangle {
    private final double center_x, center_y, radius;
    private final Color color;
    static double phi = 0.55;
    
    double x[];
    double y[];
    
    Triangle() {
        Random rand = new Random();
        
        center_x = rand.nextInt(window_size - 100) + 50;
        center_y = rand.nextInt(window_size - 100) + 50;
        radius = rand.nextInt(50) + 50;
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        color = new Color(r, g, b);
        
        x = new double[3];
        y = new double[3];
            
        x[0] = center_x + radius;
        y[0] = center_y;
        
        x[1] = (center_x + radius * Math.cos(Math.PI*2./3));
        y[1] = (center_y + radius * Math.sin(Math.PI*2./3));
        
        x[2] = x[1];
        y[2] = (center_y + radius * Math.sin(Math.PI*4./3));
    }
    
    private void rotatePoint(int i) {
        double tmp_x, tmp_y;
        tmp_x = center_x + (x[i]-center_x) * Math.cos(phi) - (y[i] - center_y) * Math.sin(phi);
        tmp_y = center_y + (x[i]-center_x) * Math.cos(phi) + (y[i] - center_y) * Math.sin(phi);
        x[i] = tmp_x; 
        y[i] = tmp_y;
    }
    
    void rotate() {
        for (int i = 0; i < 3; i++) {
            rotatePoint(i);
        }
    }
    
    public double[] getX() {
        return x;
    }
    
    public double[] getY() {
        return y;
    }
    
    public Color getColor() {
        return color;
    }
}
