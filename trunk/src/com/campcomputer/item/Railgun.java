package com.campcomputer.item;

import com.campcomputer.GameEngine;
import com.campcomputer.Item;

public abstract class Railgun extends Item {
    private int Damage = 9001;
    //  How much damage the gun does.
    private int FireRate = 1;
    // How many bullets fired per second or something.
    private int BulletNumber = 1;
    // Number of bullets fired.
    private float BulletSpeed = 9000f;
// Speed of bullets.

    public Railgun(GameEngine engine) {
        super(engine);
    }
}
