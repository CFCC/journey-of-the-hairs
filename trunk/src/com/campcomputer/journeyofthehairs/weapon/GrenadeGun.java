package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.WeaponShots;

public class GrenadeGun extends Weapon {

    public GrenadeGun() {
        setShotType(WeaponShots.GRENADE);
        addAmmo(10);
    }

    @Override
    public void shoot() {

    }
}
