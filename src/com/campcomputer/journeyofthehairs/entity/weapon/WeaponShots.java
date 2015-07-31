package com.campcomputer.journeyofthehairs.entity.weapon;

/**
 * Created by Jordan on 7/31/2015.
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

	public static final int GRENADE_TIER_1_DAMAGE = 5;

	public static final int GRENADE_TIER_2_DAMAGE = 2;

	public static final int GRENADE_TIER_1_RANGE = 1;

	public static final int GRENADE_TIER_2_RANGE = 2;

	public static final int GRENADE_SPEED = 1;

	public static final int BULLET_DAMAGE = 1;

	public static final int BULLET_SPEED = 1;

	public static final int RAILGUN_SHOT_DAMAGE = 9000;

	public static final int RAILGUN_SHOT_SPEED = 0;

	public static final int RIFLE_SHOT_DAMAGE = 1;

	public static final int RIFLE_SHOT_SPEED = 2;

	public static final int SHOTGUN_SHOT_DAMAGE = 1;

	public static final int SHOTGUN_SHOT_SPEED = 3;

	public abstract int getDamage();

	public abstract int getBulletSpeed();
}
