package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

/**
 * The urchin exists only in the ocean. It floats around randomly, and if it happens to run into the user, it
 * causes minor damage and disappears
 */
public class Urchin extends Entity {
	/**
	 * Constructor
	 */
	public Urchin(PhysicsEngine engine) {
		super(engine, 1);
	}

	@Override
	protected void addImagesOfEntityToFrames() {

	}
}
