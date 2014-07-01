package com.campcomputer.journeyofthehairs.weapon;

public class MiniGun extends Weapon {

	public MiniGun() {
		setShotType(WeaponShots.BULLET);
		addAmmo(150);
	}

	@Override
	public void shoot() {

	}
}
