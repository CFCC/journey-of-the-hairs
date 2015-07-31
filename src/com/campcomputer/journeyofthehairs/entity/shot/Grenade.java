package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.entity.weapon.Weapon;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Grenade extends Shot {
	public List<BufferedImage> stasisFrames;

	public List<BufferedImage> explosionFrames;

	private int timeLeft = 1000;

	public Grenade(PhysicsEngine engine, boolean startsLeft) {
		super(engine, startsLeft, 1, Weapon.WeaponShots.GRENADE.getDamage());
	}

	@Override
	public boolean isAffectedByGravity() {
		return true;
	}

	@Override
	public void addImagesOfEntityToFrames() {
		stasisFrames = new ArrayList<BufferedImage>();
		explosionFrames = new ArrayList<BufferedImage>();

		stasisFrames.add(Images.ReadImage("/images/entities/shots/grenade stasis.png"));
		explosionFrames.add(Images.ReadImage("/images/entities/shots/grenade explosion.png"));
	}

	public void tick() {
		if (timeLeft > 0) {
			timeLeft--;
		} else {

			for (Entity entity : getEngine().getEntities()) {
				if (! (entity instanceof Player)) {
					double distance = getLocation().distance(entity.getLocation());
					if (distance < Weapon.GRENADE_TIER_1_RANGE) {
						entity.setHealth(entity.getHealth() - Weapon.GRENADE_TIER_1_DAMAGE);
					} else if (distance < Weapon.GRENADE_TIER_2_RANGE) {
						entity.setHealth(entity.getHealth() - Weapon.GRENADE_TIER_2_DAMAGE);
					}
				}
			}
			getEngine().removeEntity(this);
		}

	}
}
