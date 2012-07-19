package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Rifle extends Item {

    Item item;
    float x;
    float y;

    public void main(String[] args) {
        item.setDamage(1);
        item.setFireRate(1);
        item.setBulletNumber(20);
        item.setBulletSpeed(3f);
        item.setItemX(x);
        item.setItemY(y);
    }

    protected void loadImages() {
    frames.add(Images.ReadImage("images/rifle.png"));
}

    @Override
    public void attack(Entity entity) {
    }

    public Rifle(GameEngine engine) {
        super(engine);
    }
}
