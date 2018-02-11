/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.awt.Graphics;
import java.util.Calendar;

/**
 *
 * @author Saia
 */
public class Applet extends javax.swing.JApplet {
    private Calendar calendar;

    public void Init() {
        calendar = Calendar.getInstance();
        setSize(250,80);
    }
    public void paint(Graphics g) {
        g.drawString("Applet has started to work!", 20, 20);
        g.drawString(calendar.getTime().toString(), 20, 35);
    }
}

