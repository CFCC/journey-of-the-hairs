package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class Pickup extends Entity {
    public Pickup (GameEngine engine)  {
        super(engine);
    }

    public void tick() {
        for (Pickup pickup : engine.getPickups()) {
            if (engine.isOnTopOfPlayer(pickup))
                pickup.affectGame();
        }
    }

    public abstract void affectGame();
}
