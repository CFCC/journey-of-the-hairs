package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class RifleAmmo extends Pickup {
    private int amount;

    public RifleAmmo(GameEngine engine, int amount) {
        super(engine);
        this.amount = amount;
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage("images/rifle ammo.png"));
    }

    @Override
    public void affectGame() {
        engine.getPlayer().getWeapon().addAmmo(amount);
    }
}
