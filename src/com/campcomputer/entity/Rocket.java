package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;

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

    }

    @Override
    public void attack(Entity entity) {

    }
}
