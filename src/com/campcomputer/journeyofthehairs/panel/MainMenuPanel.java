package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.JourneyOfTheHairsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MainMenuPanel extends JPanel {
	private BufferedImage backgroundImage = Images.ReadImage("/images/menu.png");

	public MainMenuPanel(final JourneyOfTheHairsFrame frame) {
		super();
		((FlowLayout) getLayout()).setHgap(75);
		((FlowLayout) getLayout()).setVgap(25);

		JPanel placeholder = new JPanel();
		placeholder.setOpaque(false);
		placeholder.setPreferredSize(new Dimension(10000, 475));
		placeholder.setLayout(new BoxLayout(placeholder, BoxLayout.Y_AXIS));
		add(placeholder);

		JLabel placeholder2 = new JLabel();
		placeholder2.setText(" ");
		placeholder.add(placeholder2);

		JLabel title = new JLabel("Journey Of");
		title.setFont(new Font(getFont().getName(), getFont().getStyle(), 80));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		placeholder.add(title);

		JLabel title2 = new JLabel("The Hairs");
		title2.setFont(new Font(getFont().getName(), getFont().getStyle(), 80));
		title2.setAlignmentX(Component.CENTER_ALIGNMENT);
		placeholder.add(title2);

		JButton startGame = new JButton("Start Game");
		startGame.setPreferredSize(new Dimension(320, 80));
		startGame.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				frame.switchTo(JourneyOfTheHairsFrame.Panels.GAME);
			}
		});
		startGame.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(startGame);

		JButton about = new JButton("About");
		about.setPreferredSize(new Dimension(320, 80));
		about.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				frame.switchTo(JourneyOfTheHairsFrame.Panels.ABOUT);
			}
		});
		about.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(about);

		JButton exit = new JButton("Exit");
		exit.setPreferredSize(new Dimension(320, 80));
		exit.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(exit);

		JButton instructions = new JButton("Instructions");
		instructions.setPreferredSize(new Dimension(320, 80));
		instructions.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				frame.switchTo(JourneyOfTheHairsFrame.Panels.INSTRUCTIONS);
			}
		});
		instructions.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(instructions);
	}

	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backgroundImage, null, 0, 0);
	}
}
