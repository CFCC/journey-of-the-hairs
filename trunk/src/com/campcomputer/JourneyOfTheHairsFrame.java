package com.campcomputer;

import javax.swing.*;
import java.awt.*;

public class JourneyOfTheHairsFrame extends JFrame {
    int playerX;
    int playerY;

    int[][] map;

    public JourneyOfTheHairsFrame() throws HeadlessException {
        super("Journey Of The Hairs");


        new BoxLayout(this, BoxLayout.X_AXIS);     

        add(new GamePanel());

        setSize(1024, 768);
    }
}
