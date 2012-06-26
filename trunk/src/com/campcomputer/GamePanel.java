package com.campcomputer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class GamePanel extends JPanel {

    int xScreenPlace = 0;

    private BufferedImage cheese;
    int[][] map;

    public GamePanel() {
        File file = new File("Cheese.jpg");


        cheese = Images.ReadImage(file);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int x = 0; x < 1024; x = x + 64) {
            for (int y = 0; y < 768; y = y + 64) {
                g2.drawImage(cheese, null, x, y);
            }
        }

//        g2.setColor(Color.orange);
//        g2.drawRect(10, 20, 30, 40);
//        g2.drawImage(cheese, null, 100, 100);


    }
}

