package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.PhysicsEngine;

/**
 * The current only exists in the ocean. On the spaces it occupies, it sweeps Hair in the direction it flows.
 * Hair can escape, but it is difficult.
 */
public class Current extends Entity {
	/**
	 * Constructor
	 */
	public Current(PhysicsEngine engine) {
		super(engine, 1);
	}

	@Override
	protected void addImagesOfEntityToFrames() {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
