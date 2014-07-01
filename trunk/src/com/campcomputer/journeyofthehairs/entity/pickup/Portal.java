package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.map.Cheese;

import java.awt.geom.Point2D;

public class Portal extends Pickup {
	public void loadImages() {
		frames = Images.loadFrames("portal");
	}

	public Portal(GameEngine engine, Point2D location) {
		super(engine);
		setX((float) location.getX());
		setY((float) location.getY());
	}

	@Override
	public void affectGame() {
		Cheese cheese = new Cheese(engine, engine.getMap());
		getListener().setMap(cheese);
	}
}
