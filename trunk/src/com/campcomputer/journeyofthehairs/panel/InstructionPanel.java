package com.campcomputer.journeyofthehairs.panel;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.JourneyOfTheHairsFrame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class InstructionPanel extends Panel {
    public Rectangle backButton = new Rectangle(367, 594, 318, 77);
    public Rectangle nextPageButton = new Rectangle(603, 406, 219, 105);
    public Rectangle backPageButton = new Rectangle(204, 407, 219, 104);
    private static final Point PAGE_NUMBER_LOCATION = new Point(463, 466);
    private static final Point INSTRUCTION_IMAGE_LOCATION = new Point(196, 63);
    private ArrayList<BufferedImage> pages = new ArrayList<BufferedImage>();
    private ArrayList<BufferedImage> numbers = new ArrayList<BufferedImage>();
    private int page = 1;
    private int numPages;
    private JourneyOfTheHairsFrame frame;

    public InstructionPanel(JourneyOfTheHairsFrame frame) {
        this.frame = frame;
        setBackground(Images.ReadImage("images/instruction menu.png"));

        numbers.add(Images.ReadImage("images/1.png"));
        numbers.add(Images.ReadImage("images/2.png"));
        numbers.add(Images.ReadImage("images/3.png"));

        pages.add(Images.ReadImage("images/instruction 1.png"));
        pages.add(Images.ReadImage("images/instruction 2.png"));
        pages.add(Images.ReadImage("images/instruction 3.png"));

        numPages = pages.size();
    }

    public void goTo(String direction) {
        if (direction.equals("next")) {
                page++;
            if (page > numPages)
                page--;
        } else if (direction.equals("back")) {
            if (page != 1)
                page--;
        }

        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (frame.getContentPane() instanceof InstructionPanel) {
            g2.drawImage(pages.get(page - 1), null, INSTRUCTION_IMAGE_LOCATION.x, INSTRUCTION_IMAGE_LOCATION.y);
            g2.drawImage(numbers.get(page - 1), null, PAGE_NUMBER_LOCATION.x, PAGE_NUMBER_LOCATION.y);
        }
    }
}
