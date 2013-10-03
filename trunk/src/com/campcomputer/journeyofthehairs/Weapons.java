package com.campcomputer.journeyofthehairs;

public interface Weapons {
    /**
     * This is the interface with data of the different ammunition. It is implemented to have a link between fields in
     * the classes extending shot and the enumeration for the shot types (since an enum can't extend shot)
     *
     * There are 2 fields pertaining to the shots; the rest belong to the weapon.
     *
     * Damage is the amount of health subtracted from the entity affected when it is hit.
     * Speed is how fast the shot travels.
     *
     * Even though there are 6 weapons, there are only 5 shot types; the pistol and minigun both fire bullets. The
     * difference is that a minigun fires them much faster.
     */

    public enum WeaponShots {
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
    
    public enum Weapon {
        PISTOL, SHOTGUN, RIFLE, MINIGUN, RAILGUN, GRENADE_GUN
    }

    public int GrenadeTier1Damage = 5;
    public int GrenadeTier2Damage = 2;
    public int GrenadeSpeed = 1;

    public int BulletDamage = 1;
    public int BulletSpeed = 1;

    public int RailgunShotDamage = 9000;
    public int RailgunShotSpeed = 0;

    public int RifleShotDamage = 1;
    public int RifleShotSpeed = 2;

    public int ShotgunShotDamage = 1;
    public int ShotgunShotSpeed = 3;
}
