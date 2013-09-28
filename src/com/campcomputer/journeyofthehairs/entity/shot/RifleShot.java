package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class RifleShot extends Shot {
    public RifleShot (GameEngine engine) {
        super(engine);
        setDamage(1);
        setBulletSpeed(2);
    }

    public void loadImages() {
        frames.add(Images.ReadImage("entities/shots/rifle shot"));
    }
}
