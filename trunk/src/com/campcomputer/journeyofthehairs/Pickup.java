package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.Player;
import com.campcomputer.journeyofthehairs.item.*;

import java.util.ArrayList;

public class Pickup {
    Item item;
    Player player;
    GrenadeGun grenadeGun;
    MiniGun minigun;
    Pistol pistol;
    Railgun railgun;
    Rifle rifle;
    Shotgun shotgun;

    private ArrayList<Item> inventory = new ArrayList<Item>();
    private ArrayList<Item> items = new ArrayList<Item>();

    float x = item.getX();
    float y = item.getY();
    float pY = player.getY();
    float pX = player.getX();
    Item activeItem;

    public void pickup() {
        if (x == pX && y == pY) {
            inventory.add(item);
            setActiveItem(item);
        }
    }

    public Item getActiveItem(){
        return activeItem;
    }

    public Entity setActiveItem(Item entity) {
        activeItem = entity;
        setWeaponAttributes(entity);
        return activeItem;
    }

    public void setWeaponAttributes (Item activeItem) {
        item.setDamage(activeItem.getDamage());
        item.setBulletNumber(activeItem.getBulletNumber());
        item.setBulletSpeed(activeItem.getBulletSpeed());
        item.setFireRate(activeItem.getFireRate());
    }

    public void addToItems () {
        items.add(grenadeGun);
        items.add(minigun);
        items.add(pistol);
        items.add(railgun);
        items.add(rifle);
        items.add(shotgun);
    }
}
