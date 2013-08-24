package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class MinigunAmmo extends Pickup {
    private int amount;

    public MinigunAmmo (GameEngine engine, int amount) {
        super(engine);
        this.amount = amount;
    }

    public void loadImages() {
        frames.add(Images.ReadImage("images/bullet ammo.png"));
    }

    @Override
    public void affectGame() {
        engine.getPlayer().getWeapon().addAmmo(amount);
    }
}
