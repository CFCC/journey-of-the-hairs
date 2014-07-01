package com.campcomputer.journeyofthehairs.panel;

public interface MenuListener {
	public void switchTo(Panels panel);

	public Panel getCurrentPanel();

	public enum Panels {
		ABOUT, GAME, INSTRUCTIONS, MAIN_MENU, SETTINGS
	}
}
