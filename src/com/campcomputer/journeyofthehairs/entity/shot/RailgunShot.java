package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.weapon.WeaponShots;

public class RailgunShot extends Shot {

	public RailgunShot(PhysicsEngine engine, boolean startsLeft) {
		super(engine, startsLeft, WeaponShots.RAILGUN_SHOT);
		setX(getEngine().getPlayer().getX());
		setY(getEngine().getPlayer().getY());
	}

	public void addImagesOfEntityToFrames() {
		frames.add(Images.ReadImage("/images/entities/shots/railgun shot.png"));
	}

	public void tick() {
		if (getEngine().getPlayer().isFacingLeft() && getXVelocity() > 0) {
			setXVelocity(getBulletSpeed() * - 1);
		} else if (! (getEngine().getPlayer().isFacingLeft()) && getXVelocity() > 0) {
			setXVelocity(getBulletSpeed());
		}

		for (Entity entity : getEngine().getEntities()) {
			if (entity instanceof RailgunShot && (entity.getX() == this.getX() - 1 || entity.getX() == this.getX() + 1)) {
				setXVelocity(0);
			}
			if (getY() == entity.getY() && ! (entity instanceof Player)) {
				entity.takeDamageFromPlayer();
			}
		}

		if (this.getX() > getEngine().getPlayer().getX() + 7 || this.getX() > getEngine().getMap().getTiles().length ||
		    this.getX() < getEngine().getPlayer().getX() - 8 || this.getX() < 0) {
			setXVelocity(0);
		}
		// getEngine().removeEntity(this);
	}
}