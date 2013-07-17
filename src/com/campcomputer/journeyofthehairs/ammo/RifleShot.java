package com.campcomputer.journeyofthehairs.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class RifleShot extends Ammo {
    public RifleShot (GameEngine engine) {
        super(engine);
        setDamage(1);
        setFireRate(5);
        setBulletNumber(1);
        setBulletSpeed(2);
    }

    public void loadImages() {
        frames.add(Images.ReadImage("images/rifle shot.png"));
    }
}
