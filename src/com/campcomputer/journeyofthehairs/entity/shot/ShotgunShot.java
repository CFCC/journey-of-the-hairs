package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.map.MapListener;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ShotgunShot extends Shot {
	public List<BufferedImage> bulletsLeft;

	public List<BufferedImage> bulletsRight;

	public ShotgunShot(PhysicsEngine engine, MapListener mapListener) {
		super(engine, mapListener);
		setDamage(1);
		setBulletSpeed(3);
	}

	public void loadImages() {
		bulletsLeft = new ArrayList<BufferedImage>();
		bulletsRight = new ArrayList<BufferedImage>();

		bulletsLeft.add(Images.ReadImage("entities/shots/shotgun shot left"));
		bulletsRight.add(Images.ReadImage("entities/shots/shotgun shot right"));
	}
}
