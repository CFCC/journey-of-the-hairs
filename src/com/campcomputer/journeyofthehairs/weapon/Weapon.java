package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.Weapons;

public abstract class Weapon implements Weapons {

	/**
	 * This is a boolean for determining if a weapon can fire or not. Of course, this refers to its ability
	 * to fire at a given moment. Every weapon can fire, but every weapon has a cool down time after firing,
	 * so this field is linked with ticksTillFire
	 */
	boolean canFire;
	/**
	 * This is the amount of ammo left in the weapon currently active. The term 'ammo' is
	 * a bit ambiguous when referring to ammo in this class vs the pickup ammo vs the entity
	 * shots. Weapons as a pickup and ammo here are essentially the same in that they are just
	 * numbers. Shots are fired entities. Comparable to persons vs people; persons refers
	 * to bodies as numbers and people refers to individuals.
	 */
	private int ammoLeft;
	/**
	 * This is the shot type fired by the active weapon. It is a value of the enum WeaponShots (again,
	 * shots vs ammo can be a bit confusing, but this uses shots since it refers to what is fired, not
	 * what is loaded into the weapon) that determines which type of shot to add to the map.
	 */
	private WeaponShots shotType;
	/**
	 * This field only applies to a weapon if it was just fired since every weapon has a cooldown rate. It is
	 * determined by dividing the fire rate by 1000 (the amount of milliseconds in a second)
	 * <p/>
	 * TODO: Link the amount of milliseconds in a tick to this variable
	 */
	private int ticksTillFire;

	/**
	 * This is the amount of bullets fired at once. It is usually 1, but in some cases, like the rifle, many
	 * projectiles are fired at once, requiring the use of this field.
	 */
	private int bulletNumber;

	/**
	 * This is the amount of projectiles fired from the weapon every second.
	 */
	private int fireRate;

	/**
	 * @return the fire rate of the active weapon
	 */
	public int getFireRate() {
		return fireRate;
	}

	/**
	 * Sets the fire rate for the weapon parametrically
	 *
	 * @param fireRate the new fire rate
	 */
	public void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}

	/**
	 * @return the bullet number of the active weapon
	 */
	public int getBulletNumber() {
		return bulletNumber;
	}

	/**
	 * Sets the bullet number for the weapon parametrically
	 *
	 * @param bulletNumber the new bullet number
	 */
	public void setBulletNumber(int bulletNumber) {
		this.bulletNumber = bulletNumber;
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
	public void resetTicksTillFire() {
		ticksTillFire = 1000 / getFireRate();
	}

	/**
	 * Lowers the amounts of ticks until a weapon can fire by 1. If there are no more ticks until
	 * the weapon can fire, the boolean saying it can fire is updated  appropriately
	 */
	public void lowerTicksTillFire() {
		ticksTillFire--;
		if (ticksTillFire == 0) {
			canFire = true;
		}
	}

	/**
	 * @return a value from WeaponShots enum that corresponds to the weapon
	 */
	public WeaponShots getShotType() {
		return shotType;
	}

	/**
	 * Sets the shot type for the active weapon parametrically
	 *
	 * @param shot the shot type to set for the weapon
	 */
	public void setShotType(WeaponShots shot) {
		shotType = shot;
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
	}

	/**
	 * Abstract method for the weapon to shoot since they all might have different ways of shooting
	 */
	public abstract void shoot();
}
