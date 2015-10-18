package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.shot.WeaponShots;

/**
 * Each weapon
 */
public abstract class Weapon {
	/**
	 * This is the shot type fired by the active weapon. It is a value of the enum WeaponShots (again,
	 * shots vs ammo can be a bit confusing, but this uses shots since it refers to what is fired, not
	 * what is loaded into the weapon) that determines which type of shot to add to the map.
	 */
	final private WeaponShots shotType;

	final private Weapons weaponType;

	/**
	 * This is the amount of bullets fired at once. It is usually 1, but in some cases, like the rifle, many
	 * projectiles are fired at once, requiring the use of this field.
	 */
	final private int bulletNumber;

	/**
	 * This is the amount of projectiles fired from the weapon every second.
	 */
	final private int fireRate;

	private PhysicsEngine engine;

	/**
	 * This is the amount of ammo left in the weapon currently active. The term 'ammo' is
	 * a bit ambiguous when referring to ammo in this class vs the pickup ammo vs the entity
	 * shots. Weapons as a pickup and ammo here are essentially the same in that they are just
	 * numbers. Shots are fired entities. Comparable to persons vs people; persons refers
	 * to bodies as numbers and people refers to individuals.
	 */
	private int ammoLeft;

	/**
	 * This field only applies to a weapon if it was just fired since every weapon has a cooldown rate. It is
	 * determined by dividing the fire rate by 1000 (the amount of milliseconds in a second)
	 * <p/>
	 * TODO: Link the amount of milliseconds in a tick to this variable
	 */
	private int ticksTillFire;

	public Weapon(PhysicsEngine engine, int initialAmmo) {
		this.engine = engine;
		this.weaponType = com.campcomputer.journeyofthehairs.weapon.Weapons.get(this);

		this.fireRate = weaponType.getFireRate();
		this.bulletNumber = weaponType.getBulletNumber();
		resetTicksTillFire();
		this.shotType = weaponType.getShotType();
		this.ammoLeft = initialAmmo;
	}

	public PhysicsEngine getEngine() {
		return engine;
	}

	public Weapons getWeaponType() {
		return weaponType;
	}

	public void tick() {
		lowerTicksTillFire();
	}

	/**
	 * @return the fire rate of the active weapon
	 */
	public int getFireRate() {
		return fireRate;
	}

	/**
	 * @return the bullet number of the active weapon
	 */
	public int getBulletNumber() {
		return bulletNumber;
	}

	/**
	 * @return the amount of ticks until the weapon can fire
	 */
	public int getTicksTillFire() {
		return ticksTillFire;
	}

	/**
	 * Resets the amount of ticks until the weapon cooldown period ends.
	 */
	private void resetTicksTillFire() {
		ticksTillFire = 1000 / getFireRate();
	}

	/**
	 * Lowers the amounts of ticks until a weapon can fire by 1. If there are no more ticks until
	 * the weapon can fire, the boolean saying it can fire is updated  appropriately
	 */
	public void lowerTicksTillFire() {
		if (ticksTillFire > 0) {
			ticksTillFire--;
		}
	}

	private boolean canFire() {
		return getTicksTillFire() <= 0;
	}

	/**
	 * @return a value from WeaponShots enum that corresponds to the weapon
	 */
	public WeaponShots getShotType() {
		return shotType;
	}

	/**
	 * @return the amount of ammo left in the active weapon
	 */
	public int getAmmo() {
		return ammoLeft;
	}

	/**
	 * Subtracts the bullet number (amount of projectiles fired at one time) from the ammo left
	 */
	public void subtractAmmo() {
		ammoLeft -= getBulletNumber();
	}

	/**
	 * Adds an amount of ammo specified parametrically
	 *
	 * @param ammo the amount of ammo to add
	 */
	public void addAmmo(int ammo) {
		ammoLeft += ammo;
		resetTicksTillFire();
	}

	/**
	 * Abstract method for the weapon to shoot since they all might have different ways of shooting
	 */
	public boolean shoot() {
		if (! canFire() || getAmmo() <= 0) {
			return false;
		}

		subtractAmmo();
		resetTicksTillFire();
		return true;
	}

	@Override
	public String toString() {
		if (this instanceof GrenadeGun) {
			return "Grenade Gun";
		} else if (this instanceof MiniGun) {
			return "Mini Gun";
		} else if (this instanceof Pistol) {
			return "Pistol";
		} else if (this instanceof Railgun) {
			return "Railgun";
		} else if (this instanceof Rifle) {
			return "Rifle";
		} else { // if (this instanceof Shotgun)
			return "Shotgun";
		}
	}
}
