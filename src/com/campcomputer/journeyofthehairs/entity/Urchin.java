package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.PhysicsEngine;

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

	@Override protected void addImagesOfEntityToFrames() {

	}
}
