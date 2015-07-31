package com.campcomputer.journeyofthehairs.entity.weapon;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.shot.ShotgunShot;

public class Shotgun extends Weapon {

	public Shotgun(PhysicsEngine engine) {
		super(engine, 10);
	}

	@Override
	protected void addImagesOfEntityToFrames() {

	}

	@Override
	public void shoot() {
		super.shoot();
		PhysicsEngine engine = getEngine();
		ShotgunShot shot = new ShotgunShot(engine, engine.getPlayer().isFacingLeft());
		engine.addEntity(shot);
	}
}
