package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class MainMenuPanel extends Panel implements MenuListener {
	public Rectangle startButton = new Rectangle(0, 0, 200, 200);

	public Rectangle aboutButton = new Rectangle(537, 528, 324, 81);

	public Rectangle exitButton = new Rectangle(542, 654, 313, 74);

	public Rectangle instructionsButton = new Rectangle(156, 640, 313, 74);

	BufferedImage bgImage = Images.ReadImage("menus/title");

	public MainMenuPanel(MenuListener listener) {
		super(listener);
		setBackground(bgImage);
	}

	@Override
	public void addListener() {
		listener =
				/**
				 * Mouse adapter for the main menu. Includes 4 rectangles (1 for each of the 4 buttons on the menu).
				 * Switches content panes according to which button is pressed. Ends the program by click of the exit button
				 */
				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent mouseEvent) {
						int x = mouseEvent.getX();
						int y = mouseEvent.getY();

						if (startButton.contains(x, y)) {
							getMenuListener().switchTo(Panels.GAME);
							revalidate();
						} else if (aboutButton.contains(x, y)) {
							getMenuListener().switchTo(Panels.ABOUT);
							revalidate();
						} else if (instructionsButton.contains(x, y)) {
							getMenuListener().switchTo(Panels.INSTRUCTIONS);
							revalidate();
						} else if (exitButton.contains(x, y)) {
							System.exit(0);
						}
					}
				};
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backgroundImage, null, 0, 0);
	}

	@Override
	public void switchTo(Panels panel) {

	}

	@Override
	public Panel getCurrentPanel() {
		return null;
	}
}
