package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;

public class DragonFly extends Entity {
	int flyingenergy;

	public DragonFly(GameEngine engine) {
		super(engine);
	}

    @Override
    protected void loadImages() {

    }

    public void attacks() {

		engine.isPlayerClose();

		// if the player is close,
		// 		fly towards it: engine.moveLeft() or engine.moveRight()
	}

	public void eats() {

	}

	public void chasePlayer1() {
		if (flyingenergy > 0) {
			// go towards the player,
			// solid object in the way
		}
	}

	public void tick() {
		if (engine.isPlayerAbove()) {
			//fly towards player: engine.moveRight or engine.moveLeft)
		}
	}
}