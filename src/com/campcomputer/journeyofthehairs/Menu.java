package com.campcomputer.journeyofthehairs;

public class Menu {

    GameEngine engine;

    private MenuOptions[][] menu = {
            {MenuOptions.EXIT,},
            {MenuOptions.INFO,},
            {MenuOptions.INSTRUCTIONS,},
            {MenuOptions.OPTIONS,},
            {MenuOptions.START},
    };

    public void loadImages() {
        Images.ReadImage("images/main menu.png");
    }

    public void menuEffect(float X, float y) {
        switch(menu[((int) X)][((int) y)]) {
            case EXIT:
                System.exit(0);
                break;
            case START:
                String x[] = {"A", "B"};
                JourneyOfTheHairs.main(x);
                break;
            case INSTRUCTIONS:
                engine.directions();
                break;
        }
    }
}
