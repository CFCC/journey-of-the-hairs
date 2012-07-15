package com.campcomputer;

import java.util.ArrayList;

public abstract class Item extends Entity {
    private ArrayList<Entity> items = new ArrayList<Entity>();

    public void addItems() {

    }

    public int getDamage() {
        int damage = 1;
        return damage;
    }

    public int getFireRate() {
        // How many bullets fired per second or something.
        int fireRate = 1;
        return fireRate;
    }

    public int getBulletNumber() {
        // Number of bullets fired.
        int bulletNumber = 1;
        return bulletNumber;
    }

    public float getBulletSpeed(){
         // Speed of bullets.
        float bulletSpeed = 1f;
        return bulletSpeed;
    }


    public Item(GameEngine engine) {
        super(engine);
    }
}
