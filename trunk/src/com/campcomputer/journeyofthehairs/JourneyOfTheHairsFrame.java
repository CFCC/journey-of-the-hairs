package com.campcomputer.journeyofthehairs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JourneyOfTheHairsFrame extends JFrame {
    static Timer t;
    public static int timerTick = 1000 / 30;
    GameEngine engine;
    private final GamePanel gamePanel;
    private final MainMenuPanel mainMenuPanel;

    public static Timer getTimer() {
        return t;
    }

    public JPanel getPanel() {
        return gamePanel;
    }

    public JourneyOfTheHairsFrame() throws HeadlessException {
        super("Journey Of The Hairs");

        engine = new GameEngine();

        new BoxLayout(this, BoxLayout.X_AXIS);

        gamePanel = new GamePanel(engine);
        mainMenuPanel = new MainMenuPanel();
        setContentPane(mainMenuPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(1024, 768);

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
                        if (getContentPane() instanceof GamePanel) {
                            setContentPane(new InstructionPanel());
                            t.stop();
                        } else {
                            setContentPane(gamePanel);
                            t.start();
                        }
                        break;
                    case KeyEvent.VK_S:
                        engine.getPlayer().getWeapon().toggleShoot();
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

        t = new Timer(timerTick, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.tick();
                repaint();
            }
        });
        t.start();
    }
}
