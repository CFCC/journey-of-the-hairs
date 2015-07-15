package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.map.Map;
import com.campcomputer.journeyofthehairs.map.MapListener;
import com.campcomputer.journeyofthehairs.map.World1Stage1;
import com.campcomputer.journeyofthehairs.panel.*;
import com.campcomputer.journeyofthehairs.panel.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class Name: JourneyOfTheHairsFrame (or Frame for short)
 * Purpose: The frame (window in layman's terms) used to contain the game
 */
public class JourneyOfTheHairsFrame extends JFrame implements MenuListener {
	/**
	 * The time interval, in milliseconds, at which the timer is invoked and its method is called.
	 * The lower the denominator of this variable, the better the motion quality of the game, but the slower it runs
	 */
	private final static int TIMER_TICK = 1000 / 30;

	public final MenuListener menuListener;

	public final MapListener mapListener;

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
		mapListener = new MapListener() {
			@Override
			public void setMap(Map map) {
				changeMap(map);
			}
		};
		engine = new PhysicsEngine(mapListener);

		new BoxLayout(this, BoxLayout.X_AXIS);

		menuListener = new MenuListener() {
			@Override
			public void switchTo(Panels panel) {
				switchContentPane(panel);
			}

			@Override
			public Panel getCurrentPanel() {
				return (Panel) getContentPane();
			}
		};
		aboutPanel = new AboutPanel(menuListener);
		instructionsPanel = new InstructionsPanel(this);
		mainMenuPanel = new MainMenuPanel(menuListener);
		gamePanel = new GamePanel(engine, menuListener);
		settingsPanel = new SettingsPanel(menuListener);

		mapListener.setMap(new World1Stage1(engine, mapListener));
		switchContentPane(mainMenuPanel);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1024, 768);

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
				switchContentPane(aboutPanel);
				break;
			case GAME:
				switchContentPane(gamePanel);
				break;
			case INSTRUCTIONS:
				switchContentPane(instructionsPanel);
				break;
			case MAIN_MENU:
				switchContentPane(mainMenuPanel);
				break;
			case SETTINGS:
				switchContentPane(settingsPanel);
		}
	}

	/**
	 * Method for switching out content panes. The method is different from setContentPane() in that
	 * it changes mouse/key adapters appropriately and revalidates so the new panel shows up
	 *
	 * @param panel the panel to become the content pane
	 */
	public void switchContentPane(com.campcomputer.journeyofthehairs.panel.Panel panel) {
		if (getKeyListeners().length > 0) {
			removeKeyListener(getKeyListeners()[0]);
		}
		if (getMouseListeners().length > 0) {
			removeMouseListener(getMouseListeners()[0]);
		}

		setContentPane(panel);

		if (panel.listener instanceof KeyAdapter) {
			addKeyListener((KeyListener) panel.listener);
		} else if (panel.listener instanceof MouseAdapter) {
			addMouseListener((MouseListener) panel.listener);
		}

		revalidate();
	}

	@Override
	public void switchTo(Panels panel) {
		switchContentPane(panel);
	}

	@Override
	public Panel getCurrentPanel() {
		return (Panel) getContentPane();
	}

	public void changeMap(Map map) {
		gamePanel.setMap(map);
		engine.setMap(map);
	}
}