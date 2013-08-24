package com.campcomputer.journeyofthehairs.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {
    public BufferedImage backgroundImage;

    public Panel () {

    }

    public void setBackground(BufferedImage bg) {
        backgroundImage = bg;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(backgroundImage, null, 0, 0);
    }
}
