package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class MiniGun extends Item {

    protected void loadImages() {
        frames.add(Images.ReadImage("images/minigun.png"));
    }

    public MiniGun(GameEngine engine) {
        super(engine);

        setDamage(1);
        setFireRate(5);
        setBulletNumber(1);
        setBulletSpeed(1);
    }
}
