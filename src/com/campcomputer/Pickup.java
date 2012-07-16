package com.campcomputer;

import com.campcomputer.entity.Player;

import java.util.ArrayList;

public class Pickup {
    Item item;
    Player player;

    private ArrayList<Entity> inventory = new ArrayList<Entity>();
    private ArrayList<Entity> items = new ArrayList<Entity>();

    float x = item.getX();
    float y = item.getY();
    float pY = player.getY();
    float pX = player.getX();

    public void pickup() {
        if (x == pX && y == pY) {
            inventory.add(item);
        }
    }


    public Entity getItem() {
        return item;
    }

    public void addItem() {
        items.add(getItem());
    }
}
