package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.ammo.LaserBeam;
import com.campcomputer.journeyofthehairs.entity.pickup.Portal;
import com.campcomputer.journeyofthehairs.map.Map1;

public class Railgun extends Item {

    protected void loadImages() {
        frames.add(Images.ReadImage("images/railgun.png"));
    }

    public Railgun(GameEngine engine) {
        super(engine);
        setAmmoType(new LaserBeam(engine));
        setAffectedByGravity(false);
        addAmmo(1);
    }

    public void tick() {
        if (engine.getPlayer().getLocation().distance(this.getLocation()) < 1f) {
            engine.setMap(new Map1(engine));
            for (Entity entity : engine.entitiesToAdd) {
                if (entity instanceof Portal)
                    engine.removeEntity(entity);
            }
        }
    }
}
