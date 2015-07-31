package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.weapon.WeaponShots;

public class Ink extends Shot {
	public Ink(PhysicsEngine engine) {
		//TODO
		super(engine, true, WeaponShots.BULLET);
	}

	@Override
	protected void addImagesOfEntityToFrames() {

	}
}
