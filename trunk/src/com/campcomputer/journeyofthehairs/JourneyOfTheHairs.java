package com.campcomputer.journeyofthehairs;

import javax.swing.*;

public class JourneyOfTheHairs {
    static JourneyOfTheHairsFrame journeyOfTheHairsFrame;

    public static void main(String[] args) {
        journeyOfTheHairsFrame = new JourneyOfTheHairsFrame();
        journeyOfTheHairsFrame.setVisible(true);
    }

    public static JourneyOfTheHairsFrame getFrame() {
        return journeyOfTheHairsFrame;
    }

    public static void changePanel (JPanel panel) {
        getFrame().setContentPane(panel);
    }
}
