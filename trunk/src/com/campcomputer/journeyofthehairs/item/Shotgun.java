package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Shotgun extends Item {

    Item item;
    float x;
    float y;

    public void main(String[] args) {
        item.setDamage(1);
        item.setFireRate(5);
        item.setBulletNumber(1);
        item.setBulletSpeed(2f);
        item.setItemX(x);
        item.setItemY(y);
    }

    protected void loadImages() {
    frames.add(Images.ReadImage("images/shotgun.png"));
}

    @Override
    public void attack(Entity entity) {
    }

    public Shotgun(GameEngine engine) {
        super(engine);
    }
}
