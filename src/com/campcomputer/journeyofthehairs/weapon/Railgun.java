package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.shot.RailgunShot;

public class Railgun extends Weapon {

	public Railgun(PhysicsEngine engine) {
		super(engine, 1);
	}

	@Override
	public boolean shoot() {
		if (super.shoot()) {
			PhysicsEngine engine = getEngine();
			RailgunShot railgunShot = new RailgunShot(engine, engine.getPlayer().isFacingLeft());
			engine.addEntity(railgunShot);
		}
		return true;
	}
}
