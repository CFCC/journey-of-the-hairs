package com.campcomputer.item;

import com.campcomputer.GameEngine;
import com.campcomputer.Images;
import com.campcomputer.Item;

public abstract class Shotgun extends Item {
    private int Damage = 1;
    //  How much damage the gun does.
    private int FireRate = 5;
    // How many bullets fired per second or something.
    private int BulletNumber = 1;
    // Number of bullets fired.
    private float BulletSpeed = 2f;
// Speed of bullets.

    protected void loadImages() {
    frames.add(Images.ReadImage("images/shotgun.png"));
}
    public Shotgun(GameEngine engine) {
        super(engine);
    }
}
