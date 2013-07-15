package com.campcomputer.journeyofthehairs.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class RailgunAmmo extends Pickup {
    public RailgunAmmo (GameEngine engine, int amount) {
        super(engine);
    }

    public void loadImages() {
        frames.add(Images.ReadImage("images/railgun ammo.png"));
    }
}
