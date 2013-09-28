package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Ammo;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class Shot extends Entity implements Ammo {
    float bulletSpeed;  // Speed of the bullets
    int damage;         // The damage of each bullet

    public Shot(GameEngine engine) {
        super(engine);
    }

    public int getDamage() {
        return damage;
    }

    public float getBulletSpeed() {
        return bulletSpeed;
    }

    public void setBulletSpeed(int bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
