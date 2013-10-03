package com.campcomputer.journeyofthehairs.weapon;

public class Shotgun extends Weapon {

    public Shotgun() {
        setShotType(WeaponShots.SHOTGUN_SHOT);
        addAmmo(10);
    }

    @Override
    public void shoot() {

    }
}
