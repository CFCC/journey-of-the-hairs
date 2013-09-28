package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.WeaponShots;

public class Rifle extends Weapon {

    public Rifle() {
        setShotType(WeaponShots.RIFLE_SHOT);
        addAmmo(10);
    }

    @Override
    public void shoot() {

    }
}
