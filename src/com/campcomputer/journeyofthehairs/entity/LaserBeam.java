package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.item.Railgun;

public class LaserBeam extends Railgun {
    private int ticksLeft;

    public LaserBeam(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
        setX(engine.getPlayer().getX());
        setY(engine.getPlayer().getY());
        ticksLeft = 2;
    }

    public void loadImages() {
        frames.add(Images.ReadImage("images/laser beam.png"));
    }

    public void tick() {
        if (ticksLeft > 0) {
            if (engine.getPlayer().isFacingLeft())
                setXVel(getBulletSpeed() * -1);
            else
                setXVel(getBulletSpeed());

            for (Entity entity : engine.getEntities()) {
                if (getY() == entity.getY() && !(entity instanceof Player))
                    entity.takeDamage(entity);
                if (entity instanceof ChuckNorris) {
                    for (int height = ChuckNorris.HEIGHT; height > 0; height--) {
                        if (engine.getChuckNorris().getY() - height == getY())
                            takeDamage(entity);
                    }
                }
            }
            ticksLeft--;
        } else
            engine.removeEntity(this);
    }
}
