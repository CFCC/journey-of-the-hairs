package com.campcomputer.journeyofthehairs.entity.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ShotgunBullet extends Ammo {
    public List<BufferedImage> bulletsLeft;
    public List<BufferedImage> bulletsRight;

    public ShotgunBullet (GameEngine engine) {
        super(engine);
        setDamage(1);
        setFireRate(1);
        setBulletNumber(20);
        setBulletSpeed(3);
    }

    public void loadImages() {
        bulletsLeft = new ArrayList<BufferedImage>();
        bulletsRight =  new ArrayList<BufferedImage>();

        bulletsLeft.add(Images.ReadImage("images/shotgun bullet left.png"));
        bulletsRight.add(Images.ReadImage("images/shotgun bullet right.png"));
    }
}
