package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.pickup.Pickup;
import com.campcomputer.journeyofthehairs.map.MapListener;

/**
 * The clam is an entity that generates objects for the user. Its behavior is as follows:
 * <p/>
 * Half of the time, the clam is closed, generating a new object. In this time, it takes up 1 square tile,
 * and the user can stand on it.
 * <p/>
 * The other half, it is open. It does not take up any space, and the user cannot jump on it. However, there is
 * a random object that is in its location. The clam does not shut faster if the user grabs the object sooner.
 * If the user never grabs the object, it disappears when the clam closes.
 */
public class Clam extends Entity {
	/**
	 * Constructor
	 */
	public Clam(PhysicsEngine engine, Pickup pickup, MapListener mapListener) {
		super(engine, mapListener);
	}

	@Override
	protected void loadImages() {

	}
}
