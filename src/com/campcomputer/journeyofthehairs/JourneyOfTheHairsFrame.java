package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.map.World1Stage1;
import com.campcomputer.journeyofthehairs.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class Name: JourneyOfTheHairsFrame (or Frame for short)
 * Purpose: The frame (window in layman's terms) used to contain the game
 */
public class JourneyOfTheHairsFrame extends JFrame {
	/**
	 * The time interval, in milliseconds, at which the timer is invoked and its method is called.
	 * The lower the denominator of this variable, the better the motion quality of the game, but the slower it runs
	 */
	private final static int TIMER_TICK = 1000 / 30;

	/**
	 * The instance of the game panel used throughout the game's code
	 */
	private final GamePanel gamePanel;

	/**
	 * The instance of the main menu used in the code for the beginning of the game
	 */
	private final MainMenuPanel mainMenuPanel;

	/**
	 * The instance of the instructions menu used in the code for the beginning of the game
	 */
	private final InstructionsPanel instructionsPanel;

	/**
	 * The instance of the about screen used in the code for the beginning of the game
	 */
	private final AboutPanel aboutPanel;

	private final SettingsPanel settingsPanel;

	/**
	 * The instance of the game engine used throughout the game's code
	 */
	private PhysicsEngine engine;

	/**
	 * Class constructor. Makes a new frame for the game and sets it up. Also defines final fields and creates a timer
	 *
	 * @throws HeadlessException
	 */
	public JourneyOfTheHairsFrame() throws HeadlessException {
		super("Journey Of The Hairs");
		setIconImage(Images.ReadImage("/images/entities/creatures/hare forward.png"));
		engine = new PhysicsEngine();

		new BoxLayout(this, BoxLayout.X_AXIS);

		aboutPanel = new AboutPanel(this);
		instructionsPanel = new InstructionsPanel(this);
		mainMenuPanel = new MainMenuPanel(this);
		gamePanel = new GamePanel(engine);
		settingsPanel = new SettingsPanel(this);

		switchContentPane(Panels.MAIN_MENU);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1024, 768);

		setResizable(false);

		Timer t = new Timer(TIMER_TICK, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getContentPane() instanceof GamePanel) {
					engine.tick();
				}
				repaint();
			}
		});
		t.start();
	}

	private void switchContentPane(Panels panel) {
		switch (panel) {
			case ABOUT:
				setContentPane(aboutPanel);
				break;
			case GAME:
				setContentPane(gamePanel);
				gamePanel.requestFocusInWindow();
				engine.setMap(new World1Stage1(engine));
				break;
			case INSTRUCTIONS:
				setContentPane(instructionsPanel);
				break;
			case MAIN_MENU:
				setContentPane(mainMenuPanel);
				break;
			case SETTINGS:
				setContentPane(settingsPanel);
		}
		revalidate();
	}

	public void switchTo(Panels panel) {
		switchContentPane(panel);
	}

	public enum Panels {
		ABOUT, GAME, INSTRUCTIONS, MAIN_MENU, SETTINGS
	}
}