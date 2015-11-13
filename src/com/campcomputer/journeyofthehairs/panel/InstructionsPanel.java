package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.JourneyOfTheHairsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class InstructionsPanel extends JPanel {
	private static final Point PAGE_NUMBER_LOCATION = new Point(463, 466);

	private static final Point INSTRUCTION_IMAGE_LOCATION = new Point(196, 63);

	private final BufferedImage backgroundImage = Images.ReadImage("/images/menu.png");

	private int page = 1;

	private int numPages;

	public InstructionsPanel(final JourneyOfTheHairsFrame frame) {
		super();

		JButton back = new JButton("Back");
		back.setPreferredSize(new Dimension(320, 80));
		back.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		back.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				frame.switchTo(JourneyOfTheHairsFrame.Panels.MAIN_MENU);
			}
		});
		add(back);

		JButton backPage = new JButton("Back");
		backPage.setPreferredSize(new Dimension(320, 80));
		backPage.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(backPage);

		JButton forwardPage = new JButton("Next");
		forwardPage.setPreferredSize(new Dimension(320, 80));
		forwardPage.setFont(new Font(getFont().getName(), getFont().getStyle(), 35));
		add(backPage);
	}

	public void goTo(String direction) {
		if (direction.equals("next")) {
			page++;
			if (page > numPages) {
				page--;
			}
		} else if (direction.equals("back")) {
			if (page != 1) {
				page--;
			}
		}

		repaint();
	}

	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backgroundImage, null, 0, 0);
	}
}
