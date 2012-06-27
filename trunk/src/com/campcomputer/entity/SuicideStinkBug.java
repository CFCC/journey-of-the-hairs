package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;

public class SuicideStinkBug extends Entity {

	public SuicideStinkBug(GameEngine engine) {
		super(engine);
}

	public void blowup() {

		engine.isPlayerClose();

		// explode within 5 tiles of player.
		// explosion has a 10 tile radius.
		// explosion does 100 damage.
		// explosion will destroy any solid object in the way; expect ground
		// if there is a solid wall in the way, the bug can explode; will not affect the player.
	}

	public void chasesplayer1() {

		engine.isPlayerClose();

		// move towards player: engine.moveLeft() or engine.moveRight()
		// solid object is in the way.
	}

}