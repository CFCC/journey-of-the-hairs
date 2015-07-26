package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.PhysicsEngine;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * This is the superclass for all of the game's panels. It only has a couple properties: an action listener (a bit
 * broad since some panels implement mouse listeners and some key listeners), and a background image (the
 * image to paint on the screen each tick). Originally, the game panel was the only one, but as the game grew,
 * ideas for more screens than just the game (like a menu, a kill screen, etc) came about. Thus, the need for
 * a folder/superclass came up. Shamwow, a panel class.
 */
public abstract class Panel extends JPanel {
	/**
	 * This is the background image field for panels. It is the background image painted on the screen
	 * each tick. A few basic panels only use this field because they have little function to the user
	 */
	public BufferedImage backgroundImage;

	public PhysicsEngine engine;

	private MenuListener menuListener;

	public Panel(MenuListener listener) {
		this.menuListener = listener;
	}

	public MenuListener getMenuListener() {
		return menuListener;
	}

	public void setBackground(BufferedImage bg) {
		backgroundImage = bg;
	}
}
