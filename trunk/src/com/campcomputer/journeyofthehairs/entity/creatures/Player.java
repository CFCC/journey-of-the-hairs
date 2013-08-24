package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.*;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.item.Item;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

    public static final int MAX_HEALTH = 100;
    List<BufferedImage> forwardFrames;
    List<BufferedImage> backwardFrames;
    public int lives = 3;
    public Item weapon;
    public ArrayList<Item> inventory;

    public Player(GameEngine engine) {
        super(engine);
        setHealth(MAX_HEALTH);
    }

    @Override
    protected void loadImages() {
        forwardFrames = new ArrayList<BufferedImage>();
        backwardFrames = new ArrayList<BufferedImage>();
        forwardFrames.add(Images.ReadImage("images/hare forward.png"));
        backwardFrames.add(Images.ReadImage("images/hare back.png"));
        frames = forwardFrames;
    }

    @Override
    public void setXVel(float xVel) {
        super.setXVel(xVel);
        if (xVel < 0)
            frames = backwardFrames;
        if (xVel > 0)
            frames = forwardFrames;
    }

    @Override
    public void tick() {
        super.tick();
        if (frames == forwardFrames)
            facingLeft = false;
        if (frames == backwardFrames)
            facingLeft = true;
        getWeapon().lowerTicksTillFire();
        if (getHealth() <= 0 && lives >= 0)
            lives -= 1;
    }

    public void setWeapon(Item item) {
        this.weapon = item;
    }

    public Item getWeapon() {
        return weapon;
    }

}
