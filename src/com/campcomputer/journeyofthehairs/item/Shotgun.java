package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Shotgun extends Item {
    private int Damage = 1;

    private int FireRate = 5;

    private int BulletNumber = 1;

    private float BulletSpeed = 2f;


    protected void loadImages() {
    frames.add(Images.ReadImage("images/shotgun.png"));
}

    public Shotgun(GameEngine engine) {
        super(engine);
    }
}
