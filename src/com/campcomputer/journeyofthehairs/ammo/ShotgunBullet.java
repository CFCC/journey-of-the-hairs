package com.campcomputer.journeyofthehairs.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.item.Shotgun;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ShotgunBullet extends Shotgun {
    public List<BufferedImage> bulletsLeft;
    public List<BufferedImage> bulletsRight;

    public ShotgunBullet (GameEngine engine) {
        super(engine);
    }

    public void loadImages() {
        bulletsLeft = new ArrayList<BufferedImage>();
        bulletsRight =  new ArrayList<BufferedImage>();

        bulletsLeft.add(Images.ReadImage("images/shotgun bullet left"));
        bulletsRight.add(Images.ReadImage("images/shotgun bullet right"));
    }
}
