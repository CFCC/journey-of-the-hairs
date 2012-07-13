package com.campcomputer.item;

import com.campcomputer.GameEngine;
import com.campcomputer.Item;

public abstract class Rifle extends Item {
    private int Damage = 1;
    //  How much damage the gun does.
    private int FireRate = 1;
    // How many bullets fired per second or something.
    private int BulletNumber = 20;
    // Number of bullets fired.
    private float BulletSpeed = 3f;
// Speed of bullets.

    public Rifle(GameEngine engine) {
        super(engine);
    }
}
