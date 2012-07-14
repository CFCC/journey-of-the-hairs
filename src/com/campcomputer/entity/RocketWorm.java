package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class RocketWorm extends Entity {

	protected List<BufferedImage> standing;
	protected List<BufferedImage> wormLeaveGround;
	protected List<BufferedImage> wormEnterGround;


    public RocketWorm(GameEngine engine) {
        super(engine);
		setHealth(2);
    }

	public int getHeight() {
		return 2;
	}

	@Override
    public void tick() {
        super.tick();
		if (frames == wormLeaveGround && currentFrame == wormLeaveGround.size() - 1) {
			currentFrame = 0;
			frames = wormEnterGround;
		}
		if (frames == wormEnterGround && currentFrame == wormEnterGround.size() - 1) {
			currentFrame = 0;
			frames = standing;
		}

        if (engine.isOnTopOfPlayer(this)) {
            emerge();
        } else if (engine.getDistanceBetweenEntityAndPlayer(this) < 5.0 && canBeAttacked()) {
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
        wormLeaveGround = Images.loadFrames("wormLeaveGround");
        wormEnterGround = Images.loadFrames("wormEnterGround");
		standing = new ArrayList<BufferedImage>(1);
		standing.add(wormLeaveGround.get(0));
        frames = standing;
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
    }

    public void tunneling() {
    }

	public boolean canBeAttacked() {
		return frames != standing;
	}
}
