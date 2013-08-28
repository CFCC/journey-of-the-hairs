package com.campcomputer.journeyofthehairs.entity.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.creatures.ChuckNorris;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;

public class LaserBeam extends Ammo {

    public LaserBeam(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
        setX(engine.getPlayer().getX());
        setY(engine.getPlayer().getY());

        setDamage(ChuckNorris.MAX_HEALTH);
        setFireRate(1);
        setBulletNumber(1);
        setBulletSpeed(1);
    }

    public void loadImages() {
        frames.add(Images.ReadImage("images/laser beam.png"));
    }

    public void tick() {
            if (engine.getPlayer().isFacingLeft())
                setXVel(getBulletSpeed() * -1);
            else
                setXVel(getBulletSpeed());

            for (Entity entity : engine.getEntities()) {
                if (entity instanceof LaserBeam && (entity.getX() == this.getX() - 1 || entity.getX() == this.getX() + 1))
                    setXVel(0);
            }

            if (this.getX() > engine.getPlayer().getX() + 7 || this.getX() > engine.getMap().length ||
                    this.getX() < engine.getPlayer().getX() - 8 || this.getX() < 0)
                setXVel(0);

            for (Entity entity : engine.getEntities()) {
                if (getY() == entity.getY() && !(entity instanceof Player))
                    entity.takeDamage(entity);
            }
        // engine.removeEntity(this);
    }
}