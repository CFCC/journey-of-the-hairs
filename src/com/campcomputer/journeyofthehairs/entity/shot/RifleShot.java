package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;

public class RifleShot extends Shot {
	public RifleShot(PhysicsEngine engine) {
		super(engine);
		setDamage(1);
		setBulletSpeed(2);
	}

	public void addImagesOfEntityToFrames() {
		frames.add(Images.ReadImage("/images/entities/shots/rifle shot.png"));
	}
}
