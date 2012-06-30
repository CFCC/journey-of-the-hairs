package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.io.File;

public class Rocket extends Entity {

    private int rocketDamage = 50;

    public Rocket(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
        setxVel(1);
    }

    @Override
    public void tick() {
        super.tick();

        float playerX = engine.getPlayer().getX();
        float playerY = engine.getPlayer().getY();
        float slope = (getX() + playerX) / (getY() + playerY);
        float yIntercept = getY() - (slope * getX());

        setX(getX() + getxVel());
        setY((slope * getX()) + yIntercept);
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage(new File("images/rocket.png")));
    }

    @Override
    public void attack(Entity entity) {

    }
}
