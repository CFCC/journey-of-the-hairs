package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.io.File;

public class Rocket extends Entity {

    public Rocket(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage(new File("images/rocket.png")));
    }

    @Override
    public void attack(Entity entity) {

    }
}
