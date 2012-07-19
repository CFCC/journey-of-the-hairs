package com.campcomputer.journeyofthehairs;

public class Menu {
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

    public void menuEffect (float x, float y) {

    }
}
