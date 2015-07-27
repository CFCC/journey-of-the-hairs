package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.PhysicsEngine;

/**
 * A rare random drop, the user will not take any damage and kill enemies on contact if they pick
 * up invincibility
 */
public class Invincibility extends Pickup {
	public Invincibility(PhysicsEngine engine) {
		super(engine);
	}

	@Override
	public void affectGame() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	protected void addImagesOfEntityToFrames() {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
