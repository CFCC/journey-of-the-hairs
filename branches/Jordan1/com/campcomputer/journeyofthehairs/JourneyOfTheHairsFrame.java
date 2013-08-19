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

    public JourneyOfTheHairsFrame() throws HeadlessException {
        super("Journey Of The Hairs");

        engine = new GameEngine();

        new BoxLayout(this, BoxLayout.X_AXIS);

        aboutPanel = new AboutPanel();
        instructionPanel = new InstructionPanel();
        mainMenuPanel = new MainMenuPanel();
        gamePanel = new GamePanel(engine);
        engine.gamePanel = gamePanel;

        Map1 map = new Map1(engine);
        engine.setMap(map);

        setContentPane(mainMenuPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1024, 768);

        addMenuMouseListener();

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

    private void addGamePanelKeyListener() {
        addKeyListener(new KeyAdapter() {
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
                    case KeyEvent.VK_Q:

                        break;
                    case KeyEvent.VK_S:
                        engine.getPlayer().getWeapon().toggleShoot();
                        break;
                    case KeyEvent.VK_H:
                        showHelp();
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
        });
    }

    public void addMenuMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int x = mouseEvent.getX();
                int y = mouseEvent.getY();

                if (mainMenuPanel.startButton.contains(x, y)) {
                    setContentPane(gamePanel);
                    Map map = new Map1(engine);
                    engine.setMap(map);
                    addGamePanelKeyListener();
                } else if (mainMenuPanel.aboutButton.contains(x, y)) {
                    setContentPane(aboutPanel);
                } else if (mainMenuPanel.instructionsButton.contains(x, y)) {
                    setContentPane(instructionPanel);
                } else if (mainMenuPanel.exitButton.contains(x, y)) {
                    System.exit(0);
                }
            }
        });
    }

    private void showHelp() {
        t.stop();
        JOptionPane.showMessageDialog(this, "WAD = Movement, S = Shoot, E = Toggle Tiles");
        t.start();
    }
}