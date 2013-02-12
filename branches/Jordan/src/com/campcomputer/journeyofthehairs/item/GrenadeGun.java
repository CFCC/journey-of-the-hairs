package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;

public class GrenadeGun extends Item {

    float bulletSpeed = 1;
    int bulletNumber = 1;   // Number of bullets fired.
    int fireRate = 1;        // How many bullets fired per second.
    int damage = 15;



    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getFireRate() {
        return fireRate;
    }

    @Override
    public int getBulletNumber() {
        return bulletNumber;
    }

    @Override
    public float getBulletSpeed() {
        return bulletSpeed;
    }

    public GrenadeGun(GameEngine engine) {
        super(engine);
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage("images/grenadeLauncher.png"));
    }

    public void attack(Entity entity) {
    }
}
