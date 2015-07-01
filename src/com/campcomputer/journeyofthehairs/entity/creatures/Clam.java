package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.pickup.Pickup;
import com.campcomputer.journeyofthehairs.map.MapListener;

public class Clam extends Entity {
	/**
	 * Constructor
	 */
	public Clam(PhysicsEngine engine, Pickup pickup, MapListener mapListener) {
		super(engine, mapListener);
	}

	@Override
	protected void loadImages() {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
