package com.campcomputer.journeyofthehairs.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class GrenadeAmmo extends Pickup {
    public GrenadeAmmo(GameEngine engine, int amount)  {
        super(engine);
    }

    public void loadImages() {
        frames.add(Images.ReadImage("images/grenade gun ammo.png"));
    }
}
