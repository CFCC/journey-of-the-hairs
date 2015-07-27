package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.PhysicsEngine;

/**
 * Armor helps protect the player. It is a random drop. When equipped by the user, it decreases the amount of
 * damage they take. There are different tiers of armor - each helps protect the user a little more.
 * <p/>
 * The 3 tiers are 25%, 50%, and 75%
 */
public class Armor extends Pickup {
	public Armor(PhysicsEngine engine) {
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
