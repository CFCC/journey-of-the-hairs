package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.ammo.LaserBeam;
import com.campcomputer.journeyofthehairs.entity.ChuckNorris;

public class Railgun extends Item {

    protected void loadImages() {
        frames.add(Images.ReadImage("images/railgun.png"));
    }

    public Railgun(GameEngine engine) {
        super(engine);
        setAmmoType(new LaserBeam(engine));
    }
}
