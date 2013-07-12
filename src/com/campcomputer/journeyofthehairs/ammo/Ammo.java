package com.campcomputer.journeyofthehairs.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.item.*;

public abstract class Ammo extends Item {
    public Item item;

    public Ammo(GameEngine engine) {
        super(engine);
    }
}
