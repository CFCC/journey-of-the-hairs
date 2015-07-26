package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.map.MapListener;

/**
 * Speed is a random drop that temporarily increases the user's speed by a set amount
 */
public class Speed extends Pickup {
	public Speed(PhysicsEngine engine, MapListener mapListener) {
		super(engine, mapListener);
	}

	@Override
	public void affectGame() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	protected void loadImages() {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
