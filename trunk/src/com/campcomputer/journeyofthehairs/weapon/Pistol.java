package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.WeaponShots;

public class Pistol extends Weapon {

    public Pistol() {
        setShotType(WeaponShots.BULLET);
        addAmmo(100);
    }

    @Override
    public void shoot() {

    }
}
