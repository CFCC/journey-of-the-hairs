package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;

public class DragonFly extends Entity {
	int flyingenergy;

	public DragonFly(GameEngine engine) {
		super(engine);
		setAffectedByGravity(false);
	}

	@Override
	protected void tick() {
		if (engine.isPlayerAbove(this)) {
			moveUp();
		} else if (engine.isPlayerBelow(this)) {
			moveDown();
		} else if (engine.isPlayerClose(this)) {
			attack();
			//Try to dodge solid objects.....
		} else {

		}
	}

	@Override
	protected void loadImages() {

	}

	public void attack() {

	}

	public void eats() {

	}


	public void breathfire() {
		Player player = engine.getPlayer();
		player.setHealth(player.getHealth() - getAttackDamage());
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