package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.JourneyOfTheHairsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class AboutPanel extends JPanel {
	private final BufferedImage backgroundImage = Images.ReadImage("/images/menu.png");

	public AboutPanel(final JourneyOfTheHairsFrame frame) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createRigidArea(new Dimension(0, 125)));

		JLabel title = new JLabel();
		title.setText("Journey Of The Hairs");
		title.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(title);

		add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel madeBy = new JLabel();
		madeBy.setText("Made by CFCC, June 2012");
		madeBy.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		madeBy.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(madeBy);

		add(Box.createRigidArea(new Dimension(0, 50)));

		JLabel link = new JLabel();
		link.setText("http://www.github.com/CFCC/Journey-Of-The-Hairs");
		link.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		link.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(link);

		add(Box.createRigidArea(new Dimension(0, 275)));

		JButton back = new JButton("Back");
		back.setPreferredSize(new Dimension(320, 80));
		back.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		back.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				frame.switchTo(JourneyOfTheHairsFrame.Panels.MAIN_MENU);
			}
		});
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(back);
	}

	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backgroundImage, null, 0, 0);
	}
}
