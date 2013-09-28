package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.WeaponShots;

public class Shotgun extends Weapon {

    public Shotgun() {
        setShotType(WeaponShots.SHOTGUN_SHOT);
        addAmmo(10);
    }

    @Override
    public void shoot() {

    }
}
