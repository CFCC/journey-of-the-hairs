package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class RocketWorm extends Entity {
    protected List<BufferedImage> wormLeaveGround;
    protected List<BufferedImage> wormEnterGround;


    public RocketWorm(GameEngine engine) {
        super(engine);
		setHealth(10);
    }

    @Override
    public boolean isAffectedByGravity() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if (engine.isOnTopOfPlayer(this)) {
            emerge();
        } else if (engine.getDistanceBetweenEntityAndPlayer(this) < 5.0) {
			for (Entity entity  : engine.getEntities()) {
				if (entity instanceof Rocket) {
					return;
                }
			}
            shootrocket();
        }
    }

    @Override
    public void loadImages() {
        wormLeaveGround = loadFrames("wormLeaveGround");
        wormEnterGround = loadFrames("wormEnterGround");
        frames.add(Images.ReadImage(new File("frames/wormLeaveGround/00.png")));
    }

     @Override
    public void attack(Entity entity) {

    }

    public void emerge() {
        if (frames != wormLeaveGround) {
            frames = wormLeaveGround;
            currentFrame = 0;
        }
    }

    public void shootrocket() {
        Rocket rocket = new Rocket(engine);
        rocket.setX(getX());
        rocket.setY(getY()+1);
		engine.addEntity(rocket);

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
