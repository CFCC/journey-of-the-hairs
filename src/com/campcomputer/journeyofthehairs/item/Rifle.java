package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.ammo.RifleShot;

public class Rifle extends Item {

    protected void loadImages() {
    frames.add(Images.ReadImage("images/rifle.png"));
}

    public Rifle(GameEngine engine) {
        super(engine);
        setAmmoType(new RifleShot(engine));
        setAffectedByGravity(false);
        addAmmo(10);
    }
}
