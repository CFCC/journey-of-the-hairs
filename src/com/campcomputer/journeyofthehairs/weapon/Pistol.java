package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.shot.Bullet;

public class Pistol extends Weapon {

	public Pistol(PhysicsEngine engine) {
		super(engine, 100);
	}

	@Override
	protected void addImagesOfEntityToFrames() {

	}

	@Override
	public boolean shoot() {
		if (super.shoot()) {
			PhysicsEngine engine = getEngine();

			Bullet bullet = new Bullet(engine, engine.getPlayer().isFacingLeft());
			engine.addEntity(bullet);
		}
		return true;
	}
}
