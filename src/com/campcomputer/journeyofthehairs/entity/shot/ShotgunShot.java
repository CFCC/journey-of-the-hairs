package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.weapon.WeaponShots;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ShotgunShot extends Shot {
	public List<BufferedImage> bulletsLeft;

	public List<BufferedImage> bulletsRight;

	public ShotgunShot(PhysicsEngine engine, boolean startsLeft) {
		super(engine, startsLeft, WeaponShots.SHOTGUN_SHOT);
	}

	public void addImagesOfEntityToFrames() {
		bulletsLeft = new ArrayList<BufferedImage>();
		bulletsRight = new ArrayList<BufferedImage>();

		bulletsLeft.add(Images.ReadImage("/images/entities/shots/shotgun shot left.png"));
		bulletsRight.add(Images.ReadImage("/images/entities/shots/shotgun shot right.png"));
	}
}
