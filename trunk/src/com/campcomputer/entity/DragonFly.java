package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;

public class DragonFly extends Entity {
	int flyingenergy;
	int breathfiredamage = 33;
	int eatsdamage = 2;

	public DragonFly(GameEngine engine) {
		super(engine);
		setAffectedByGravity(false);
		setHealth(70);
	}

	@Override
	public void tick() {
        super.tick();
		if (engine.isPlayerAbove(this)) {
			moveUp();
		} else if (engine.isPlayerBelow(this)) {
			moveDown();
		} else if (engine.isPlayerClose(this)) {
			attack(engine.getPlayer());
			//Try to dodge solid objects.....or else!
		} else {

		}
	}

	@Override
	protected void loadImages() {

	}

    @Override
    public void attack(Entity entity) {

    }

	/**
	 * Attempts to eat the entity. Since the DragonFlies are small, it doesn't do a lot of damage to a player, but the
	 * dragonfly gains health from eating.
	 *
	 * @param entity the thing to eat
	 */
    public void eats(Entity entity) {
		// make the enemy lose health
		entity.setHealth(entity.getHealth() - this.eatsdamage);

		if (entity.getHealth() <= 0) {
		// makes the dragonfly gain health
		setHealth(getHealth() + eatsdamage * 1/2);
		}
	}


	/**
	 * Breathe fire onto the given entity, usually a player. Instantly does a bunch of damage to it.
	 * @param entity the thing to breathe fire on.
	 */
	public void breathfire(Entity entity) {
		entity.setHealth(entity.getHealth() - this.breathfiredamage);
	}

	public void chasePlayer1() {
		if (flyingenergy > 0) {
			// fly towards the player,
			// solid object in the way
		}
		if (flyingenergy < 0) {
			//walk towards the player,
			// can also jump.
		}
	}
}