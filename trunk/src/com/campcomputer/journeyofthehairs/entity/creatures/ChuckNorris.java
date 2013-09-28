package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is Chuck Norris. In the beginning stages of making this game, the creators thought
 * that there should be some type of boss at the end of the game, as there usually is (of course,
 * we only had a week to make this game, so at the time, the whole game was one level). This boss,
 * we decided, would be Chuck Norris. Similar to YMCA Camp Fitch Boys Camp Director legend Steve Delcalzo, Chuck has
 * super powerful super powers. They are exorbitant and lethal. Good luck. You'll need it.
 */
public class ChuckNorris extends Entity {

    /**
     * This is the maximum health that Chuck Norris can have at one time. Although it is very high,
     * it exists. It should also be known that the Railgun Shot's damage is equal to Chuck Norris's
     * max health. If C.N.'s health goes above 9000, it is set back to 9000.
     */
    private static final int MAX_HEALTH = 9000;

    /**
     * This is the amount of damage caused to the player when Chuck does a punch. Statistically, it happens more
     * than half of the time, which makes Chuck a rather ineffective, weak boss (strictly statistically speaking).
     * However, do not underestimate this attack; it still kills the player in 3 1/3 seconds. (at ~33 ticks/second, 100
     * divided by 33 is only about 3 seconds)
     */
    private static final int PUNCH_DAMAGE = 1;

    /**
     * This is Chuck's legendary round house kick. It is for what he is famous. The kick is rumoured to be
     * unimaginably powerful. The game can not demonstrate exactly how powerful it is without making the user upset
     * because that would involve the user's hardware exploding. Instead, we settle for invariably killing the player
     */
    private static final int ROUND_HOUSE_KICK_DAMAGE = Player.MAX_HEALTH;

    /**
     * This is Chuck's third and final attack. It is one where he punches the player using the third, more
     * powerful fist from under his beard. This kills the player very quickly.
     */
    private static final int BEARD_PUNCH_DAMAGE = 40;

    /**
     * This is the statistical probability of Chuck merely punching the player. It is very high, but it's
     * recalculated every 1000/30 of a second, so it doesn't happen that often since the player is killed
     * very quickly
     */
    private static final int PUNCH_CHANCE = 51;

    /**
     * This is the statistical probability of Chuck delivering the deadly round house kick. It is a very small
     * percentage, but it usually happens relatively quickly since the attack is calculated every 1000 / 30 seconds
     */
    private static final int ROUND_HOUSE_CHANCE = 9;

    /**
     * This is the statistical probability of Chuck using his beard punch. It's a pretty high percentage,
     * and it's fairly powerful. Percentage for damage point, it is his biggest asset since the kick happens ~1/4 the
     * time but only delivers 2.25x the power.
     */
    private static final int BEARD_PUNCH_CHANCE = 40;

    /**
     * Chuck Norris is very tall. This is his height; it is used for calculating attacks.
     */
    private static final int HEIGHT = 4;

    /**
     * This is the array for the frame painted to the screen when Chuck is standing, not attacking anybody. It
     * is only one frame, the beginning of the smack frames.
     */
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
            /*
            It should attack any of the three attacks at random. Use round house kick at the end. ATTACK!
            ChuckNorris does only one attack at a time
            The roundhouse should not happen often. 51% of the punch happening. 40% of the laser eyes happening.
            While 9% of the roundhouse happening.
            */

            int randomChance = new Random().nextInt(100);

            if (randomChance < 33)
                punch(engine.getPlayer());
            else if (randomChance >= 33 && randomChance < 66)
                beardPunch(engine.getPlayer());
            else
                roundHouseKick(engine.getPlayer());

        }

        heal();
    }

    public void punch(Entity entity) {
        if (new Random().nextInt(100) < PUNCH_CHANCE) {
            entity.setHealth(entity.getHealth() - PUNCH_DAMAGE);
            frames = smackFrames;
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
            frames = punchFrames;
        }
    }

    /**
     * This is simply an override method to @return his height, 4
     */
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    /**
     * Chuck is super powerful. Even though his max health is very high, he could be attacked. For this
     * reason, he heals every tick, making him an even more difficult opponent. Each tick, any damage done is
     * erased completely, with the exception of the railgun.
     */
    public void heal() {
        setHealth(MAX_HEALTH);
    }

    /**
     * Chuck Norris is a huge entity, taking up a whopping 12 tiles. Because he isn't simply one tile, he needs
     * his own isOnTopOfEntity method. It takes in an entity and gets its position, then compares it to each of
     * the 12 locations corresponding to Chuck.
     *
     * eP stands for Entity Position, and tP, while also standing for toilet paper, stands for this position
     *
     * @param entity the entity to be compared to Chuck Norris in location
     * @return a boolean, true if the entity's position is on Chuck, false if not
     */
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