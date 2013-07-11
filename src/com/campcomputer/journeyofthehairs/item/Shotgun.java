package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Shotgun extends Item {
    protected void loadImages() {
    frames.add(Images.ReadImage("images/shotgun.png"));
}

    public Shotgun(GameEngine engine) {
        super(engine);

        setDamage(1);
        setFireRate(1);
        setBulletNumber(20);
        setBulletSpeed(3);
    }
}
