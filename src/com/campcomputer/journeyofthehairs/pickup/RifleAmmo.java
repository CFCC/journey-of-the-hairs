package com.campcomputer.journeyofthehairs.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class RifleAmmo extends Pickup {
    public RifleAmmo(GameEngine engine, int amount) {
        super(engine);
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage("images/rifle ammo.png"));
    }
}
