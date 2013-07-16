package com.campcomputer.journeyofthehairs.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.item.Rifle;

public class RifleShot extends Ammo {
    public RifleShot (GameEngine engine) {
        super(engine);
        setDamage(1);
        setFireRate(5);
        setBulletNumber(1);
        setBulletSpeed(2);
    }

    public void loadImages() {

    }
}
