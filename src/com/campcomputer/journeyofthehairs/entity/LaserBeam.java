package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.item.Railgun;

public class LaserBeam extends Railgun {
    public LaserBeam(GameEngine engine) {
        super(engine);
    }

    public void loadImages() {
        frames.add(Images.ReadImage("images/laser beam.png"));
    }

    public void tick() {
        if (engine.getPlayer().isFacingLeft())
            setXVel(getBulletSpeed() * -1);
        else
            setXVel(getBulletSpeed());

        for (Entity entity : engine.getEntities()) {

        }
    }

    public boolean isAffectedByGravity() {
        return false;
    }
}
