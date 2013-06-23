package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class Item extends Entity {

    int ammoLeft = 100;
    float bulletSpeed = 1f;
    int bulletNumber = 1;   // Number of bullets fired.
    int fireRate = 1;       // How many bullets fired per second.
    int damage = 1;

    public Item(GameEngine engine) {
        super(engine);
    }

    public boolean canBeAttacked() {
        return false;
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

    public int getAmmo() {
        return ammoLeft;
    }

    public void subtractAmmo() {
        ammoLeft -= bulletNumber;
    }

}
