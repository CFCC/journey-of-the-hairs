package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;

import java.awt.*;

public class AboutPanel extends Panel {
    public Rectangle backButton = new Rectangle(364, 592, 321, 82);

    public AboutPanel() {
        setBackground(Images.ReadImage("menus/about"));
    }
}
