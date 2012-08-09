package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.Player;

import java.util.ArrayList;

public abstract class Item extends Entity {

    Player player = new Player(engine);
    public static Item activeItem;
    public int ammo = 100;
    float bulletSpeed;
    int bulletNumber;   // Number of bullets fired.
    int fireRate;       // How many bullets fired per second.
    int damage;
    private static float x;
    private static float y;
    float playerX = player.getX();
    float playerY = player.getY();

    private ArrayList<Item> inventory = new ArrayList<Item>();
    private static ArrayList<Item> items = new ArrayList<Item>();

    abstract protected void loadImages();

    public void pickUpItem() {
        for (Item item : items) {
            float pickupX = item.getX();
            float pickupY = item.getY();
            if (pickupX == playerX && pickupY == playerY) {
                inventory.add(item);
                setActiveItem(item);
            }
        }
    }

    public static Item getActiveItem() {
        return activeItem;
    }

    public void setActiveItem(Item entity) {
        activeItem = entity;
        setDamage(activeItem.getDamage());
        setBulletNumber(activeItem.getBulletNumber());
        setBulletSpeed(activeItem.getBulletSpeed());
        setFireRate(activeItem.getFireRate());
    }

    public static ArrayList getItems() {
        return items;
    }

    public int setDamage(int x) {
        damage = x;
        return damage;
    }

    public int setFireRate(int x) {
        fireRate = x;
        return fireRate;
    }

    public int setBulletNumber(int x) {
        bulletNumber = x;
        return bulletNumber;
    }

    public float setBulletSpeed(float x) {
        bulletSpeed = x;
        return bulletSpeed;
    }

    public static float setItemX(float X) {
        x = X;
        return x;
    }

    public static float setItemY(float Y) {
        y = Y;
        return y;
    }

    public int getDamage() {
        return damage;
    }

    public int getFireRate() {
        return fireRate;
    }

    public int getBulletNumber() {
        return bulletNumber;
    }

    public float getBulletSpeed() {
        return bulletSpeed;
    }

    public int getAmmo() {
        return ammo;
    }

    public void subtractAmmo() {
        ammo -= 1;
    }

    public Item(GameEngine engine) {
        super(engine);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setItems(ArrayList newArrayList) {
        items = newArrayList;
    }
}
