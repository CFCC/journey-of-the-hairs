package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.item.GrenadeGun;

public class Grenade extends GrenadeGun {
    public Grenade (GameEngine engine) {
        super(engine);
    }

    @Override
    public void loadImages() {
        frames.add(Images.ReadImage("images/grenade.png"));
    }
}
