package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.io.File;

public class ChuckNorris extends Entity {
    private final int maxhealth = 9001;
	private final int LOW_HEALTH_THRESHOLD = 1125;

	private int punch = 1;
	private int roundhousekick = 100;
	private int lasereyes = 50;
	int healed = 0;

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

		if (engine.isOnTopOfPlayer(this)) {
			attack(engine.getPlayer());
		}

		if (healed < 1) {
			if (getHealth() <= LOW_HEALTH_THRESHOLD) {
				healing();
			}
		}
	}

	@Override
	public void attack(Entity entity) {
		// It should attack........any attack at random.
	}

	public void punch(Entity entity) {
		entity.setHealth(entity.getHealth() - punch);
	}

	public void roudhousekick(Entity entity) {
		entity.setHealth(entity.getHealth() - roundhousekick);
	}

	public void lasereyes(Entity entity) {
		entity.setHealth(entity.getHealth() - lasereyes);
	}

	public void armor() {


	}

	public void healing() {
		setHealth(maxhealth);
		healed = 1;
	}
}