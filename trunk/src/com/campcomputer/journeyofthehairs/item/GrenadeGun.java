package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.ammo.Grenade;

public class GrenadeGun extends Item {

    protected void loadImages() {
        frames.add(Images.ReadImage("images/grenadeLauncher.png"));
    }

    public GrenadeGun(GameEngine engine) {
        super(engine);
        setAmmoType(new Grenade(engine));
    }
}
