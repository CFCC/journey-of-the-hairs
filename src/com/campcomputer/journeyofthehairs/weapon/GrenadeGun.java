package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.shot.Grenade;

public class GrenadeGun extends Weapon {

	public GrenadeGun(PhysicsEngine engine) {
		super(engine, 10);
	}

	@Override public boolean shoot() {
		if (super.shoot()) {
			PhysicsEngine engine = getEngine();
			Grenade grenade = new Grenade(engine, engine.getPlayer().isFacingLeft());
			engine.addEntity(grenade);
		}
		return true;
	}
}
