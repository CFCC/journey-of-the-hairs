package com.campcomputer.journeyofthehairs;

public interface Weapons {
	int GrenadeTier1Damage = 5;
	int GrenadeTier2Damage = 2;
	int GrenadeTier1Range = 1;
	int GrenadeTier2Range = 2;
	int GrenadeSpeed = 1;
	int BulletDamage = 1;
	int BulletSpeed = 1;
	int RailgunShotDamage = 9000;
	int RailgunShotSpeed = 0;
	int RifleShotDamage = 1;
	int RifleShotSpeed = 2;
	int ShotgunShotDamage = 1;
	int ShotgunShotSpeed = 3;

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

	enum WeaponShots {
		SHOTGUN_SHOT {
			@Override
			public int getDamage() {
				return ShotgunShotDamage;
			}

			@Override
			public int getBulletSpeed() {
				return ShotgunShotSpeed;
			}
		}, RIFLE_SHOT {
			@Override
			public int getDamage() {
				return RifleShotDamage;
			}

			@Override
			public int getBulletSpeed() {
				return RifleShotSpeed;
			}
		}, RAILGUN_SHOT {
			@Override
			public int getDamage() {
				return RailgunShotDamage;
			}

			@Override
			public int getBulletSpeed() {
				return RailgunShotSpeed;
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
				return GrenadeTier1Damage;
			}

			public int getTier2Damage() {
				return GrenadeTier2Damage;
			}

			@Override
			public int getBulletSpeed() {
				return GrenadeSpeed;
			}
		}, BULLET {
			@Override
			public int getDamage() {
				return BulletDamage;
			}

			@Override
			public int getBulletSpeed() {
				return BulletSpeed;
			}
		};

		public abstract int getDamage();

		public abstract int getBulletSpeed();
	}

	enum Weapon {
		PISTOL, SHOTGUN, RIFLE, MINIGUN, RAILGUN, GRENADE_GUN
	}
}
