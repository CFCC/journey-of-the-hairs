package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

import java.util.ArrayList;

public abstract class Pickup extends Entity {

	public Pickup(PhysicsEngine engine) {
		super(engine, 9000);
	}

	public abstract void affectGame();

	@Override public boolean isAffectedByGravity() {
		return false;
	}

	public void tick() {
		ArrayList<Pickup> pickups = new ArrayList<Pickup>();
		for (Entity entity : getEngine().getEntities()) {
			if (entity instanceof Pickup) {
				pickups.add((Pickup) entity);
			}
		}
		for (Pickup pickup : pickups) {
			if (getEngine().isOnTopOfPlayer(pickup)) {
				pickup.affectGame();
				getEngine().removeEntity(pickup);
			}
		}

		restoreHealth();
	}
}
