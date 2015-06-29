package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.map.MapListener;

public class RifleShot extends Shot {
	public RifleShot(GameEngine engine, MapListener mapListener) {
		super(engine, mapListener);
		setDamage(1);
		setBulletSpeed(2);
	}

	public void loadImages() {
		frames.add(Images.ReadImage("entities/shots/rifle shot"));
	}
}
