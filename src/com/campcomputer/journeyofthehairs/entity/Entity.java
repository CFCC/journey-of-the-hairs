package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
	private int health = 1;

	private float x = 0;
	private float y = 0;

	private float xVel = 0;
	private float yVel = 0;

	private boolean affectedByGravity = true;
	private boolean facingRight = true;

	protected GameEngine engine;
	protected List<BufferedImage> frames = new ArrayList<BufferedImage>();
	protected int currentFrame = 0;

	public Entity(GameEngine engine) {
		this.engine = engine;
		loadImages();
		if (frames.size() == 0)
			frames.add(Images.ReadImage("images/Cheese.jpg"));
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getXVel() {
		return xVel;
	}

	public void setXVel(float xVel) {
		this.xVel = xVel;
	}

	public float getYVel() {
		return yVel;
	}

	public void setYVel(float yVel) {
		this.yVel = yVel;
	}

	public int getHeight() {
		return 1;
	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public boolean isFacingLeft() {
		return !facingRight;
	}

	public boolean isAffectedByGravity() {
		return affectedByGravity;
	}

	public void setAffectedByGravity(boolean affectedByGravity) {
		this.affectedByGravity = affectedByGravity;
	}

	public void moveLeft() {
		setXVel(-0.1f);
		setYVel(0);
	}

	public void moveRight() {
		setXVel(0.1f);
		setYVel(0);
	}

	public void moveUp() {
        setYVel(getYVel() + 0.3f);
        setY(getY() - getYVel());
	}

	public void moveDown() {
        setYVel(getYVel() + 0.3f);
        setY(getY() + getYVel());
	}

	abstract protected void loadImages();

	public List<BufferedImage> getFrames() {
		return frames;
	}

	public void tick() {
		currentFrame++;
		if (currentFrame > frames.size() - 1)
			currentFrame = 0;

	}

    public BufferedImage getCurrentFrame() {
		return frames.get(currentFrame);
	}

	public boolean attacked() {
		setHealth(health -= 10);
		return health > 0;
	}
	public boolean isAffectedByHitDetection() {
		return true;
	}
	public boolean canBeAttacked() {
		return true;
	}
}
