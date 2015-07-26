package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.Tile;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.map.Map;
import com.campcomputer.journeyofthehairs.map.MapListener;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends Panel implements MapListener, KeyListener {

	public static final int TILE_SIZE = 64;

	private static final Color BLOOD_COLOR = new Color(185, 0, 0);

	private static final Color GROUND_COLOR = new Color(150, 100, 50);

	private float xScreenPlace = 0f;

	private float lastHealth = 0;

	private boolean showTiles = false;

	private BufferedImage mapBackground;

	private float[] dashPattern = {1, 1};

	private BasicStroke tileStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0);

	public GamePanel(PhysicsEngine thePhysicsEngine, MenuListener menuListener) {
		super(menuListener);
		engine = thePhysicsEngine;

		addKeyListener(this);
		setFocusable(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

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
				toggleShowTiles();
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

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		drawBackground(g2);
		drawEntities(g2);
		drawInfoBar(g2);
		if (showTiles) {
			drawTiles(g2);
		}
	}

	private void drawInfoBar(Graphics2D g2) {
		g2.setColor(new Color(255, 255, 255));
		g2.fillRect(0, 0, getWidth(), 50);

		g2.setColor(new Color(0, 0, 0));
		g2.setFont(new Font(getFont().getName(), getFont().getStyle(), 18));
		Player p = engine.getPlayer();

		String status = "Health: " + p.getHealth() + "     Lives: " + p.getLives() +
		                "     Weapon: " + p.getWeapon() + "     Ammo: " + p.getWeapon().getAmmo();
		g2.drawString(status, 15, 30);
	}

	private void drawEntities(Graphics2D g2) {
		for (Entity entity : engine.getEntities()) {
			if (entity.getFrames().size() > 0) {
				g2.drawImage(entity.getCurrentFrame(), null, (int) ((entity.getX() - xScreenPlace) * TILE_SIZE), (int) (entity.getY() * TILE_SIZE));
			}
		}
	}

	private void drawBackground(Graphics2D g2) {
		xScreenPlace = 0;
		if (engine.getPlayer().getX() >= 8) {
			xScreenPlace = engine.getPlayer().getX() - 8;
		}
		if (engine.getPlayer().getX() >= engine.getMap().getTiles().length - 8) {
			xScreenPlace = engine.getMap().getTiles().length - 16;
		}

		g2.drawImage(mapBackground, null, (int) (- xScreenPlace * TILE_SIZE), 0);
	}

	private void drawTiles(Graphics2D g2) {
		int xFirst = (int) xScreenPlace;
		Tile[][] map = engine.getMap().getTiles();

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
						color = GROUND_COLOR;
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
			}
		}
	}

	public void toggleShowTiles() {
		showTiles = ! showTiles;
	}

	@Override
	public void setMap(Map map) {
		mapBackground = map.getImage();
	}
}

