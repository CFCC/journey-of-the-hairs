package com.campcomputer.journeyofthehairs.weapon;

import com.campcomputer.journeyofthehairs.entity.shot.WeaponShots;

/**
 * Enumeration of all of the possible weapons, how often they fire, what they fire, and how much of it they
 * fire at one time
 */
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
			return 100;
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
			return 1000;
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
			return 50;
		}
	};

	public static com.campcomputer.journeyofthehairs.weapon.Weapons get(Weapon weapon) {
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
