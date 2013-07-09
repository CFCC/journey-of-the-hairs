package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;import com.campcomputer.journeyofthehairs.entity.Entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Bullet extends Entity {
    public List<BufferedImage> bulletLeft = new ArrayList<BufferedImage>();
    public List<BufferedImage> bulletRight = new ArrayList<BufferedImage>();

    public Bullet(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
    }

    public void tick() {

    }

    @Override
    protected void loadImages() {
        bulletLeft.add(Images.ReadImage("images/bullet bill right.png"));
        bulletRight.add(Images.ReadImage("images/bullet bill left.png"));
    }
}
