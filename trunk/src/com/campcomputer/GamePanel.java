package com.campcomputer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class GamePanel extends JPanel {

    float xScreenPlace = 0;

    private BufferedImage tomato;
    private BufferedImage ground;
    private BufferedImage stem;
    private BufferedImage pit;
    private BufferedImage air;
    Tile[][] map;

    public GamePanel(Tile[][] map) {

        this.map = map;
        tomato = Images.ReadImage(new File("images/tomato.jpg"));
        ground = Images.ReadImage(new File("images/ground.jpg"));
        stem = Images.ReadImage(new File("images/Solidago_radula_stem.jpg"));
        pit = Images.ReadImage(new File("images/Sky_Blue.png"));
        air = Images.ReadImage(new File("images/Sky_Blue.png"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 12; y++) {
                BufferedImage image = null;
                switch (map[x][y]) {
                    case TOMATO:
                        image = tomato;
                        break;
                    case STEM:
                        image = stem;
                        break;
                    case PIT:
                        image = pit;
                        break;
                    case AIR:
                        image = air;
                        break;
                    case GROUND:
                        image = ground;
                        break;
                }
                g2.drawImage(image, null, x * 64, y * 64);

            }
        }

//        g2.setColor(Color.orange);
//        g2.drawRect(10, 20, 30, 40);
//        g2.drawImage(cheese, null, 100, 100);


    }
}

