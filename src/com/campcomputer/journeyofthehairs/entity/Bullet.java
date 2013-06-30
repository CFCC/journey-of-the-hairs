package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Bullet extends Entity {

    public Bullet(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
    }

    @Override
    protected void loadImages() {
        if (getXVel() > 0)
            frames.add(Images.ReadImage("images/bullet bill right.png"));
        else
            frames.add(Images.ReadImage("images/bullet bill left.png"));
    }
}
