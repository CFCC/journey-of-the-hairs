package com.campcomputer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class GamePanel extends JPanel {

    private BufferedImage cheese;

    public GamePanel() {
        File file = new File("Cheese.jpg");



        cheese = Images.ReadImage(file);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.orange);
        g2.drawRect(10,20,30,40);
        g2.drawImage(cheese, null, 100, 100);
    }
}
