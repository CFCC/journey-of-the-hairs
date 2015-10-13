package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.map.Cheese;

/**
 * The portal transports the user to a special cheese map wherein they can pick up a special weapon (Rail Gun)
 * that is capable of killing Chuck Norris
 */
public class Portal extends Pickup {
	public Portal(PhysicsEngine engine) {
		super(engine);
	}

	public void addImagesOfEntityToFrames() {
		frames = Images.ReadFrames("portal");
	}

	@Override
	public void affectGame() {
		Cheese cheese = new Cheese(getEngine());
		getEngine().setMap(cheese);
	}
}
