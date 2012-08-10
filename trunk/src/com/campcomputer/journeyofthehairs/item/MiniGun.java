package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class MiniGun extends Item {

    float bulletSpeed = 1;
    int bulletNumber = 1;   // Number of bullets fired.
    int fireRate = 5;        // How many bullets fired per second.
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
        frames.add(Images.ReadImage("images/cheese.jpg"));
    }

    public void attack(Entity entity) {
    }

    public MiniGun(GameEngine engine) {
        super(engine);
    }
}
