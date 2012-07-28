package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class SuicideStinkBug extends Entity {

    private static final int EXPLODE_RANGE = 1;
    private static final int EXPLODE_DAMAGE = 10;
    Player player;


    public SuicideStinkBug(GameEngine engine) {
        super(engine);
        setHealth(3);
    }

    @Override
    public void tick() {
        super.tick();

        if (engine.getDistanceBetweenTwoEntities(this, player) < EXPLODE_RANGE)
            blowup();
        if (engine.getPlayer().getX() < getX() && getX() - engine.getPlayer().getX() <= 5)
            moveLeft();
        else if (engine.getPlayer().getX() > getX() && engine.getPlayer().getX() - getX() <= 5)
            moveRight();
    }

    @Override
    public void loadImages() {
        frames.add(Images.ReadImage("images/stinkbug.png"));
    }

    @Override
    public void attack(Entity entity) {

    }


    /**
     * explode within 5 tiles of player.
     * explosion has a 10 tile radius.
     * explosion does 3000 damage to itself and the player.
     * explosion will destroy any solid object in the way; expect ground
     * if there is a solid wall in the way, the bug can explode; will not affect the player.
     */
    public void blowup() {
        engine.getPlayer().setHealth(engine.getPlayer().getHealth() - EXPLODE_DAMAGE);
        engine.removeEntity(this);
    }

}