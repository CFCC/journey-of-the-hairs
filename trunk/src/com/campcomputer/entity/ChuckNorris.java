package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class ChuckNorris extends Entity {

    public ChuckNorris(GameEngine engine) {
		super(engine);


	}

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage(new File("frames/chucknorris/1.png")));
        frames.add(Images.ReadImage(new File("frames/chucknorris/2.png")));
        frames.add(Images.ReadImage(new File("frames/chucknorris/3.png")));
        frames.add(Images.ReadImage(new File("frames/chucknorris/4.png")));
        frames.add(Images.ReadImage(new File("frames/chucknorris/5.png")));
        frames.add(Images.ReadImage(new File("frames/chucknorris/6.png")));
    }

    public void tick() {
		if (engine.isPlayerClose()) {
			// walk/jog/run towards the player: engine.moveRight() or engine.moveLeft()
			engine.moveForward();
		}
	}

	public void attacks(){

	}

	public void punches(){

	}

	public void roudhousekick(){

	}

	public void lasereyes(){

	}

	public void armor() {

	}

	public void healing() {

	}
}