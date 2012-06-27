package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;

public class RocketWorm extends Entity {
	public RocketWorm(GameEngine engine) {
		super(engine);
	}

    @Override
    protected void loadImages() {

    }

    public void shootrockets() {

		engine.isPlayerClose();


		// when player is 20 tiles away, worm will surface
		// come out of ground and engine.moveLeft or engine.moveRight.
		// shoot rockets from mouth with target lock.
		// reload: 2 seconds.
		// shoot only from above ground.
		// rockets cannot destroy a wall.
		// if a wall is in the way, the worm will dig under the wall.
	}

	public void tunneling() {
		// move underground in areas
		// can surface to shoot
	}
}