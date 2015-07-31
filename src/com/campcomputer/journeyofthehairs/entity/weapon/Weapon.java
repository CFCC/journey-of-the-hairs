package com.campcomputer.journeyofthehairs.entity.weapon;

import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

/**
 * Each weapon
 */
public abstract class Weapon extends Entity {
	public static final int GRENADE_TIER_1_DAMAGE = 5;

	public static final int GRENADE_TIER_2_DAMAGE = 2;

	public static final int GRENADE_TIER_1_RANGE = 1;

	public static final int GRENADE_TIER_2_RANGE = 2;

	private static final int GRENADE_SPEED = 1;

	private static final int BULLET_DAMAGE = 1;

	private static final int BULLET_SPEED = 1;

	private static final int RAILGUN_SHOT_DAMAGE = 9000;

	private static final int RAILGUN_SHOT_SPEED = 0;

	private static final int RIFLE_SHOT_DAMAGE = 1;

	private static final int RIFLE_SHOT_SPEED = 2;

	private static final int SHOTGUN_SHOT_DAMAGE = 1;

	private static final int SHOTGUN_SHOT_SPEED = 3;

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
		super(engine);
		this.weaponType = Weapons.get(this);

		this.fireRate = weaponType.getFireRate();
		this.bulletNumber = weaponType.getBulletNumber();
		resetTicksTillFire();
		this.shotType = weaponType.getShotType();
		this.ammoLeft = initialAmmo;
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
	public void shoot() {
		if (! canFire()) {
			return;
		}

		subtractAmmo();
		resetTicksTillFire();
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

	/**
	 * This is the interface with data of the different ammunition. It is implemented to have a link between fields in
	 * the classes extending shot and the enumeration for the shot types (since an enum can't extend shot)
	 * <p/>
	 * There are 2 fields pertaining to the shots; the rest belong to the weapon.
	 * <p/>
	 * Damage is the amount of health subtracted from the entity affected when it is hit.
	 * Speed is how fast the shot travels.
	 * <p/>
	 * Even though there are 6 weapons, there are only 5 shot types; the pistol and minigun both fire bullets. The
	 * difference is that a minigun fires them much faster.
	 */

	public enum WeaponShots {
		SHOTGUN_SHOT {
			@Override
			public int getDamage() {
				return SHOTGUN_SHOT_DAMAGE;
			}

			@Override
			public int getBulletSpeed() {
				return SHOTGUN_SHOT_SPEED;
			}
		}, RIFLE_SHOT {
			@Override
			public int getDamage() {
				return RIFLE_SHOT_DAMAGE;
			}

			@Override
			public int getBulletSpeed() {
				return RIFLE_SHOT_SPEED;
			}
		}, RAILGUN_SHOT {
			@Override
			public int getDamage() {
				return RAILGUN_SHOT_DAMAGE;
			}

			@Override
			public int getBulletSpeed() {
				return RAILGUN_SHOT_SPEED;
			}
		}, GRENADE {
			/**
			 * Pseudo code.
			 *
			 * TODO: Getters need to be overridden in the case of grenades
			 */
			@Override
			public int getDamage() {
				return 0;
			}

			public int getTier1Damage() {
				return GRENADE_TIER_1_DAMAGE;
			}

			public int getTier2Damage() {
				return GRENADE_TIER_2_DAMAGE;
			}

			@Override
			public int getBulletSpeed() {
				return GRENADE_SPEED;
			}
		}, BULLET {
			@Override
			public int getDamage() {
				return BULLET_DAMAGE;
			}

			@Override
			public int getBulletSpeed() {
				return BULLET_SPEED;
			}
		};

		public abstract int getDamage();

		public abstract int getBulletSpeed();
	}

	public enum Weapons {
		PISTOL {
			@Override
			public WeaponShots getShotType() {
				return WeaponShots.BULLET;
			}

			@Override
			public int getBulletNumber() {
				return 1;
			}

			@Override
			public int getFireRate() {
				return 1;
			}
		}, SHOTGUN {
			@Override
			public WeaponShots getShotType() {
				return WeaponShots.SHOTGUN_SHOT;
			}

			@Override
			public int getBulletNumber() {
				return 1;
			}

			@Override
			public int getFireRate() {
				return 1;
			}
		}, RIFLE {
			@Override
			public WeaponShots getShotType() {
				return WeaponShots.RIFLE_SHOT;
			}

			@Override
			public int getBulletNumber() {
				return 1;
			}

			@Override
			public int getFireRate() {
				return 1;
			}
		}, MINIGUN {
			@Override
			public WeaponShots getShotType() {
				return WeaponShots.BULLET;
			}

			@Override
			public int getBulletNumber() {
				return 1;
			}

			@Override
			public int getFireRate() {
				return 1;
			}
		}, RAILGUN {
			@Override
			public WeaponShots getShotType() {
				return WeaponShots.RAILGUN_SHOT;
			}

			@Override
			public int getBulletNumber() {
				return 1;
			}

			@Override
			public int getFireRate() {
				return 1;
			}
		}, GRENADE_GUN {
			@Override
			public WeaponShots getShotType() {
				return WeaponShots.GRENADE;
			}

			@Override
			public int getBulletNumber() {
				return 1;
			}

			@Override
			public int getFireRate() {
				return 1;
			}
		};

		public static Weapons get(Weapon weapon) {
			if (weapon instanceof Pistol) {
				return PISTOL;
			} else if (weapon instanceof Shotgun) {
				return SHOTGUN;
			} else if (weapon instanceof Rifle) {
				return RIFLE;
			} else if (weapon instanceof MiniGun) {
				return MINIGUN;
			} else if (weapon instanceof Railgun) {
				return RAILGUN;
			} else { //if grenade gun
				return GRENADE_GUN;
			}
		}

		public abstract WeaponShots getShotType();

		public abstract int getBulletNumber();

		public abstract int getFireRate();
	}
}
