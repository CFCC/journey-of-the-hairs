package com.campcomputer.journeyofthehairs.panel;

public interface MenuListener {
	void switchTo(Panels panel);

	Panel getCurrentPanel();

	enum Panels {
		ABOUT, GAME, INSTRUCTIONS, MAIN_MENU, SETTINGS
	}
}
