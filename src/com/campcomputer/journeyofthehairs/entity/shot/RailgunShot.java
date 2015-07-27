package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;

public class RailgunShot extends Shot {

	public RailgunShot(PhysicsEngine engine) {
		super(engine);
		setAffectedByGravity(false);
		setX(engine.getPlayer().getX());
		setY(engine.getPlayer().getY());

		setDamage(9000);
		setBulletSpeed(0);
	}

	public void loadImages() {
		frames.add(Images.ReadImage("/images/entities/shots/railgun shot.png"));
	}

	public void tick() {
		if (engine.getPlayer().isFacingLeft() && getXVelocity() > 0) {
			setXVelocity(getBulletSpeed() * - 1);
		} else if (! (engine.getPlayer().isFacingLeft()) && getXVelocity() > 0) {
			setXVelocity(getBulletSpeed());
		}

		for (Entity entity : engine.getEntities()) {
			if (entity instanceof RailgunShot && (entity.getX() == this.getX() - 1 || entity.getX() == this.getX() + 1)) {
				setXVelocity(0);
			}
			if (getY() == entity.getY() && ! (entity instanceof Player)) {
				entity.takeDamage(entity);
			}
		}

		if (this.getX() > engine.getPlayer().getX() + 7 || this.getX() > engine.getMap().getTiles().length ||
		    this.getX() < engine.getPlayer().getX() - 8 || this.getX() < 0) {
			setXVelocity(0);
		}
		// engine.removeEntity(this);
	}
}