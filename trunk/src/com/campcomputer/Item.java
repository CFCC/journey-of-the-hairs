package com.campcomputer;

import java.util.ArrayList;

public abstract class Item extends Entity {
    private ArrayList<Entity> items = new ArrayList<Entity>();
    int ammoLeft;
    float bulletSpeed = 1f;
    int bulletNumber = 1;   // Number of bullets fired.
    int fireRate = 1;       // How many bullets fired per second.
    int damage = 1;

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

    public int getAmmo(){
        return ammoLeft;
    }

    public Item(GameEngine engine) {
        super(engine);
    }
}
