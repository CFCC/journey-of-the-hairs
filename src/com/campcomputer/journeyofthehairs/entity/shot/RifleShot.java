package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.weapon.WeaponShots;

public class RifleShot extends Shot {
	public RifleShot(PhysicsEngine engine, boolean startsLeft) {
		super(engine, startsLeft, WeaponShots.RIFLE_SHOT);
	}

	public void addImagesOfEntityToFrames() {
		frames.add(Images.ReadImage("/images/entities/shots/rifle shot.png"));
	}
}
