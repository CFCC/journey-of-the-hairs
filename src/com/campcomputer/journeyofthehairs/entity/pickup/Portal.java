package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.map.Cheese;
import com.campcomputer.journeyofthehairs.map.MapListener;

public class Portal extends Pickup {
	public Portal(GameEngine engine, MapListener mapListener) {
		super(engine, mapListener);
	}

	public void loadImages() {
		frames = Images.loadFrames("portal");
	}

	@Override
	public void affectGame() {
		Cheese cheese = new Cheese(engine, engine.getMap(), getMapListener());
		getMapListener().setMap(cheese);
	}
}
