package com.campcomputer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class GamePanel extends JPanel {

    float xScreenPlace = 0f;

    private BufferedImage tomato;
    private BufferedImage ground;
    private BufferedImage carrot;
    private BufferedImage air;
    private BufferedImage pit;
    private BufferedImage cheese;

    private BufferedImage hareForward;

    private BufferedImage mapBackground;


    GameEngine ourGameEngine;

    public GamePanel(GameEngine theGameEngine) {

        this.ourGameEngine = theGameEngine;
        tomato = Images.ReadImage(new File("images/tomato.jpg"));
        ground = Images.ReadImage(new File("images/ground.jpg"));
        carrot = Images.ReadImage(new File("images/carrot rotated.png"));
        air = Images.ReadImage(new File("images/Sky_Blue.png"));
        pit = Images.ReadImage(new File("images/Sky_Blue.png"));
        cheese = Images.ReadImage(new File("images/cheese_oh_cheese.jpg"));
        hareForward = Images.ReadImage(new File("images/hare forward.png"));

        mapBackground = Images.ReadImage(new File("images/background.png"));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //drawTiles(g2);

        g2.drawImage(mapBackground, null, (int) (-xScreenPlace * 64), 0);

        for (Entity entity : ourGameEngine.getEntities()) {

            g2.drawImage(hareForward, null, (int) (entity.getX() * 64),(int)(entity.getY() * 64));
        }
    }

    private void drawTiles(Graphics2D g2) {
        int xFirst = (int) xScreenPlace;

        Tile[][] map = ourGameEngine.getMap();

        for (int x = xFirst; x < xFirst + 17; x++) {
            for (int y = 0; y < 12; y++) {
                BufferedImage image = null;
                switch (map[x][y]) {
                    case PLANT:
                        image = tomato;
                        break;
                    case CARROT:
                        image = carrot;
                        break;
                    case AIR:
                        image = air;
                        break;
                    case GROUND:
                        image = ground;
                        break;
                    case PIT:
                        image = pit;
                        break;
                    case CHEESE:
                        image = cheese;
                        break;
                }
                g2.drawImage(image, null, (int) ((x - xScreenPlace) * 64), y * 64);

            }
        }
    }
}

