package com.campcomputer.journeyofthehairs.weapon;

public class Pistol extends Weapon {

    public Pistol() {
        setShotType(WeaponShots.BULLET);
        addAmmo(100);
    }

    @Override
    public void shoot() {

    }
}
