package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Rifle extends Item {

    float bulletSpeed = 3f;
    int bulletNumber = 20;   // Number of bullets fired.
    int fireRate = 1;        // How many bullets fired per second.
    int damage = 1;



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
    frames.add(Images.ReadImage("images/rifle.png"));
}
    public void attack(Entity entity) {
    }

    public Rifle(GameEngine engine) {
        super(engine);
    }
}
