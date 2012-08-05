package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.item.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JourneyOfTheHairsFrame extends JFrame {

    GameEngine engine;
    private final GamePanel gamePanel;
    Pistol pistol = new Pistol(engine);
    GrenadeGun grenadeGun = new GrenadeGun(engine);
    MiniGun minigun = new MiniGun(engine);
    Railgun railgun = new Railgun(engine);
    Rifle rifle = new Rifle(engine);
    Shotgun shotgun = new Shotgun(engine);
    Item item = new Item(engine) {
        @Override
        protected void loadImages() {
        }
        @Override
        public void attack(Entity entity) {
        }
    };

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
                    case KeyEvent.VK_ESCAPE:
                        System.exit(0);
                        break;
                    case KeyEvent.VK_1:
                        item.setActiveItem(pistol);
                        break;
                    case KeyEvent.VK_2:
                        item.setActiveItem(shotgun);
                        break;
                    case KeyEvent.VK_3:
                        item.setActiveItem(minigun);
                        break;
                    case KeyEvent.VK_4:
                        item.setActiveItem(grenadeGun);
                        break;
                    case KeyEvent.VK_5:
                        item.setActiveItem(rifle);
                        break;
                    case KeyEvent.VK_6:
                        item.setActiveItem(railgun);
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

        addMouseListener((new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                float X = mouseEvent.getX() / GamePanel.TILE_SIZE + gamePanel.getxScreenPlace();
                float Y = mouseEvent.getY() / GamePanel.TILE_SIZE;
            }
        }));

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
