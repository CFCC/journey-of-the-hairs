package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.WeaponShots;

public class Railgun extends Weapon {

    public Railgun() {
        setShotType(WeaponShots.RAILGUN_SHOT);
        addAmmo(1);
    }

    @Override
    public void shoot() {

    }
}
