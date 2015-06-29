package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.map.MapListener;
import com.campcomputer.journeyofthehairs.weapon.Weapon;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
	/**
	 * This is a variable used in determining which direction an entity is facing. It is useful in a few
	 * situations; usually, it decides which frame to paint on the map.
	 */
	public boolean facingLeft = true;
	/**
	 * This is the list inherited by every entity. It contains any image painted on the map that represents
	 * the particular entity. Any other image is ignored; this list is the only place checked for images
	 */
	public List<BufferedImage> frames = new ArrayList<BufferedImage>();
	/**
	 * This is the game engine instance. It is used as the super class for all entities since the two are
	 * (relatively) closely related with physics related methods and properties.
	 */
	protected GameEngine engine;
	/**
	 * This is the current frame in the list of frames. It is only really used for entities using frames,
	 * but nonetheless, it is still needed.
	 */
	protected int currentFrame = 0;
	/**
	 * This is an entity's health - that is, how much damage they must receive before they
	 * are removed from the entity list and the game
	 */
	private int health = 1;
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
	private float xVel = 0;
	/**
	 * This is an entity's y velocity. It is how quickly they travel vertically. This number, more specifically,
	 * is how far they go up or down each tick. The higher the absolute value of this number, the faster the entity
	 * travels.
	 * <p/>
	 * A positive number signifies an entity traveling down (because in computers, the origin is in the upper left
	 * of the screen), or falling, while a negative number signifies an entity traveling upwards, or jumping/flying
	 */
	private float yVel = 0;
	/**
	 * This is the variable used in testing to see if an entity is affected by gravity. It is only overridden
	 * in rare cases, such as weapon shots and flying creatures.
	 */
	private boolean affectedByGravity = true;
	private MapListener listener;

	/**
	 * Constructor for an entity. If it has no image assigned to the list frames, its image becomes cheese.png
	 */
	public Entity(GameEngine engine, MapListener mapListener) {
		this.listener = mapListener;
		this.engine = engine;
		loadImages();
		if (frames.size() == 0) {
			frames.add(Images.ReadImage("cheese"));
		}
	}

	public MapListener getMapListener() {
		return listener;
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

	/**
	 * @param health the entity's new health. Usually used in tandem with getHealth to subtract or add
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the entity's current x velocity
	 */
	public float getXVel() {
		return xVel;
	}

	/**
	 * @param xVel new x velocity for the entity
	 *             <p/>
	 *             TODO: Fix left vs right frame issue to eliminate override
	 */
	public void setXVel(float xVel) {
		this.xVel = xVel;
	}

	/**
	 * @return the entity's current y velocity
	 */
	public float getYVel() {
		return yVel;
	}

	/**
	 * @param yVel new y velocity for the entity
	 */
	public void setYVel(float yVel) {
		this.yVel = yVel;
	}

	/**
	 * @return an entity's height. This method's only reason for existence is for overrides in tests
	 */
	public int getHeight() {
		return 1;
	}

	/**
	 * @return true if the entity is facing left, false if right
	 */
	public boolean isFacingLeft() {
		return facingLeft;
	}

	/**
	 * Simply inverts the facingLeft variable, effectively switching the console's impression of the entity's direction
	 */
	public void switchDirection() {
		facingLeft = ! facingLeft;
	}

	/**
	 * This is a method returning a boolean determining if the entity is affected by gravity. All creatures
	 * (except for the dragonfly) are, and all pickups and shots (except for grenades) aren't
	 */
	public boolean isAffectedByGravity() {
		return affectedByGravity;
	}

	/**
	 * Sets the variable affectedByGravity as mentioned above to true or false. Usually used to set to false so
	 * no override is necessary
	 */
	public void setAffectedByGravity(boolean affectedByGravity) {
		this.affectedByGravity = affectedByGravity;
	}

	/**
	 * Moves the entity left by taking away .1 from its xVel, setting its yVel to 0, and switching its direction
	 * if need be.
	 */
	public void moveLeft() {
		setXVel(getXVel() - 0.1f);
		setYVel(0);
		if (! isFacingLeft()) {
			switchDirection();
		}
	}

	/**
	 * Moves the entity right by adding .1 to its xVel, setting its yVel to 0, and switching its direction
	 * if need be.
	 */
	public void moveRight() {
		setXVel(getXVel() + 0.1f);
		setYVel(0);
		if (isFacingLeft()) {
			switchDirection();
		}
	}

	/**
	 * Moves the entity up by setting its xVel to 0, and subtracting .3 from its yVel
	 */
	public void moveUp() {
		setYVel(getYVel() - 0.3f);
		setY(getY() - getYVel());
	}

	/**
	 * Moves the entity down by setting its xVel to 0, and adding .3 to its yVel
	 */
	public void moveDown() {
		setYVel(getYVel() + 0.3f);
		setY(getY() + getYVel());
	}

	/**
	 * Not as fancy as it sounds. Abstract method called in entity constructor. Meant to assign images to frame field.
	 */
	abstract protected void loadImages();

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
		currentFrame++;
		if (currentFrame > frames.size() - 1) {
			currentFrame = 0;
		}

		if (getY() > 12) {
			setHealth(- 1);
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
	 *
	 * @param entity the entity to take damage
	 */
	public void takeDamage(Entity entity) {
		Weapon weapon = engine.getPlayer().getWeapon();
		entity.setHealth(entity.getHealth() - (weapon.getShotType().getDamage() * weapon.getBulletNumber()));
	}
}
