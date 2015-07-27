package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.Weapons;
import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class Shot extends Entity implements Weapons {
	float bulletSpeed;  // Speed of the bullets

	int damage;         // The damage of each bullet

	public Shot(PhysicsEngine engine) {
		super(engine);
		setAffectedByGravity(false);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public float getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}

}
