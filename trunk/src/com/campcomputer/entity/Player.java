package com.campcomputer.entity;


import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

    List<BufferedImage> forwardFrames;
    List<BufferedImage> backwardFrames;
    public Player(GameEngine engine) {super(engine);}

    @Override
    protected void loadImages() {
        forwardFrames = new ArrayList<BufferedImage>();
        backwardFrames = new ArrayList<BufferedImage>();
        forwardFrames.add(Images.ReadImage(new File("images/hare forward.png")));
        backwardFrames.add(Images.ReadImage(new File("images/hare back.png")));
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

	@Override
	public void attack(Entity entity) {

	}
}
