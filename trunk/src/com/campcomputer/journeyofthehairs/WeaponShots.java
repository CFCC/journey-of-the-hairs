package com.campcomputer.journeyofthehairs;

public enum WeaponShots implements Ammo {
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
        @Override
        public int getDamage() {
            return GrenadeTier1Damage;
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
