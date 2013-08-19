package com.campcomputer.journeyofthehairs.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Health extends Pickup {
    public List<BufferedImage> five;
    public List<BufferedImage> ten;
    public List<BufferedImage> fifty;

    public Health (GameEngine engine, int amount) {
        super(engine);
    }

    public void loadImages() {
        five = new ArrayList<BufferedImage>();
        ten = new ArrayList<BufferedImage>();
        fifty = new ArrayList<BufferedImage>();

        five.add(Images.ReadImage("images/five health.png"));
        ten.add(Images.ReadImage("images/ten health.png"));
        fifty.add(Images.ReadImage("images/fifty health.png"));
    }
}
