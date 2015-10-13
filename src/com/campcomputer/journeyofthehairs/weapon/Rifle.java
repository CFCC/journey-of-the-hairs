package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.shot.RifleShot;

public class Rifle extends Weapon {

	public Rifle(PhysicsEngine engine) {
		super(engine, 10);
	}

	@Override
	protected void addImagesOfEntityToFrames() {

	}

	@Override
	public boolean shoot() {
		if (super.shoot()) {
			PhysicsEngine engine = getEngine();
			RifleShot rifleShot = new RifleShot(engine, engine.getPlayer().isFacingLeft());
			engine.addEntity(rifleShot);
		}
		return true;
	}
}
