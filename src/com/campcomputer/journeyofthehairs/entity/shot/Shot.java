package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class Shot extends Entity {
	final private float bulletSpeed;  // Speed of the bullets

	final private int damage;         // The damage of each bullet

	public Shot(PhysicsEngine engine, boolean startsLeft, float speed, int damage) {
		super(engine);
		this.bulletSpeed = speed;
		this.damage = damage;

		setX(engine.getPlayer().getX());
		setY(engine.getPlayer().getY());

		setXVelocity(startsLeft ? - getBulletSpeed() : getBulletSpeed());
	}

	public void tick() {
		for (Entity entity : getEngine().getEntities()) {
			if (this.isOn(entity)) {
				entity.setHealth(entity.getHealth() - getDamage());
				getEngine().removeEntity(this);
			}
		}
	}

	public int getDamage() {
		return damage;
	}

	public float getBulletSpeed() {
		return bulletSpeed;
	}

	@Override
	public boolean isAffectedByGravity() {
		return false;
	}
}
