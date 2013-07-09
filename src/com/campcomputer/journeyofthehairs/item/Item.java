package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.entity.Bullet;
import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class Item extends Entity {

    int ammoLeft;
    float bulletSpeed;
    int bulletNumber;   // Number of bullets fired.
    int fireRate;       // How many bullets fired per second.
    int damage;

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
        ammoLeft -= getBulletNumber();
    }

    public void shoot() {
        if (!(engine.getPlayer().getWeapon() instanceof GrenadeGun)) {
            Bullet bullet = new Bullet(engine);

            if (engine.getPlayer().isFacingLeft())
                bullet.frames = bullet.bulletLeft;
            else
                bullet.frames = bullet.bulletRight;

            bullet.setX(engine.getPlayer().getX());
            bullet.setY(engine.getPlayer().getY());
            engine.addEntity(bullet);
        }   else {

        }
    }

}
