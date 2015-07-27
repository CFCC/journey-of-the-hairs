package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

/**
 * The squid only exists in the ocean. If the user gets too close, the squid inks. The ink turns a random
 * set amount of pixels to a dark blue color, and every once in a while, it causes minor damage to the player
 */
public class Squid extends Entity {
	/**
	 * Constructor
	 */
	public Squid(PhysicsEngine engine) {
		super(engine);
	}

	@Override
	protected void addImagesOfEntityToFrames() {

	}
}
