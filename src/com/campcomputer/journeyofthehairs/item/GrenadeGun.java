package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class GrenadeGun extends Item {

    Item item;
    float x;
    float y;

    public void main(String[] args) {
        item.setDamage(1);
        item.setFireRate(1);
        item.setBulletNumber(1);
        item.setBulletSpeed(1f);
        item.setItemX(x);
        item.setItemY(y);
    }

    protected void loadImages() {
        frames.add(Images.ReadImage("images/grenadeLauncher.png"));
    }

    @Override
    public void attack(Entity entity) {
    }

    public GrenadeGun(GameEngine engine) {
        super(engine);
    }
}
