package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Pistol extends Item {

    float bulletSpeed = 1;
    int bulletNumber = 1;   // Number of bullets fired.
    int fireRate = 1;        // How many bullets fired per second.
    int damage = 1;


    public void loadImages() {
        frames.add(Images.ReadImage("images/pistol.png"));
    }

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
    public void attack(Entity entity) {
    }

    public Pistol(GameEngine engine) {
        super(engine);
    }
}
