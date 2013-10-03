package com.campcomputer.journeyofthehairs.weapon;

public class GrenadeGun extends Weapon {

    public GrenadeGun() {
        setShotType(WeaponShots.GRENADE);
        addAmmo(10);
    }

    @Override
    public void shoot() {

    }
}
