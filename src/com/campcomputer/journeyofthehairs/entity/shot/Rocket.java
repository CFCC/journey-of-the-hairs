package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Rocket extends Shot {

	private static final int ROCKET_DAMAGE = 50;

	private static final float SPEED_MAGNITUDE = 0.1f;

	List<BufferedImage> rocketLeft;

	List<BufferedImage> rocketRight;

	public Rocket(PhysicsEngine engine) {
		//TODO
		super(engine, true, WeaponShots.BULLET);
	}

	@Override public void tick() {
		super.tick();

		float playerX = getEngine().getPlayer().getX();
		float playerY = getEngine().getPlayer().getY();

		if (playerX < getX()) {
			frames = rocketLeft;
			setXVelocity(-1 * SPEED_MAGNITUDE);
		} else {
			frames = rocketRight;
			setXVelocity(SPEED_MAGNITUDE);
		}

		if (playerY < getY()) {
			setYVelocity(-1 * SPEED_MAGNITUDE);
		} else {
			setYVelocity(SPEED_MAGNITUDE);
		}

		if (getEngine().isOnTopOfPlayer(this)) {
			getEngine().getPlayer().takeDamage(ROCKET_DAMAGE);
			getEngine().removeEntity(this);
		}
	}

	@Override protected void addImagesOfEntityToFrames() {
		rocketLeft = new ArrayList<BufferedImage>(1);
		rocketRight = new ArrayList<BufferedImage>(1);

		rocketLeft.add(Images.ReadImage("/images/entities/shots/rocket left.png"));
		rocketRight.add(Images.ReadImage("/images/entities/shots/rocket right.png"));

		frames = rocketRight;
	}
}
