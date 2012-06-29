package com.campcomputer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JourneyOfTheHairsFrame extends JFrame {


    GameEngine engine;


    public JourneyOfTheHairsFrame() throws HeadlessException {
        super("Journey Of The Hairs");

        engine = new GameEngine();

        new BoxLayout(this, BoxLayout.X_AXIS);

        add(new GamePanel(engine));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(1024, 768);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A:
                        engine.moveBackward();
                        break;
                    case KeyEvent.VK_D:
                        engine.moveForward();
                        break;
                    case KeyEvent.VK_W:
                        engine.jump();
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);    //To change body of overridden methods use File | Settings | File Templates.
            }
        });


        addMouseListener((new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                float X = mouseEvent.getX() / GamePanel.TILE_SIZE;
                float Y = mouseEvent.getY() / GamePanel.TILE_SIZE;
               // engine.shoot(X, Y);
            }
        }));

        Timer t = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                engine.tick();
                repaint();

            }
        });
        t.start();
    }
}
