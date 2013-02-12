package com.campcomputer.journeyofthehairs.item;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

public class Pistol extends Item {

    private int damage = 1;

    private int fireRate = 1;

    private int bulletNumber = 1;

    private float bulletSpeed = 1f;

    protected void loadImages() {
        frames.add(Images.ReadImage("images/pistol.png"));
    }

    @Override
    public void attack(Entity entity) {
    }

    public Pistol(GameEngine engine) {
        super(engine);
    }
}
