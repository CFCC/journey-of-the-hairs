package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.map.CheeseMap;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Portal extends Pickup {
    public String location;
    public List<BufferedImage> portalSpin = new ArrayList<BufferedImage>();

    public void loadImages() {
        portalSpin = Images.loadFrames("portal");
        frames = portalSpin;
    }

    public Portal(GameEngine engine, String location) {
        super(engine);
        this.location = location;
    }

    @Override
    public void affectGame() {
        CheeseMap cheeseMap = new CheeseMap(engine);
        engine.setMap(cheeseMap);
    }
}
