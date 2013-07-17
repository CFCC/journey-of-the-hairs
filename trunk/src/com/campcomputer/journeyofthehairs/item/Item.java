package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.JourneyOfTheHairsFrame;
import com.campcomputer.journeyofthehairs.ammo.*;
import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class Item extends Entity {

    int ammoLeft;       // How much ammo is left
    Ammo ammoType;
    boolean canFire;
    int ticksTillFire;
    boolean isShooting;

    public int getTicksTillFire() {
        return ticksTillFire;
    }

    public void resetTicksTillFire() {
        ticksTillFire = getAmmoType().getFireRate() / JourneyOfTheHairsFrame.timerTick;
    }

    public void lowerTicksTillFire() {
        ticksTillFire--;
        if (ticksTillFire == 0)
            canFire = true;
    }

    public Item(GameEngine engine) {
        super(engine);
    }

    public Ammo getAmmoType() {
        return ammoType;
    }

    public void setAmmoType(Ammo ammo) {
        ammoType = ammo;
    }

    public boolean canBeAttacked() {
        return false;
    }

    public int getAmmo() {
        return ammoLeft;
    }

    public void subtractAmmo() {
        ammoLeft -= getAmmoType().getBulletNumber();
    }

    public void addAmmo(int ammo) {
        ammoLeft += ammo;
    }

//    public void shoot() {
//        if (getAmmo() > 0 && canFire && isShooting) {
//            if (!(engine.getPlayer().getWeapon() instanceof GrenadeGun) && !(engine.getPlayer().getWeapon() instanceof Railgun)) {
//                Bullet bullet = new Bullet(engine);
//
//                if (engine.getPlayer().isFacingLeft())
//                    bullet.frames = bullet.bulletLeft;
//                else
//                    bullet.frames = bullet.bulletRight;
//
//                bullet.setX(engine.getPlayer().getX());
//                bullet.setY(engine.getPlayer().getY());
//                engine.addEntity(bullet);
//            } else if (engine.getPlayer().getWeapon() instanceof GrenadeGun) {
//                Grenade grenade = new Grenade(engine);
//
//                grenade.setX(engine.getPlayer().getX());
//                grenade.setY(engine.getPlayer().getY());
//                engine.addEntity(grenade);
//            } else if (engine.getPlayer().getWeapon() instanceof Railgun) {
//                LaserBeam laserBeam = new LaserBeam(engine);
//                laserBeam.setY(engine.getPlayer().getY());
//                engine.addEntity(laserBeam);
//            }
//            subtractAmmo();
//        }
//    }

    public void shoot() {
        Item weapon = engine.getPlayer().getWeapon();
        if (isShooting && canFire) {
            if (weapon instanceof Pistol || weapon instanceof MiniGun) {
                Bullet bullet = new Bullet(engine);
                bullet.setX(engine.getPlayer().getX());
                bullet.setY(engine.getPlayer().getY());
            } else if (weapon instanceof GrenadeGun) {
                Grenade grenade = new Grenade(engine);
                grenade.setX(engine.getPlayer().getX());
                grenade.setY(engine.getPlayer().getY());
            } else if (weapon instanceof Railgun) {
                LaserBeam laserBeam = new LaserBeam(engine);
            } else if (weapon instanceof Rifle) {
                RifleShot rifleShot = new RifleShot(engine);
                rifleShot.setX(engine.getPlayer().getX());
                rifleShot.setY(engine.getPlayer().getY());
            } else if (weapon instanceof Shotgun) {
                ShotgunBullet shotgunBullet = new ShotgunBullet(engine);
                shotgunBullet.setX(engine.getPlayer().getX());
                shotgunBullet.setY(engine.getPlayer().getY());
            }
            resetTicksTillFire();
        } else if (isShooting && !canFire) {
            lowerTicksTillFire();
        }
    }

    public void toggleShoot() {
        isShooting = !isShooting;
    }

    public void tick() {
        shoot();
    }
}
