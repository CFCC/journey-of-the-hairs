package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenuPanel extends Panel {
    BufferedImage bgImage = Images.ReadImage("menus/title");
    public Rectangle startButton = new Rectangle(154, 527, 313, 74);
    public Rectangle aboutButton = new Rectangle(540, 527, 324, 81);
    public Rectangle exitButton = new Rectangle(542, 654, 313, 74);
    public Rectangle instructionsButton = new Rectangle(156, 640, 313, 74);

    public MainMenuPanel() {
        setBackground(bgImage);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
