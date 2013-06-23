package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Pistol extends Item {

    protected void loadImages() {
        frames.add(Images.ReadImage("images/pistol.png"));
    }

    public Pistol(GameEngine engine) {
        super(engine);

        setDamage(1);
        setFireRate(1);
        setBulletNumber(1);
        setBulletSpeed(1);
    }
}
