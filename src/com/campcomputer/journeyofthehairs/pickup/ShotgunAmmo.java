package com.campcomputer.journeyofthehairs.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;

public class ShotgunAmmo extends Entity {
    public ShotgunAmmo (GameEngine engine, int amount) {
        super(engine);
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage("images/shotgun ammo.png"));
    }
}
