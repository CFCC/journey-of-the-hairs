package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AboutPanel extends Panel {
	private Rectangle backButton = new Rectangle(364, 592, 321, 82);

	public AboutPanel(MenuListener menuListener) {
		super(menuListener);
		setBackground(Images.ReadImage("menus/about"));
	}

	@Override
	public void addListener() {
		listener =

				/**
				 * Mouse adapter for the about page. Only rectangle is the back button
				 */
				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int x = e.getX();
						int y = e.getY();

						if (backButton.contains(x, y)) {
							getMenuListener().switchTo(MenuListener.Panels.MAIN_MENU);
						}
					}
				};
	}
}
