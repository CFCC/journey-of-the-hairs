package com.campcomputer.journeyofthehairs.entity;


import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

    public static int MAX_HEALTH = 500;
    List<BufferedImage> forwardFrames;
    List<BufferedImage> backwardFrames;
    public static int lives = 3;

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
    public void setxVel(float xVel) {
        super.setxVel(xVel);
        if (xVel < 0)
            frames = backwardFrames;
        if (xVel > 0)
            frames = forwardFrames;
    }

    @Override
    public void tick() {
        super.tick();
    }

    public int getLives() {
        return lives;
    }

    public boolean isPlayerAlive() {
        return getHealth() > 0;
    }

    public void subtractLife() {
        lives -= 1;
    }

    @Override
    public void attack(Entity entity) {

    }
}
