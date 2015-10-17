package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.weapon.Weapon;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
	/**
	 * This is the list inherited by every entity. It contains any image painted on the map that represents
	 * the particular entity. Any other image is ignored; this list is the only place checked for images
	 */
	protected List<BufferedImage> frames = new ArrayList<BufferedImage>();

	/**
	 * This is the current frame in the list of frames. It is only really used for entities using frames,
	 * but nonetheless, it is still needed.
	 */
	protected int currentFrame = 0;

	/**
	 * This is an entity's health - that is, how much damage they must receive before they
	 * are removed from the entity list and the game
	 */
	protected int health = 1;

	/**
	 * This is a variable used in determining which direction an entity is facing. It is useful in a few
	 * situations; usually, it decides which frame to paint on the map.
	 */
	private boolean isFacingLeft = true;

	/**
	 * This is the game engine instance. It is used as the super class for all entities since the two are
	 * (relatively) closely related with physics related methods and properties.
	 */
	private PhysicsEngine engine;

	private int maxHealth = 1;

	/**
	 * This is an entity's x coordinate (where they are horizontally on the map)
	 */
	private float x = 0;

	/**
	 * This is an entity's y coordinate (where they are vertically on the map)
	 */
	private float y = 0;

	/**
	 * This is an entity's x velocity. It is how quickly they are going horizontally. This amount, more
	 * specifically, is how far left or right they go each tick. The higher the absolute value of this number
	 * is, the faster the entity travels.
	 * <p/>
	 * A positive number signifies an entity traveling forwards on the map while a negative one
	 * signifies an entity traveling backwards. In either case, 0 signifies no movement
	 */
	private float xVelocity = 0;

	/**
	 * This is an entity's y velocity. It is how quickly they travel vertically. This number, more specifically,
	 * is how far they go up or down each tick. The higher the absolute value of this number, the faster the entity
	 * travels.
	 * <p/>
	 * A positive number signifies an entity traveling down (because in computers, the origin is in the upper left
	 * of the screen), or falling, while a negative number signifies an entity traveling upwards, or jumping/flying
	 */
	private float yVelocity = 0;

	/**
	 * Constructor for an entity. If it has no image assigned to the list frames, its image becomes cheese.png
	 */
	public Entity(PhysicsEngine engine, int maxHealth) {
		this.engine = engine;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		addImagesOfEntityToFrames();
		if (frames.size() == 0) {
			frames.add(Images.ReadImage("/images/cheese.png"));
		}
	}

	public PhysicsEngine getEngine() {
		return engine;
	}

	public void restoreHealth() {
		health = maxHealth;
	}

	/**
	 * @return x coordinate
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x new x coordinate for the entity
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return y coordinate
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y new y coordinate for the entity
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the entity's location in the form of a point (x, y)
	 */
	public Point2D getLocation() {
		return new Point2D.Float(x, y);
	}

	/**
	 * @return the entity's current health
	 */
	public int getHealth() {
		return health;
	}

	public void takeDamage(int damage) {
		health -= damage;
	}

	/**
	 * @return the entity's current x velocity
	 */
	public float getXVelocity() {
		return xVelocity;
	}

	/**
	 * @param xVel new x velocity for the entity
	 *             <p/>
	 *             TODO: Fix left vs right frame issue to eliminate override
	 */
	public void setXVelocity(float xVel) {
		this.xVelocity = xVel;
	}

	/**
	 * @return the entity's current y velocity
	 */
	public float getYVelocity() {
		return yVelocity;
	}

	/**
	 * @param yVelocity new y velocity for the entity
	 */
	public void setYVelocity(float yVelocity) {
		this.yVelocity = yVelocity;
	}

	/**
	 * @return an entity's height.
	 */
	public int getHeight() {
		return 1;
	}

	/**
	 * @return true if the entity is facing left, false if right
	 */
	public boolean isFacingLeft() {
		return isFacingLeft;
	}

	/**
	 * Simply inverts the isFacingLeft variable, effectively switching the console's impression of the entity's direction
	 */
	public void switchDirection() {
		isFacingLeft = ! isFacingLeft;
	}

	/**
	 * This is a method returning a boolean determining if the entity is affected by gravity. All creatures
	 * (except for the dragonfly) are, and all pickups and shots (except for grenades) aren't
	 */
	public boolean isAffectedByGravity() {
		/*
	  This is the variable used in testing to see if an entity is affected by gravity. It is only overridden
	  in rare cases, such as weapon shots and flying creatures.
	 */
		return true;
	}

	public boolean isOn(Entity entity) {
		Point2D.Float myPosition = new Point2D.Float(getX(), getY());
		Point2D.Float theirPosition = new Point2D.Float(entity.getX(), entity.getY());

		return myPosition.distance(theirPosition) < 2f;
	}

	/**
	 * Moves the entity left by taking away .15 from its xVelocity and switching its direction if need be.
	 */
	public void moveLeft() {
		setXVelocity(- 0.15f);
		if (! isFacingLeft()) {
			switchDirection();
		}
	}

	/**
	 * Moves the entity right by adding .15 to its xVelocity and switching its direction if need be.
	 */
	public void moveRight() {
		setXVelocity(0.15f);
		if (isFacingLeft()) {
			switchDirection();
		}
	}

	/**
	 * Moves the entity up by subtracting .2 from its yVelocity
	 */
	public void moveUp() {
		setYVelocity(- 0.2f);
	}

	/**
	 * Moves the entity down by adding .2 to its yVelocity
	 */
	public void moveDown() {
		setYVelocity(0.2f);
	}

	/**
	 * Not as fancy as it sounds. Abstract method called in entity constructor. Meant to assign images to frame field.
	 */
	abstract protected void addImagesOfEntityToFrames();

	/**
	 * Getter for an entity's frame(s)
	 *
	 * @return its frame list
	 */
	public List<BufferedImage> getFrames() {
		return frames;
	}

	/**
	 * On each tick, advances the frames in the list by one, or if the current frame is the last one, it goes back
	 * to the beginning. Also sets an entity's health to -1 (killing it) if it goes below the map.
	 * <p/>
	 * TODO: Get rid of OOB band-aid
	 */
	public void tick() {
		if (++ currentFrame > frames.size() - 1) {
			currentFrame = 0;
		}

		if (getY() > 12) {
			health = - 1;
		}
	}

	/**
	 * Getter for the current frame displayed on the map.
	 *
	 * @return an entity's current frame
	 */
	public BufferedImage getCurrentFrame() {
		return frames.get(currentFrame);
	}

	/**
	 * Boolean to determine if an entity is affected by things like walls, carrots, and tomatoes.
	 */
	public boolean isAffectedByHitDetection() {
		return true;
	}

	public boolean canBeAttacked() {
		return true;
	}

	/**
	 * Makes an entity take the appropriate amount of damage by getting the amount of bullets fired by the player's
	 * weapon and multiplying it by the damage of each bullet
	 */
	public void takeDamageFromPlayer() {
		Weapon weapon = engine.getPlayer().getWeapon();
		takeDamage(weapon.getShotType().getDamage() * weapon.getBulletNumber());
		if (getHealth() <= 0) {
			getEngine().removeEntity(this);
		}
	}
}
