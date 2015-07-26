package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.map.MapListener;

public class SuicideStinkBug extends Entity {

	/**
	 * This is the range that specifies how far away entities have to be for the bug to explode (the
	 * suicide in suicide stink bug)
	 */
	private static final int EXPLODE_RANGE = 1;

	/**
	 * This is how much damage is caused to the first entity to come within the explode range
	 * of the bug. It is not a lot, but it's enough to be annoying
	 */
	private static final int EXPLODE_DAMAGE = 10;

	/**
	 * Constructor for the bug
	 */
	public SuicideStinkBug(PhysicsEngine engine, MapListener mapListener) {
		super(engine, mapListener);
		setHealth(3);
	}

	/**
	 * Acts as an attack method for the bug.
	 * If the player goes within 5 tiles of the bug on the X axis, it will begin to move.
	 * If the distance between the two then becomes less than the constant for the explosion
	 * range, it explodes.
	 */
	@Override
	public void tick() {
		super.tick();

		if (engine.getDistanceBetweenEntityAndPlayer(this) < EXPLODE_RANGE) {
			blowup();
		}

		if (engine.getPlayer().getX() < getX() && getX() - engine.getPlayer().getX() <= 5) {
			moveLeft();
		} else if (engine.getPlayer().getX() > getX() && engine.getPlayer().getX() - getX() <= 5) {
			moveRight();
		}
	}

	/**
	 * Self explanatory
	 */
	@Override
	public void loadImages() {
		frames.add(Images.ReadImage("/images/entities/creatures/stinkbug.png"));
	}

	/**
	 * The bug explodes within 1 tile of the player.
	 * The explosion radius is 1 tile
	 * The damage dealt is 10
	 */
	public void blowup() {
		engine.getPlayer().setHealth(engine.getPlayer().getHealth() - EXPLODE_DAMAGE);
		engine.removeEntity(this);
	}

}