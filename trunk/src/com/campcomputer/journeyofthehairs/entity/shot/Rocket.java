package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Rocket extends Shot {

	private static final int ROCKET_DAMAGE = 50;
	private static final float SPEED_MAGNITUDE = 0.1f;

	List<BufferedImage> rocketLeft;
	List<BufferedImage> rocketRight;

	public Rocket(GameEngine engine) {
		super(engine);
	}

	@Override
	public void tick() {
		super.tick();

		float playerX = engine.getPlayer().getX();
		float playerY = engine.getPlayer().getY();

		if (playerX < getX()) {
			frames = rocketLeft;
			setXVel(-1 * SPEED_MAGNITUDE);
		} else {
			frames = rocketRight;
			setXVel(SPEED_MAGNITUDE);
		}

		if (playerY < getY()) {
			setYVel(-1 * SPEED_MAGNITUDE);
		} else {
			setYVel(SPEED_MAGNITUDE);
		}

		if (engine.isOnTopOfPlayer(this)) {
			engine.getPlayer().setHealth(engine.getPlayer().getHealth() - ROCKET_DAMAGE);
			engine.removeEntity(this);
		}
	}

	@Override
	protected void loadImages() {
		rocketLeft = new ArrayList<BufferedImage>(1);
		rocketRight = new ArrayList<BufferedImage>(1);

		rocketLeft.add(Images.ReadImage("entities/shots/rocket left"));
		rocketRight.add(Images.ReadImage("entities/shots/rocket right"));

		frames = rocketRight;
	}

	public boolean isAffectedByHitDetection() {
		return false;
	}
}
