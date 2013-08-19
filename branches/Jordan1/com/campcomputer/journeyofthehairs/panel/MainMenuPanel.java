package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenuPanel extends Panel {
    BufferedImage bgImage = Images.ReadImage("images/title page.png");
    public Rectangle startButton = new Rectangle(154, 527, 313, 74);
    public Rectangle aboutButton = new Rectangle(540, 637, 313, 74);
    public Rectangle exitButton = new Rectangle(542, 654, 313, 74);
    public Rectangle instructionsButton = new Rectangle(156, 640, 313, 74);

    public MainMenuPanel() {

    }

    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(bgImage, null, 0, 0);
    }
}
