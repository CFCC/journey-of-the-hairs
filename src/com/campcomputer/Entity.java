package com.campcomputer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    private float x = 0;
    private float y = 0;
    private int health = 100;

    private float xVel = 0;
    private float yVel = 0;

	private boolean affectedByGravity = true;
	private boolean facingRight = true;

    protected GameEngine engine;
    protected List<BufferedImage> frames = new ArrayList<BufferedImage>();

    public Entity(GameEngine engine) {
        this.engine = engine;
        loadImages();
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

	public boolean isFacingRight() {
		return facingRight;
	}

	public boolean isFacingLeft() {
		return !facingRight;
	}

	public boolean isAffectedByGravity() {
		return affectedByGravity;
	}

    abstract protected void loadImages();
}
