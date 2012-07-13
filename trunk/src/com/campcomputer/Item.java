package com.campcomputer;

import java.util.ArrayList;

public abstract class Item extends Entity {
    private ArrayList<Tile> items = new ArrayList<Tile>();

    public void addItems() {
        items.add(Tile.PISTOL);
        items.add(Tile.GRENADEGUN);
        items.add(Tile.MINIGUN);
        items.add(Tile.RAILGUN);
        items.add(Tile.RIFLE);
        items.add(Tile.SHOTGUN);
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
