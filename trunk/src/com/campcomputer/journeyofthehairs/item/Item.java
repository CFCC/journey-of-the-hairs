package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.ammo.*;
import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class Item extends Entity {

    int ammoLeft;       // How much ammo is left
    Ammo ammoType;

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
