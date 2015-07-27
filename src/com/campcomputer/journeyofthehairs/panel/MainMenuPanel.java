package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.JourneyOfTheHairsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MainMenuPanel extends Panel {
	BufferedImage bgImage = Images.ReadImage("/images/menus/title.png");

	public MainMenuPanel(final JourneyOfTheHairsFrame frame) {
		super();
		setBackground(bgImage);
		((FlowLayout) getLayout()).setHgap(75);
		((FlowLayout) getLayout()).setVgap(25);


		JPanel placeholder = new JPanel();
		placeholder.setOpaque(false);
		placeholder.setPreferredSize(new Dimension(10000, 475));
		add(placeholder);

		JButton startGame = new JButton("Start Game");
		startGame.setPreferredSize(new Dimension(320, 80));
		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.switchTo(JourneyOfTheHairsFrame.Panels.GAME);
			}
		});
		startGame.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(startGame);

		JButton about = new JButton("About");
		about.setPreferredSize(new Dimension(320, 80));
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.switchTo(JourneyOfTheHairsFrame.Panels.ABOUT);
			}
		});
		about.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(about);

		JButton exit = new JButton("Exit");
		exit.setPreferredSize(new Dimension(320, 80));
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(exit);

		JButton instructions = new JButton("Instructions");
		instructions.setPreferredSize(new Dimension(320, 80));
		instructions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.switchTo(JourneyOfTheHairsFrame.Panels.INSTRUCTIONS);
			}
		});
		instructions.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(instructions);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backgroundImage, null, 0, 0);
	}
}
