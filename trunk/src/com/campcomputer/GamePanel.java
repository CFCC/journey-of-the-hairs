package com.campcomputer;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.orange);
        g2.drawRect(10,20,30,40);
    }
}
