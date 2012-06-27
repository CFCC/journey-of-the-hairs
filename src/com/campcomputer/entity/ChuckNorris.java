package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;

public class ChuckNorris extends Entity {

	public ChuckNorris(GameEngine engine) {
		super(engine);


	}

	public void tick() {
		if (engine.isPlayerClose()) {
			// walk/jog/run towards the player: engine.moveRight() or engine.moveLeft()
			engine.moveForward();
		}
	}

	public void attacks(){

	}

	public void punches(){

	}

	public void roudhousekick(){

	}

	public void lasereyes(){
		//if player is within sight, the lasers will hit him.
	}

	public void armor() {

	}

	public void healing() {

	}
}