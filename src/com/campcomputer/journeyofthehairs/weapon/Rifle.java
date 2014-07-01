package com.campcomputer.journeyofthehairs.weapon;

public class Rifle extends Weapon {

	public Rifle() {
		setShotType(WeaponShots.RIFLE_SHOT);
		addAmmo(10);
	}

	@Override
	public void shoot() {

	}
}
