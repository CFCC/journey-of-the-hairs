package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.map.Map;
import com.campcomputer.journeyofthehairs.map.World1Stage1;
import com.campcomputer.journeyofthehairs.panel.AboutPanel;
import com.campcomputer.journeyofthehairs.panel.GamePanel;
import com.campcomputer.journeyofthehairs.panel.InstructionsPanel;
import com.campcomputer.journeyofthehairs.panel.MainMenuPanel;

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
    private final GamePanel gamePanel;

    /**
     * The instance of the main menu used in the code for the beginning of the game
     */
    private final MainMenuPanel mainMenuPanel;

    /**
     * The instance of the instructions menu used in the code for the beginning of the game
     */
    private final InstructionsPanel instructionsPanel;

    /**
     * The instance of the about screen used in the code for the beginning of the game
     */
    private final AboutPanel aboutPanel;

    /**
     * The instance of the frame itself for occasional use in the panel/frame code
     */
    private final JourneyOfTheHairsFrame frame;

    /**
     * The key adapter that belongs to the game panel. It includes basic movement (WAD) and shooting (S).
     * Also ends movement upon release of W and D
     *
     * TODO: Add hotkey E for inventory, switch tile painting to T
     */
    private KeyAdapter gamePanelKeyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    engine.startMoveBackward();
                    break;
                case KeyEvent.VK_D:
                    engine.startMoveForward();
                    break;
                case KeyEvent.VK_W:
                    engine.jump();
                    break;
                case KeyEvent.VK_E:
                    gamePanel.toggleShowTiles();
                    break;
                case KeyEvent.VK_S:
                    engine.getPlayer().getWeapon().shoot();
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    engine.endMoveBackward();
                    break;
                case KeyEvent.VK_D:
                    engine.endMoveForward();
                    break;
            }

        }
    };

    /**
     * Mouse adapter for the main menu. Includes 4 rectangles (1 for each of the 4 buttons on the menu).
     * Switches content panes according to which button is pressed. Ends the program by click of the exit button
     */
    private MouseAdapter mainMenuMouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            Rectangle startButton = mainMenuPanel.startButton;
            Rectangle aboutButton = mainMenuPanel.aboutButton;
            Rectangle instructionsButton = mainMenuPanel.instructionsButton;
            Rectangle exitButton = mainMenuPanel.exitButton;

            int x = mouseEvent.getX();
            int y = mouseEvent.getY();

            if (startButton.contains(x, y)) {
                Map map = new World1Stage1(engine);
                engine.setMap(map);
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

    /**
     * Mouse adapter for the about page. Only rectangle is the back button
     */
    private MouseAdapter aboutMenuMouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Rectangle backButton = aboutPanel.backButton;
            int x = e.getX();
            int y = e.getY();

            if (backButton.contains(x, y))
                switchContentPane(mainMenuPanel);
        }
    };

    /**
     * Mouse adapter for the instructions menu. Includes 3 rectangles. 1 (back) returns to the main menu; 1 (backward)
     * regresses the current page of instructions; 1 (forward) advances the page
     */
    private MouseAdapter instructionMenuMouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Rectangle backButton = instructionsPanel.backButton;
            Rectangle nextPageButton = instructionsPanel.nextPageButton;
            Rectangle backPageButton = instructionsPanel.backPageButton;
            int x = e.getX();
            int y = e.getY();

            if (backButton.contains(x, y))
                switchContentPane(mainMenuPanel);
            else if (nextPageButton.contains(x, y))
                instructionsPanel.goTo("next");
            else if (backPageButton.contains(x, y))
                instructionsPanel.goTo("back");
        }
    };

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

        World1Stage1 map = new World1Stage1(engine);
        engine.setMap(map);

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
    public void switchContentPane(JPanel panel) {
        if (getMouseListeners().length > 0)
            removeMouseListener(getMouseListeners()[0]);
        if (getKeyListeners().length > 0)
            removeKeyListener(getKeyListeners()[0]);
        frame.setContentPane(panel);

        if (panel instanceof MainMenuPanel)
            addMouseListener(mainMenuMouseAdapter);
        else if (panel instanceof GamePanel)
            addKeyListener(gamePanelKeyAdapter);
        else if (panel instanceof AboutPanel)
            addMouseListener(aboutMenuMouseAdapter);
        else if (panel instanceof InstructionsPanel)
            addMouseListener(instructionMenuMouseAdapter);

        revalidate();
    }
}