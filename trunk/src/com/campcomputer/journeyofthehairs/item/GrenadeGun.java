package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class GrenadeGun extends Item {

    protected void loadImages() {
        frames.add(Images.ReadImage("images/grenadeLauncher.png"));
    }

    public GrenadeGun(GameEngine engine) {
        super(engine);

        setDamage(1);
        setFireRate(1);
        setBulletNumber(1);
        setBulletSpeed(1);
    }
}
