package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.item.Item;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
	private int health = 1;
	private int attackDamage = 10;

	private float x = 0;
	private float y = 0;

	private float xVel = 0;
	private float yVel = 0;

	private boolean affectedByGravity = true;
	private boolean facingRight = true;

	protected GameEngine engine;
	protected List<BufferedImage> frames = new ArrayList<BufferedImage>();
	protected int currentFrame = 0;
    Item item;

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

	public float getxVel() {
		return xVel;
	}

	public void setxVel(float xVel) {
		this.xVel = xVel;
	}

	public float getyVel() {
		return yVel;
	}

	public void setyVel(float yVel) {
		this.yVel = yVel;
	}

	public int getHeight() {
		return 1;
	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public void setEngine(GameEngine engine) {
		this.engine = engine;
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
		setxVel(-0.1f);
		setyVel(0);
	}

	public void moveRight() {
		setxVel(0.1f);
		setyVel(0);
	}

	public void moveUp() {
		setxVel(0);
		setyVel(0.1f);
	}

	public void moveDown() {
		setxVel(0);
		setyVel(-0.1f);
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
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

	abstract public void attack(Entity entity);

	public BufferedImage getCurrentFrame() {
		return frames.get(currentFrame);
	}

	public boolean attacked() {
		setHealth(health -= (item.getDamage()*item.getBulletNumber()));
		return health > 0;
	}
	public boolean isAffectedByHitDetection() {
		return true;
	}
	public boolean canBeAttacked() {
		return true;
	}

    public void userInfoBar() {
        frames.add(Images.ReadImage("images/userInfoBar.png"));

    }
}
