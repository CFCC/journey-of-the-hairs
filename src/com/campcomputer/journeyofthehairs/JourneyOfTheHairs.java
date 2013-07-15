package com.campcomputer.journeyofthehairs;
public class JourneyOfTheHairs {
    static JourneyOfTheHairsFrame journeyOfTheHairsFrame;

    public static void main(String[] args) {
        journeyOfTheHairsFrame = new JourneyOfTheHairsFrame();
        journeyOfTheHairsFrame.setVisible(true);
    }

    public static JourneyOfTheHairsFrame getFrame() {
        return journeyOfTheHairsFrame;
    }
}
