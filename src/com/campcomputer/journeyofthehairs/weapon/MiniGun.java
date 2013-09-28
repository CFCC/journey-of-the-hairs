package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.WeaponShots;

public class MiniGun extends Weapon {

    public MiniGun() {
        setShotType(WeaponShots.BULLET);
        addAmmo(150);
    }

    @Override
    public void shoot() {

    }
}
