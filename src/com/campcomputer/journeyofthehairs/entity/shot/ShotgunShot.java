package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ShotgunShot extends Shot {
    public List<BufferedImage> bulletsLeft;
    public List<BufferedImage> bulletsRight;

    public ShotgunShot(GameEngine engine) {
        super(engine);
        setDamage(1);
        setBulletSpeed(3);
    }

    public void loadImages() {
        bulletsLeft = new ArrayList<BufferedImage>();
        bulletsRight =  new ArrayList<BufferedImage>();

        bulletsLeft.add(Images.ReadImage("entities/shots/shotgun shot left"));
        bulletsRight.add(Images.ReadImage("entities/shots/shotgun shot right"));
    }
}
