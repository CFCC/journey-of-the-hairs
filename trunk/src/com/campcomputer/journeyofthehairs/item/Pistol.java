package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.ammo.Bullet;

public class Pistol extends Item {

    protected void loadImages() {
        frames.add(Images.ReadImage("images/pistol.png"));
    }

    public Pistol(GameEngine engine) {
        super(engine);
        setAmmoType(new Bullet(engine));
        setAffectedByGravity(false);
    }
}
