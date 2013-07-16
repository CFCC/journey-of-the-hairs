package com.campcomputer.journeyofthehairs.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.ChuckNorris;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.Player;

public class LaserBeam extends Ammo {
    private int ticksLeft;

    public LaserBeam(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
        setX(engine.getPlayer().getX());
        setY(engine.getPlayer().getY());
        ticksLeft = 2;

        setDamage(ChuckNorris.MAX_HEALTH);
        setFireRate(1);
        setBulletNumber(1);
        setBulletSpeed(1000);
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
                if (entity instanceof ChuckNorris && engine.getChuckNorris().isOnTopOfEntity(this))
                    takeDamage(entity);

            }
            ticksLeft--;
        } else
            engine.removeEntity(this);
    }
}