package com.campcomputer;

import javax.swing.*;
import java.awt.*;

public class JourneyOfTheHairsFrame extends JFrame {


    GameEngine engine;


    public JourneyOfTheHairsFrame() throws HeadlessException {
        super("Journey Of The Hairs");

        engine = new GameEngine();

        new BoxLayout(this, BoxLayout.X_AXIS);     

        add(new GamePanel(engine.getMap()));

        setSize(1024, 768);
    }
}
