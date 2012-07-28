package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Rocket extends Entity {

	private static final int ROCKET_DAMAGE = 50;
    private static final float SPEED_MAGNITUDE = 0.1f;
    Player player;

    List<BufferedImage> rocketLeft;
    List<BufferedImage> rocketRight;

    public Rocket(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
    }

    @Override
    public void tick() {
        super.tick();

        float playerX = engine.getPlayer().getX();
        float playerY = engine.getPlayer().getY();

        if (playerX < getX()) {
            frames = rocketLeft;
            setxVel(-1 * SPEED_MAGNITUDE);
        } else {
            frames = rocketRight;
            setxVel(SPEED_MAGNITUDE);
        }

        if (playerY < getY()) {
            setyVel(-1 * SPEED_MAGNITUDE);
        } else {
            setyVel(SPEED_MAGNITUDE);
        }

        if (engine.isOnTopOfEntity(this, player)) {
            engine.getPlayer().setHealth(engine.getPlayer().getHealth() - ROCKET_DAMAGE);
            engine.removeEntity(this);
        }
    }

    @Override
    protected void loadImages() {
        rocketLeft = new ArrayList<BufferedImage>(1);
        rocketRight = new ArrayList<BufferedImage>(1);

        rocketLeft.add(Images.ReadImage("images/rocketLeft.png"));
        rocketRight.add(Images.ReadImage("images/rocketRight.png"));

        frames = rocketRight;
    }

    @Override
    public void attack(Entity entity) {

    }
	public boolean isAffectedByHitDetection() {
		return false;
	}
}
