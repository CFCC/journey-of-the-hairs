package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.JourneyOfTheHairs;
import com.campcomputer.journeyofthehairs.JourneyOfTheHairsFrame;
import com.campcomputer.journeyofthehairs.map.Map;
import com.campcomputer.journeyofthehairs.map.World1Stage1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class MainMenuPanel extends Panel {
    BufferedImage bgImage = Images.ReadImage("menus/title");
    public Rectangle startButton = new Rectangle(154, 527, 313, 74);
    public Rectangle aboutButton = new Rectangle(540, 527, 324, 81);
    public Rectangle exitButton = new Rectangle(542, 654, 313, 74);
    public Rectangle instructionsButton = new Rectangle(156, 640, 313, 74);

    public MainMenuPanel() {
        super();
        setBackground(bgImage);
    }

    @Override
    public void addListener() {
        listener =
        /**
         * Mouse adapter for the main menu. Includes 4 rectangles (1 for each of the 4 buttons on the menu).
         * Switches content panes according to which button is pressed. Ends the program by click of the exit button
         */
        new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int x = mouseEvent.getX();
                int y = mouseEvent.getY();

                if (startButton.contains(x, y)) {
//                    engine.setMap(new World1Stage1(engine));
                    frame.switchContentPane(frame.gamePanel);
                    revalidate();
                } else if (aboutButton.contains(x, y)) {
                    frame.switchContentPane(frame.aboutPanel);
                    revalidate();
                } else if (instructionsButton.contains(x, y)) {
                    frame.switchContentPane(frame.instructionsPanel);
                    revalidate();
                } else if (exitButton.contains(x, y)) {
                    System.exit(0);
                }
            }
        };
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
