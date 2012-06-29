package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.io.File;

public class SuicideStinkBug extends Entity {

    public int health = 25;

    public SuicideStinkBug(GameEngine engine) {
        super(engine);
    }

    @Override
    public void tick() {
        super.tick();

    }

    @Override
    public void loadImages() {
        frames.add(Images.ReadImage(new File("images/stinkbug.png")));
    }

    @Override
    public void attack(Entity entity) {

    }

    public void blowup() {

        engine.isPlayerClose(this);

        // explode within 5 tiles of player.
        // explosion has a 10 tile radius.
        // explosion does 3000 damage to itself and the player.
        // explosion will destroy any solid object in the way; expect ground
        // if there is a solid wall in the way, the bug can explode; will not affect the player.
    }

    public void chasesplayer1() {

        engine.isPlayerClose(this);

        // move towards player: engine.moveLeft() or engine.moveRight()
        // solid object is in the way.
    }
}