package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.map.Map;
import com.campcomputer.journeyofthehairs.map.Map1;
import com.campcomputer.journeyofthehairs.panel.AboutPanel;
import com.campcomputer.journeyofthehairs.panel.GamePanel;
import com.campcomputer.journeyofthehairs.panel.InstructionPanel;
import com.campcomputer.journeyofthehairs.panel.MainMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JourneyOfTheHairsFrame extends JFrame {
    static Timer t;
    public static int timerTick = 1000 / 30;
    private GameEngine engine;
    private final GamePanel gamePanel;
    private final MainMenuPanel mainMenuPanel;
    private final InstructionPanel instructionPanel;
    private final AboutPanel aboutPanel;
    private final JourneyOfTheHairsFrame frame;

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
                case KeyEvent.VK_S:
                    engine.getPlayer().getWeapon().toggleShoot();
                    break;
            }

        }
    };
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
                Map map = new Map1(engine);
                engine.setMap(map);
                frame.switchContentPane(frame.gamePanel);
                revalidate();
            } else if (aboutButton.contains(x, y)) {
                frame.switchContentPane(frame.aboutPanel);
                revalidate();
            } else if (instructionsButton.contains(x, y)) {
                frame.switchContentPane(frame.instructionPanel);
                revalidate();
            } else if (exitButton.contains(x, y)) {
                System.exit(0);
            }
        }
    };
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
    private MouseAdapter instructionMenuMouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Rectangle backButton = instructionPanel.backButton;
            Rectangle nextPageButton = instructionPanel.nextPageButton;
            Rectangle backPageButton = instructionPanel.backPageButton;
            int x = e.getX();
            int y = e.getY();

            if (backButton.contains(x, y))
                switchContentPane(mainMenuPanel);
            else if (nextPageButton.contains(x, y))
                instructionPanel.goTo("next");
            else if (backPageButton.contains(x, y))
                instructionPanel.goTo("back");
        }
    };

    public JourneyOfTheHairsFrame() throws HeadlessException {
        super("Journey Of The Hairs");

        frame = this;
        engine = new GameEngine();

        new BoxLayout(this, BoxLayout.X_AXIS);

        aboutPanel = new AboutPanel();
        instructionPanel = new InstructionPanel(this);
        mainMenuPanel = new MainMenuPanel();
        gamePanel = new GamePanel(engine);
        engine.gamePanel = gamePanel;

        Map1 map = new Map1(engine);
        engine.setMap(map);

        switchContentPane(mainMenuPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1024, 768);

        t = new Timer(timerTick, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getContentPane() instanceof GamePanel)
                    engine.tick();
                repaint();
            }
        });
        t.start();
    }

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
        else if (panel instanceof InstructionPanel)
            addMouseListener(instructionMenuMouseAdapter);

        revalidate();
    }
}