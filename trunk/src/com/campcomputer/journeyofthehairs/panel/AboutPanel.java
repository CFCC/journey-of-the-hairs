package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.JourneyOfTheHairsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AboutPanel extends Panel {
    private Rectangle backButton = new Rectangle(364, 592, 321, 82);

    public AboutPanel() {
        super();
        setBackground(Images.ReadImage("menus/about"));
    }

    @Override
    public void addListener() {
        listener =

        /**
         * Mouse adapter for the about page. Only rectangle is the back button
         */
        new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (backButton.contains(x, y))
                    frame.switchContentPane(frame.mainMenuPanel);
            }
        };
    }
}
