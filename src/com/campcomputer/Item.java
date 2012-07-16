package com.campcomputer;

public abstract class Item extends Entity {

    int ammoLeft = 100;
    float bulletSpeed = 1f;
    int bulletNumber = 1;   // Number of bullets fired.
    int fireRate = 1;       // How many bullets fired per second.
    int damage = 1;
    private float x = 0;
    private float y = 0;

    public int getDamage() {
        return damage;
    }

    public int getFireRate() {
        return fireRate;
    }

    public int getBulletNumber() {
        return bulletNumber;
    }

    public float getBulletSpeed(){
        return bulletSpeed;
    }

    public int getAmmo(){
        return ammoLeft;
    }

    public void subtractAmmo(){
        ammoLeft -= 1;
    }

    public Item(GameEngine engine) {
        super(engine);
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }
}
