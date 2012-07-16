package com.campcomputer.item;

import com.campcomputer.GameEngine;
import com.campcomputer.Images;
import com.campcomputer.Item;

public abstract class Pistol extends Item {

    private int damage = 1;

    private int fireRate = 1;

    private int bulletNumber = 1;

    private float bulletSpeed = 1f;

    protected void loadImages() {
        frames.add(Images.ReadImage("images/pistol.png"));
    }

    public Pistol(GameEngine engine) {
        super(engine);
    }
}
