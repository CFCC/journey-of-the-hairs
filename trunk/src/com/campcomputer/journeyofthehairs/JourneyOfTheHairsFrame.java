package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.map.Map;
import com.campcomputer.journeyofthehairs.map.Water;
import com.campcomputer.journeyofthehairs.map.World1Stage1;
import com.campcomputer.journeyofthehairs.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class Name: JourneyOfTheHairsFrame (or Frame for short)
 * Purpose: The frame (window in layman's terms) used to contain the game
 */

public class JourneyOfTheHairsFrame extends JFrame {
    /**
     * The time interval, in milliseconds, at which the timer is invoked and its method is called.
     * The lower the denominator of this variable, the better the motion quality of the game, but the slower it runs
     */
    public static int timerTick = 1000 / 30;

    /**
     * The instance of the game engine used throughout the game's code
     */
    private GameEngine engine;

    /**
     * The instance of the game panel used throughout the game's code
     */
    public final GamePanel gamePanel;

    /**
     * The instance of the main menu used in the code for the beginning of the game
     */
    public final MainMenuPanel mainMenuPanel;

    /**
     * The instance of the instructions menu used in the code for the beginning of the game
     */
    public final InstructionsPanel instructionsPanel;

    /**
     * The instance of the about screen used in the code for the beginning of the game
     */
    public final AboutPanel aboutPanel;

    /**
     * The instance of the frame itself for occasional use in the panel/frame code
     */
    private final JourneyOfTheHairsFrame frame;

    /**
     * Class constructor. Makes a new frame for the game and sets it up. Also defines final fields and creates a timer
     *
     * @throws HeadlessException
     */
    public JourneyOfTheHairsFrame() throws HeadlessException {
        super("Journey Of The Hairs");

        frame = this;
        engine = new GameEngine();

        new BoxLayout(this, BoxLayout.X_AXIS);

        aboutPanel = new AboutPanel();
        instructionsPanel = new InstructionsPanel(this);
        mainMenuPanel = new MainMenuPanel();
        gamePanel = new GamePanel(engine);
        engine.gamePanel = gamePanel;

        switchContentPane(mainMenuPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1024, 768);

        Timer t = new Timer(timerTick, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getContentPane() instanceof GamePanel)
                    engine.tick();
                repaint();
            }
        });
        t.start();
    }

    /**
     * Method for switching out content panes. The method is different from setContentPane() in that
     * it changes mouse/key adapters appropriately and revalidates so the new panel shows up
     *
     * @param panel the panel to become the content pane
     */
    public void switchContentPane(com.campcomputer.journeyofthehairs.panel.Panel panel) {
        if (getKeyListeners().length > 0)
            removeKeyListener(getKeyListeners()[0]);
        if (getMouseListeners().length > 0)
            removeMouseListener(getMouseListeners()[0]);

        setContentPane(panel);

        if (panel.listener instanceof KeyAdapter)
            addKeyListener((KeyListener) panel.listener);
        else if (panel.listener instanceof MouseAdapter)
            addMouseListener((MouseListener) panel.listener);

        revalidate();
    }
}