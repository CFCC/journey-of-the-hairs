package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;

import java.util.Random;

public class ChuckNorris extends Entity {
    private final int maxhealth = 9001;
	private final int LOW_HEALTH_THRESHOLD = 1125;

	private int punch = 1;
	private int roundhousekick = 100;
	private int beardpunch = 49;
	int healed = 0;

	public ChuckNorris(GameEngine engine) {
		super(engine);
		setHealth(maxhealth);
	}

	@Override
	protected void loadImages() {
		frames = loadFrames("chucknorris");
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
		// It should attack........any of the three attacks at random. Use roundhousekick at the end. ATTACK!

		// Does ChuckNorris only do one attack at a time?
		//Yes.
		// How often should each attack happen? (What chance does each attack have to be the chosen one?)
		//The roundhouse should not happen often. 51% of the punch happening. 40% of the lasereyes happening.
		// While 9% of the roundhouse happening.

		boolean hasAttacked = false;
		// do the punch 51% of the time.
		if (new Random().nextInt(100) < 51) {
			punch(entity);
			hasAttacked = true;
		}

		if (new Random().nextInt(100) < 40) {
			beardpunch(entity);
		}

		if (new Random().nextInt(100) < 9) {
			roundhousekick(entity);
		}
	}

	public void punch(Entity entity) {
		entity.setHealth(entity.getHealth() - punch);
	}

	public void roundhousekick(Entity entity) {
		entity.setHealth(entity.getHealth() - roundhousekick);
	}

	public void beardpunch(Entity entity) {
		entity.setHealth(entity.getHealth() - beardpunch);
	}

	public void armor() {


	}

    @Override
    public int getHeight() {
        return 4;
    }

    public void healing() {
		setHealth(maxhealth);
		healed = 1;
	}
}