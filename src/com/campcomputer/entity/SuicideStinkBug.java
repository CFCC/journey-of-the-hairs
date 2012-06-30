package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.io.File;

public class SuicideStinkBug extends Entity {

	private static final int EXPLODE_RANGE = 2;
	private static final int EXPLODE_DAMAGE = 10;


    public SuicideStinkBug(GameEngine engine) {
        super(engine);
		setHealth(3);
    }

    @Override
    public void tick() {
        super.tick();

		if (engine.getPlayer().getX() < getX()) {
			moveLeft();
		} else if (engine.getPlayer().getX() > getX()) {
			moveRight();
		} else if (engine.getDistanceBetweenEntityAndPlayer(this) < EXPLODE_RANGE) {
			blowup();
		}
    }

    @Override
    public void loadImages() {
        frames.add(Images.ReadImage(new File("images/stinkbug.png")));
    }

    @Override
    public void attack(Entity entity) {

    }


	/**
	 explode within 5 tiles of player.
	 explosion has a 10 tile radius.
	 explosion does 3000 damage to itself and the player.
	 explosion will destroy any solid object in the way; expect ground
	 if there is a solid wall in the way, the bug can explode; will not affect the player.
	**/
    public void blowup() {
		engine.getPlayer().setHealth(engine.getPlayer().getHealth() - EXPLODE_DAMAGE);
		engine.removeEntity(this);
    }

}