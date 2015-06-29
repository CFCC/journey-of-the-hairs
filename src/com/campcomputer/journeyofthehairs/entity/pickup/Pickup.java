package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.map.MapListener;

import java.util.ArrayList;

public abstract class Pickup extends Entity {

	public Pickup(GameEngine engine, MapListener listener) {
		super(engine, listener);
	}

	public void tick() {
		ArrayList<Pickup> pickups = new ArrayList<Pickup>();
		for (Entity entity : engine.getEntities()) {
			if (entity instanceof Pickup) {
				pickups.add((Pickup) entity);
			}
		}
		for (Pickup pickup : pickups) {
			if (engine.isOnTopOfPlayer(pickup)) {
				pickup.affectGame();
				engine.removeEntity(pickup);
			}
		}

		currentFrame++;
		if (currentFrame > frames.size() - 1) {
			currentFrame = 0;
		}
	}

	public abstract void affectGame();
}
