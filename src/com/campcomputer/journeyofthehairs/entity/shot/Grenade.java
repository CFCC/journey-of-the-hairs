package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.Weapons;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.map.MapListener;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Grenade extends Shot {
	public List<BufferedImage> stasisFrames;
	public List<BufferedImage> explosionFrames;

	private int timeLeft = 1000;

	public Grenade(GameEngine engine, MapListener mapListener) {
		super(engine, mapListener);
		setBulletSpeed(1);
	}

	@Override
	public void loadImages() {
		stasisFrames = new ArrayList<BufferedImage>();
		explosionFrames = new ArrayList<BufferedImage>();

		stasisFrames.add(Images.ReadImage("entities/shots/grenade stasis"));
		explosionFrames.add(Images.ReadImage("entities/shots/grenade explosion"));
	}

	public void tick() {
		if (timeLeft > 0) {
			timeLeft--;
		} else {

			for (Entity entity : engine.getEntities()) {
				if (! (entity instanceof Player)) {
					double distance = getLocation().distance(entity.getLocation());
					if (distance < Weapons.GrenadeTier1Range) {
						entity.setHealth(entity.getHealth() - Weapons.GrenadeTier1Damage);
					} else if (distance < Weapons.GrenadeTier2Range) {
						entity.setHealth(entity.getHealth() - Weapons.GrenadeTier2Damage);
					}
				}
			}
			engine.removeEntity(this);
		}

	}
}
