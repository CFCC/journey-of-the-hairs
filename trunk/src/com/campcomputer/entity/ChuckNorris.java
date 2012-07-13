package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChuckNorris extends Entity {

	private final int MAX_HEALTH = 9000;
	private final int LOW_HEALTH_THRESHOLD = 1125;

	private int punchDamage = 1;
	private int roundHouseKickDamage = Player.MAX_HEALTH;
	private int beardPunchDamage = 40;
	int healed = 0;

	private static final int PUNCH_CHANCE = 51;
	private static final int ROUND_HOUSE_CHANCE = 9;
	private static final int BEARD_PUNCH_CHANCE = 40;

    List<BufferedImage> standingFrames;
    List<BufferedImage> punchFrames;
    List<BufferedImage> roundhousekickFrames;
    List<BufferedImage> smackFrames;

	public ChuckNorris(GameEngine engine) {
		super(engine);
		setHealth(MAX_HEALTH);
	}

	@Override
	protected void loadImages() {
        standingFrames = new ArrayList<BufferedImage>();
		standingFrames.add(Images.ReadImage("frames/chucknorrissmack/1.png"));
        punchFrames = loadFrames("chucknorrispunch");
        smackFrames = loadFrames("chucknorrissmack");
        roundhousekickFrames = loadFrames("chucknorrisroundhousekick");
        frames = standingFrames;
	}

	@Override
	public void tick() {
		super.tick();

		if (engine.isOnTopOfPlayerChuckNorris()) {
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
		// It should attack........any of the three attacks at random. Use round house kick at the end. ATTACK!

		// Does ChuckNorris only do one attack at a time?
		//Yes.
		// How often should each attack happen? (What chance does each attack have to be the chosen one?)
		//The roundhouse should not happen often. 51% of the punch happening. 40% of the lasereyes happening.
		// While 9% of the roundhouse happening.

		int randomChance = new Random().nextInt(100);

		if (randomChance < 33) {
			punch(entity);
		} else if (randomChance >= 33 && randomChance < 66) {
			beardPunch(entity);
		} else {
			roundHouseKick(entity);
		}


	}

	public void punch(Entity entity) {
		if (new Random().nextInt(100) < PUNCH_CHANCE) {
			entity.setHealth(entity.getHealth() - punchDamage);
			frames = punchFrames;
		}
	}

	public void roundHouseKick(Entity entity) {
		if (new Random().nextInt(100) < ROUND_HOUSE_CHANCE) {
			entity.setHealth(entity.getHealth() - roundHouseKickDamage);
			frames = roundhousekickFrames;
		}
	}

	public void beardPunch(Entity entity) {
		if (new Random().nextInt(100) < BEARD_PUNCH_CHANCE) {
			entity.setHealth(entity.getHealth() - beardPunchDamage);
			frames = roundhousekickFrames;
		}
	}

	public void armor() {

	}

    @Override
    public int getHeight() {
        return 4;
    }

    public void healing() {
		setHealth(MAX_HEALTH);
		healed = 1;
	}
}