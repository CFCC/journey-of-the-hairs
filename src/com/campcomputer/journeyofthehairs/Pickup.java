package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.Player;
import com.campcomputer.journeyofthehairs.item.Item;

import java.util.ArrayList;

public class Pickup {
    GameEngine engine = new GameEngine();
    Item item;
    Player player = engine.getPlayer();

    private ArrayList<Item> inventory = new ArrayList<Item>();

    float x = item.getX();
    float y = item.getY();
    float pY = player.getY();
    float pX = player.getX();
    Item activeItem;

    public void pickUpItem() {
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
        item.setDamage(activeItem.getDamage());
        item.setBulletNumber(activeItem.getBulletNumber());
        item.setBulletSpeed(activeItem.getBulletSpeed());
        item.setFireRate(activeItem.getFireRate());
        return activeItem;
    }
}
