package com.campcomputer.item;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;
import com.campcomputer.Item;

public class Rifle extends Item {
    private int Damage = 1;
    //  How much damage the gun does.
    private int FireRate = 1;
    // How many bullets fired per second or something.
    private int BulletNumber = 20;
    // Number of bullets fired.
    private float BulletSpeed = 3f;
// Speed of bullets.

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
