package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.shot.Rocket;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a rocket worm. As the name would suggest, it is a worm that shoots rockets at the player.
 * It lives in the ground and emerges to shoot a rocket when the player is near it
 */
public class RocketWorm extends Entity {

	/**
	 * This is the frame for when the worm is simply standing underground. It is the first frame
	 * of the next list of frames.
	 */
	private List<BufferedImage> standing;

	/**
	 * This is the list of frames for when the worm is near the player and emerges from the ground
	 */
	private List<BufferedImage> wormLeaveGround;

	/**
	 * Once the worm has shot its rocket, it uses these frames to go back underground
	 */
	private List<BufferedImage> wormEnterGround;

	/**
	 * Constructor
	 */
	public RocketWorm(PhysicsEngine engine) {
		super(engine);
		setHealth(2);
	}

	/**
	 * Override method. The worm is a bit taller than most entities at 2 tiles.
	 *
	 * @return the height, 2
	 */
	public int getHeight() {
		return 2;
	}

	/**
	 * Checks to see if frames need to be switched, also checks to see if the worm needs to shoot a rocket
	 */
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
			for (Entity entity : engine.getEntities()) {
				if (entity instanceof Rocket) {
					return;
				}
			}
			shootRocket();
		}

	}

	/**
	 * self explanatory
	 */
	@Override
	public void addImagesOfEntityToFrames() {
		wormLeaveGround = Images.ReadFrames("wormLeaveGround");
		wormEnterGround = Images.ReadFrames("wormEnterGround");
		standing = new ArrayList<BufferedImage>(1);
		standing.add(wormLeaveGround.get(0));
		frames = standing;
	}

	/**
	 * sets the frames to the worm leaving the ground if it isn't already
	 */
	public void emerge() {
		if (frames != wormLeaveGround) {
			frames = wormLeaveGround;
			currentFrame = 0;
		}
	}

	/**
	 * Creates a new rocket and sets its location right above the worm
	 */
	public void shootRocket() {
		Rocket rocket = new Rocket(engine);
		rocket.setX(getX());
		rocket.setY(getY() + 1);
		engine.addEntity(rocket);
	}

	/**
	 * The worm can only be attacked above ground. Override method
	 */
	public boolean canBeAttacked() {
		return frames != standing;
	}
}
