package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.IdentityHashMap;
import java.util.Map;


public class GamePanel extends JPanel {

    public static final int TILE_SIZE = 64;
    private static final Color BLOOD_COLOR = new Color(185, 0, 0);
    float xScreenPlace = 0f;
    float lastHealth = 0;
    boolean showTiles = false;


    private BufferedImage mapBackground;
    private Map<Entity, Integer> currentFrames = new IdentityHashMap<Entity, Integer>();

    GameEngine ourGameEngine;

    private float[] dashPattern = {1, 1};
    private BasicStroke tileStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER, 10,
            dashPattern, 0);

    public GamePanel(GameEngine theGameEngine) {

        this.ourGameEngine = theGameEngine;
        mapBackground = Images.ReadImage("images/background improved.png");

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (ourGameEngine.getPlayer().getHealth() < lastHealth) {
            g2.setColor(BLOOD_COLOR);
            g2.fillRect(0, 0, getWidth(), getHeight());
            lastHealth = 0;
            return;
        }
        lastHealth = ourGameEngine.getPlayer().getHealth();


        xScreenPlace = 0;
        if (ourGameEngine.getPlayer().getX() >= 8) {
            xScreenPlace = ourGameEngine.getPlayer().getX() - 8;
        }
        if (ourGameEngine.getPlayer().getX() >= ourGameEngine.getMap().length - 8) {
            xScreenPlace = ourGameEngine.getMap().length - 16;
        }


        g2.drawImage(mapBackground, null, (int) (-xScreenPlace * TILE_SIZE), 0);

        for (Entity entity : ourGameEngine.getEntities()) {
            if (entity.getFrames().size() > 0) {
                g2.drawImage(entity.getCurrentFrame(), null, (int) ((entity.getX() - xScreenPlace) * TILE_SIZE), (int) (entity.getY() * TILE_SIZE));
            }
        }

        if (showTiles)
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
                g2.setStroke(tileStroke);
                g2.drawRect((int) ((x - xScreenPlace) * TILE_SIZE) + 1, y * TILE_SIZE + 1, TILE_SIZE - 2, TILE_SIZE - 2);
                //g2.drawImage(image, null, (int) ((x - xScreenPlace) * TILE_SIZE), y * TILE_SIZE);

            }
        }
    }

    public void toggleShowTiles() {
        showTiles = !showTiles;
    }
	public float getxScreenPlace() {
		return xScreenPlace;
	}
}

