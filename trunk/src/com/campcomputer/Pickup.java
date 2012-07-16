package com.campcomputer;

import com.campcomputer.entity.Player;

public class Pickup {
    Item item;
    Player player;

    float x = item.getX();
    float y = item.getY();
    float pY = player.getY();
    float pX = player.getX();

    public void pickup() {
        if (x == pX && y == pY){
            //add item to inventory
        }
    }
}
