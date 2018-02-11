
package task6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Saia
 */
public class MyFrame  extends JFrame {
    JButton buttons[];
    
    MyFrame(int n) {
        setTitle("Interesting buttons");
        setSize(620, 675);
        setLayout(new FlowLayout());
        
        buttons = new JButton[n];
        for (int i = 0; i < n; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("number: " + Integer.toString(i));
            final int k = (i+1 < n) ? i+1 : 0; 
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttons[k].setText(((JButton) e.getSource()).getText());
                }
            });
            add(buttons[i]);
        }
        
        setVisible(true);
    }
    
}
