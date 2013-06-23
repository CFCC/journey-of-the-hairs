package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChuckNorris extends Entity {

    public static final int MAX_HEALTH = 9000;
    private static final int LOW_HEALTH_THRESHOLD = 1125;

    private static final int PUNCH_DAMAGE = 1;
    private static final int ROUND_HOUSE_KICK_DAMAGE = Player.MAX_HEALTH;
    private static final int BEARD_PUNCH_DAMAGE = 40;
    int healed = 0;

    private static final int PUNCH_CHANCE = 51;
    private static final int ROUND_HOUSE_CHANCE = 9;
    private static final int BEARD_PUNCH_CHANCE = 40;

    List<BufferedImage> standingFrames;
    List<BufferedImage> punchFrames;
    List<BufferedImage> roundhouseKickFrames;
    List<BufferedImage> smackFrames;

    public ChuckNorris(GameEngine engine) {
        super(engine);
        setHealth(MAX_HEALTH);
    }

    @Override
    protected void loadImages() {
        standingFrames = new ArrayList<BufferedImage>();
        standingFrames.add(Images.ReadImage("frames/chucknorrissmack/1.png"));
        punchFrames = Images.loadFrames("chucknorrispunch");
        smackFrames = Images.loadFrames("chucknorrissmack");
        roundhouseKickFrames = Images.loadFrames("chucknorrisroundhousekick");
        frames = standingFrames;
    }

    @Override
    public void tick() {
        super.tick();

        if (engine.isOnTopOfPlayerChuckNorris()) {
            // It should attack any of the three attacks at random. Use round house kick at the end. ATTACK!
            // ChuckNorris does only one attack at a time
            // The roundhouse should not happen often. 51% of the punch happening. 40% of the laser eyes happening.
            // While 9% of the roundhouse happening.

            int randomChance = new Random().nextInt(100);

            if (randomChance < 33)
                punch(engine.getPlayer());
            else if (randomChance >= 33 && randomChance < 66)
                beardPunch(engine.getPlayer());
            else
                roundHouseKick(engine.getPlayer());

        }

        if (healed < 1) {
            if (getHealth() <= LOW_HEALTH_THRESHOLD) {
                healing();
            }
        }
    }

    public void punch(Entity entity) {
        if (new Random().nextInt(100) < PUNCH_CHANCE) {
            entity.setHealth(entity.getHealth() - PUNCH_DAMAGE);
            frames = punchFrames;
        }
    }

    public void roundHouseKick(Entity entity) {
        if (new Random().nextInt(100) < ROUND_HOUSE_CHANCE) {
            entity.setHealth(entity.getHealth() - ROUND_HOUSE_KICK_DAMAGE);
            frames = roundhouseKickFrames;
        }
    }

    public void beardPunch(Entity entity) {
        if (new Random().nextInt(100) < BEARD_PUNCH_CHANCE) {
            entity.setHealth(entity.getHealth() - BEARD_PUNCH_DAMAGE);
            frames = roundhouseKickFrames;
        }
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