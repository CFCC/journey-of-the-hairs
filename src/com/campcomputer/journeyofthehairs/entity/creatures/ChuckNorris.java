package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;

import java.awt.geom.Point2D;
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

    private static final int PUNCH_CHANCE = 51;
    private static final int ROUND_HOUSE_CHANCE = 9;
    private static final int BEARD_PUNCH_CHANCE = 40;

    public static final int HEIGHT = 4;

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

        if (isOnTopOfEntity(engine.getPlayer())) {
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

        if (getHealth() <= LOW_HEALTH_THRESHOLD)
            heal();
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
        return HEIGHT;
    }

    public void heal() {
        setHealth(MAX_HEALTH);
    }

    public boolean isOnTopOfEntity(Entity entity) {
        float x1 = getX();
        float x2 = getX() + 1;
        float x3 = getX() + 2;
        float y1 = getY();
        float y2 = getY() + 1;
        float y3 = getY() + 2;
        float y4 = getY() + 3;

        Point2D eP = new Point2D.Float(entity.getX(), entity.getY());

        Point2D tP1 = new Point2D.Float(x1, y1);
        Point2D tP2 = new Point2D.Float(x2, y1);
        Point2D tP3 = new Point2D.Float(x3, y1);
        Point2D tP4 = new Point2D.Float(x1, y2);
        Point2D tP5 = new Point2D.Float(x2, y2);
        Point2D tP6 = new Point2D.Float(x3, y2);
        Point2D tP7 = new Point2D.Float(x1, y3);
        Point2D tP8 = new Point2D.Float(x2, y3);
        Point2D tP9 = new Point2D.Float(x3, y3);
        Point2D tP10 = new Point2D.Float(x1, y4);
        Point2D tP11 = new Point2D.Float(x2, y4);
        Point2D tP12 = new Point2D.Float(x3, y4);

        return eP.distance(tP1) <= 2f || eP.distance(tP2) <= 2f || eP.distance(tP3) <= 2f || eP.distance(tP4) <= 2f
                || eP.distance(tP5) <= 2f || eP.distance(tP6) <= 2f || eP.distance(tP7) <= 2f || eP.distance(tP8) <= 2f
                || eP.distance(tP9) <= 2f || eP.distance(tP10) <= 2f || eP.distance(tP11) <= 2f || eP.distance(tP12) <= 2f;
    }
}