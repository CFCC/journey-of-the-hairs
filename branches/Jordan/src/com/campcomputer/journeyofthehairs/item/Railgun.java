package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Railgun extends Item {

    float bulletSpeed = 9000f;
    int bulletNumber = 1;   // Number of bullets fired.
    int fireRate = 1;        // How many bullets fired per second.
    int damage = 9000;



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

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage("images/railgun.png"));
    }

    @Override
    public void attack(Entity entity) {
    }

    public Railgun(GameEngine engine) {
        super(engine);
    }
}
