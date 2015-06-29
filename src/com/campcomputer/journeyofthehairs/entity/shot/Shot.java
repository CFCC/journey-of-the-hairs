package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Weapons;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.map.MapListener;

public abstract class Shot extends Entity implements Weapons {
	float bulletSpeed;  // Speed of the bullets
	int damage;         // The damage of each bullet

	public Shot(GameEngine engine, MapListener mapListener) {
		super(engine, mapListener);
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
