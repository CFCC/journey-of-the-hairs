package com.campcomputer;

import com.campcomputer.entity.Player;
import com.sun.xml.internal.ws.api.pipe.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.IdentityHashMap;
import java.util.Map;


public class GamePanel extends JPanel {

    private static final int TILE_SIZE = 64;
    float xScreenPlace = 0f;

    private BufferedImage tomato;
    private BufferedImage carrot;
    private BufferedImage ground;
    private BufferedImage air;
    private BufferedImage pit;
    private BufferedImage cheese;

    private BufferedImage hareForward;

    private BufferedImage mapBackground;
    private Map<Entity, Integer> currentFrames = new IdentityHashMap<Entity, Integer>();

    GameEngine ourGameEngine;

    public GamePanel(GameEngine theGameEngine) {

        this.ourGameEngine = theGameEngine;
        tomato = Images.ReadImage(new File("images/tomato.jpg"));
        ground = Images.ReadImage(new File("images/ground.jpg"));
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

        xScreenPlace = ourGameEngine.getPlayer().getX();
        if(ourGameEngine.getPlayer().getX() == 8) {
            xScreenPlace = ourGameEngine.getPlayer().getX() - 8;
        }
        if (ourGameEngine.getPlayer().getX() == 192) {
            xScreenPlace = ourGameEngine.getPlayer().getX() + 16;
        }


        g2.drawImage(mapBackground, null, (int) (-xScreenPlace * TILE_SIZE), 0);

        for (Entity entity : ourGameEngine.getEntities()) {
            if (entity.getFrames().size() > 0) {
                g2.drawImage(entity.getCurrentFrame(), null, (int) ((entity.getX()- xScreenPlace)  * TILE_SIZE), (int) (entity.getY() * TILE_SIZE));
            }
        }

        drawTiles(g2);
    }

    private void drawTiles(Graphics2D g2) {
        int xFirst = (int) xScreenPlace;


        Tile[][] map = ourGameEngine.getMap();

        for (int x = xFirst; x < xFirst + 17 && x < map.length; x++) {
            for (int y = 0; y < 12; y++) {
                Color color = null;
                switch (map[x][y]) {
                    case PLANT:
                         color = Color.green;
                        break;
                    case CARROT:
                        color = Color.orange;
                        break;
                    case AIR:
                        color = Color.blue;
                        break;
                    case GROUND:
                        color = new Color(150, 100, 50);
                        break;
                    case PIT:
                        color = Color.magenta;
                        break;
                    case CHEESE:
                        color = Color.YELLOW;
                        break;
                }
                g2.setColor(color);
                g2.drawRect((int) ((x - xScreenPlace) * TILE_SIZE)+5, y * TILE_SIZE+5,TILE_SIZE -10, TILE_SIZE -10);
                //g2.drawImage(image, null, (int) ((x - xScreenPlace) * TILE_SIZE), y * TILE_SIZE);

            }
        }
    }
}

