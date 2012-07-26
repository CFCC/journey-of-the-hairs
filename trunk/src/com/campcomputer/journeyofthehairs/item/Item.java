package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class Item extends Entity {

    int ammoLeft;
    float bulletSpeed;
    int bulletNumber;   // Number of bullets fired.
    int fireRate;       // How many bullets fired per second.
    int damage;
    private static float x;
    private static float y;

    public int setDamage(int x) {
        damage = x;
        return damage;
    }

    public int setFireRate (int x) {
        fireRate = x;
        return fireRate;
    }

    public int setBulletNumber (int x) {
        bulletNumber = x;
        return bulletNumber;
    }

    public float setBulletSpeed (float x) {
        bulletSpeed = x;
        return bulletSpeed;
    }

    public static float setItemX(float X) {
        x = X;
        return x;
    }

    public static float setItemY(float Y) {
        y = Y;
        return y;
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

    public float getBulletSpeed(){
        return bulletSpeed;
    }

    public int setAmmo(int ammo) {
        ammoLeft = ammo;
        return ammoLeft;
    }

    public int getAmmo(){
        return ammoLeft;
    }

    public void subtractAmmo(){
        ammoLeft -= 1;
    }

    public Item(GameEngine engine) {
        super(engine);
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }
}
