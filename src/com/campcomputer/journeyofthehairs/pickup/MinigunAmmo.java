package com.campcomputer.journeyofthehairs.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class MinigunAmmo extends Pickup {
    public MinigunAmmo (GameEngine engine, int amount) {
        super(engine);
    }

    public void loadImages() {
        frames.add(Images.ReadImage("images/bullet ammo.png"));
    }
}
