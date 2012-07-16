package com.campcomputer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JourneyOfTheHairsFrame extends JFrame {

    GameEngine engine;
    private final GamePanel gamePanel;

    public JourneyOfTheHairsFrame() throws HeadlessException {
        super("Journey Of The Hairs");

        engine = new GameEngine();

        new BoxLayout(this, BoxLayout.X_AXIS);

        gamePanel = new GamePanel(engine);
        add(gamePanel);

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
                        engine.directions();
                        break;
                    case KeyEvent.VK_S:
                        engine.shoot();
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
        });

 //       addMouseListener((new MouseAdapter() {
 //           @Override
 //           public void mouseClicked(MouseEvent mouseEvent) {
 //               float X = mouseEvent.getX() / GamePanel.TILE_SIZE + gamePanel.getxScreenPlace();
 //               float Y = mouseEvent.getY() / GamePanel.TILE_SIZE;
 //               engine.shoot();
 //           }
 //       }));

        Timer t = new Timer(1000 / 30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                engine.tick();
                repaint();

            }
        });
        t.start();
    }
}
