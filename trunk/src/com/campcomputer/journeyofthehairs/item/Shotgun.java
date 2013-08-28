package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.ammo.ShotgunBullet;

public class Shotgun extends Item {
    protected void loadImages() {
    frames.add(Images.ReadImage("images/shotgun.png"));
}

    public Shotgun(GameEngine engine) {
        super(engine);
        setAmmoType(new ShotgunBullet(engine));
        setAffectedByGravity(false);
        addAmmo(10);
    }
}
