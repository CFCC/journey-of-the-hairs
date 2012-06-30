package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.io.File;

public class Rocket extends Entity {

	private static final int ROCKET_DAMAGE = 10;
    private static final float SPEED_DIVISOR = 0.5f;
    
	public Rocket(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
    }

    @Override
    public void tick() {
        super.tick();

        float playerX = engine.getPlayer().getX();
        float playerY = engine.getPlayer().getY();

        float newXvel = (getX() + (getX() + playerX)) * SPEED_DIVISOR;
        float newYvel = (getY() + (getY() + playerY)) * SPEED_DIVISOR;

        setxVel(newXvel);
        setyVel(newYvel);

        if (engine.isOnTopOfPlayer(this)) {
            setHealth(0);
            engine.removeEntity(this);
        }
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage(new File("images/rocket.png")));
    }

    @Override
    public void attack(Entity entity) {

    }
}
