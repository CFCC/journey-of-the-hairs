package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.entity.Bullet;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.Grenade;
import com.campcomputer.journeyofthehairs.entity.LaserBeam;

public abstract class Item extends Entity {

    int ammoLeft;       // How much ammo is left
    float bulletSpeed;  // Speed of the bullets
    int bulletNumber;   // Number of bullets fired.
    int fireRate;       // How many bullets fired per second.
    int damage;         // The damage of each bullet

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

    public void addAmmo(int ammo) {
        ammoLeft += ammo;
    }

    public void shoot() {
        if (getAmmo() > 0) {
            if (!(engine.getPlayer().getWeapon() instanceof GrenadeGun) && !(engine.getPlayer().getWeapon() instanceof Railgun)) {
                Bullet bullet = new Bullet(engine);

                if (engine.getPlayer().isFacingLeft())
                    bullet.frames = bullet.bulletLeft;
                else
                    bullet.frames = bullet.bulletRight;

                bullet.setX(engine.getPlayer().getX());
                bullet.setY(engine.getPlayer().getY());
                engine.addEntity(bullet);
            } else if (engine.getPlayer().getWeapon() instanceof GrenadeGun) {
                Grenade grenade = new Grenade(engine);

                grenade.setX(engine.getPlayer().getX());
                grenade.setY(engine.getPlayer().getY());
                engine.addEntity(grenade);
            } else if (engine.getPlayer().getWeapon() instanceof Railgun) {
                LaserBeam laserBeam = new LaserBeam(engine);
                laserBeam.setY(engine.getPlayer().getY());
                engine.addEntity(laserBeam);
            }
        }
        subtractAmmo();
    }

}
