package com.campcomputer.journeyofthehairs.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.item.*;

public abstract class Ammo extends Item {
    public Item item;
    float bulletSpeed;  // Speed of the bullets
    int bulletNumber;   // Number of bullets fired.
    int fireRate;       // How many bullets fired per second.
    int damage;         // The damage of each bullet

    public Ammo(GameEngine engine) {
        super(engine);
    }


    public int getDamage() {
        return damage;
    }

    public int getFireRate() {
        return fireRate;
    }

    public int getBulletNumber() {
        return bulletNumber;
    }

    public float getBulletSpeed() {
        return bulletSpeed;
    }

    public void setBulletSpeed(int bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    public void setBulletNumber(int bulletNumber) {
        this.bulletNumber = bulletNumber;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
