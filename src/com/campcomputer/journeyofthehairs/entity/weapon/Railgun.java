package com.campcomputer.journeyofthehairs.entity.weapon;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.shot.RailgunShot;

public class Railgun extends Weapon {

	public Railgun(PhysicsEngine engine) {
		super(engine, 1);
	}

	@Override
	protected void addImagesOfEntityToFrames() {

	}

	@Override
	public void shoot() {
		super.shoot();
		PhysicsEngine engine = getEngine();
		RailgunShot railgunShot = new RailgunShot(engine, engine.getPlayer().isFacingLeft());
		engine.addEntity(railgunShot);
	}
}
