package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.entity.weapon.WeaponShots;
import com.campcomputer.journeyofthehairs.map.Tile;

public abstract class Shot extends Entity {
	final private float bulletSpeed;  // Speed of the bullets

	final private int damage;         // The damage of each bullet

	public Shot(PhysicsEngine engine, boolean startsLeft, WeaponShots type) {
		super(engine);
		this.bulletSpeed = type.getBulletSpeed();
		this.damage = type.getDamage();

		setX(engine.getPlayer().getX());
		setY(engine.getPlayer().getY());

		setXVelocity(startsLeft ? - getBulletSpeed() : getBulletSpeed());
	}

	public void tick() {
		for (Entity entity : getEngine().getEntities()) {
			if (this.isOn(entity) && ! (entity instanceof Player)) {
				entity.setHealth(entity.getHealth() - getDamage());
				getEngine().removeEntity(this);

			}
		}
		if (getEngine().getMap().getTiles()[(int) getX()][(int) getY()] != Tile.AIR) {
			getEngine().removeEntity(this);
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
