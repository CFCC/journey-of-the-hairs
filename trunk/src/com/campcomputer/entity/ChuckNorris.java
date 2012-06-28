package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;
import com.sun.tools.corba.se.idl.constExpr.Times;
import com.sun.xml.internal.ws.api.message.HeaderList;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class ChuckNorris extends Entity {
	private final int maxhealth = 9002;
	private int punch = 30;
	private int roundhousekick = 100;
	private int lasereyes = 50;
	private int armor = 25;
	int healing;
    public ChuckNorris(GameEngine engine) {
		super(engine);
		setHealth(maxhealth);
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

	@Override
	public void tick() {
        super.tick();
		if (engine.isPlayerClose(this)) {
			attack(engine.getPlayer());
		}

		if (getHealth() <= 1125) {
			healing();
			(int 'n' Number of Times healed)
		if healed once, do not heal again}
	}

	@Override
	public void attack(Entity entity){

	}

	public void punch(Entity entity){

	}

	public void roudhousekick(){

	}

	public void lasereyes(){

	}

	public void armor() {


	}

	public void healing() {
		setHealth(maxhealth);

	}
}