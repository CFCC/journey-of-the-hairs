package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class RocketWorm extends Entity {
    protected List<BufferedImage> wormLeaveGround;
    protected List<BufferedImage> wormEnterGround;

    public int health = 75;
	public RocketWorm(GameEngine engine) {
		super(engine);
	}

	@Override
	public void tick() {
        super.tick();
        if (frames != wormLeaveGround && engine.isOnTopOfPlayer(this)){
            frames = wormLeaveGround;
            currentFrame = 0;
        }
    }

	@Override
	public void loadImages() {
        wormLeaveGround = loadFrames("wormLeaveGround");
        wormEnterGround = loadFrames("wormEnterGround");
    }

    @Override
	public void attack(Entity entity) {

	}

    public void shootrockets() {

		engine.isPlayerClose(this);


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
