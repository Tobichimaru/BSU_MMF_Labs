
package task7;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Saia
 */
public class MyFrame extends JFrame {
    static int window_size = 600;
    
    JPanel drawPanel;
    Thread threads[];
    Triangle triangles[];
    int n;
    
    MyFrame(int n) {
        setTitle("Triangles");
        setSize(window_size, window_size);
        setLayout(new FlowLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.n = n;
        
        triangles = new Triangle[n];
        for (int i = 0; i < n; i++) {
           triangles[i] = new Triangle();
        }
        
        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                for (Triangle triangle : triangles) {
                    Path2D path = new Path2D.Double();
                    g2.setColor(triangle.getColor());
                    path.moveTo(triangle.getX()[0], triangle.getY()[0]);
                    path.lineTo(triangle.getX()[1], triangle.getY()[1]);
                    path.lineTo(triangle.getX()[2], triangle.getY()[2]);
                    path.closePath();
                    g2.draw(path);
                }
               
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(window_size, window_size);
            }
        };
        add(drawPanel);
        
        
        threads = new Thread[n];
        
        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(new Rotate(i));
        }
        
        setVisible(true);
        
        Start();
    }
    
    final void Start() {
        for (int i = 0; i < n; i++) {
            threads[i].start();
        }
    }
    
    public class Rotate implements Runnable{
        int index;
        int time;

        Rotate(int i) {
            index = i;
            Random rand = new Random();
            time = rand.nextInt(1000) + 50;
        }

        @Override
        public void run() {
            ActionListener animate = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    triangles[index].rotate();
                    repaint();
                }
            };
            Timer timer = new Timer(time,animate);
            timer.start();
        }
    }
}
