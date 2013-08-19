package com.campcomputer.journeyofthehairs.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class ShotgunAmmo extends Pickup {
    public ShotgunAmmo (GameEngine engine, int amount) {
        super(engine);
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage("images/shotgun ammo.png"));
    }
}
