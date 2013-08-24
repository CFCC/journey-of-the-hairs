package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;

public class DragonFly extends Entity {
    private int flyingEnergy = 25;
    private static final int BREATH_FIRE_DAMAGE = 1;
    private static final int EATING_DAMAGE = 10;

    public DragonFly(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
        setHealth(5);
    }

    @Override
    public void tick() {
        super.tick();
        if (chasePlayer1() != 1) {
            if (!engine.isPlayerAbove(this)) {
                moveUp();
                flyingEnergy -= 2;
            } else if (engine.isPlayerAbove(this)) {
                moveDown();
                flyingEnergy -= 1;
            }
        }

        if (engine.isPlayerToLeft(this)) {
            moveLeft();
            flyingEnergy += 1;
        } else if (!engine.isPlayerToLeft(this)) {
            moveRight();
            flyingEnergy += 1;
        } else {
            setXVel(0);
            setX(getX());
        }

        Player player = engine.getPlayer();
        if (engine.isOnTopOfPlayer(this)) {
            if (player.getHealth() <= EATING_DAMAGE)
                eats(player);
            else if (engine.isPlayerClose(this))
                breathFire(player);
        }
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage("images/dragonfly.png"));
    }

    /**
     * Attempts to eat the entity. Since the DragonFlies are small, it doesn't do a lot of damage to a player, but the
     * dragonfly gains health from eating.
     *
     * @param entity the thing to eat
     */
    public void eats(Entity entity) {
        // make the enemy lose health
        entity.setHealth(entity.getHealth() - EATING_DAMAGE);

        if (entity.getHealth() <= 0) {
            // makes the dragonfly gain health
            setHealth(getHealth() + EATING_DAMAGE / 2);
        }
    }

    /**
     * Breathe fire onto the given entity, usually a player. Instantly does a bunch of damage to it.
     *
     * @param entity the thing to breathe fire on.
     */
    public void breathFire(Entity entity) {
        entity.setHealth(entity.getHealth() - BREATH_FIRE_DAMAGE);
    }

    public int chasePlayer1() {
        if (flyingEnergy > 7) {
            // fly towards the player,
            // solid object in the way
            return 0;
        }
        if (flyingEnergy <= 0)
            return 1;
            //walk towards the player,
            // can also jump.
        else
            return 2;
    }

    public int getFlyingEnergy() {
        return flyingEnergy;
    }

    public void setFlyingEnergy(int flyingEnergy) {
        this.flyingEnergy = flyingEnergy;
    }

    public boolean isAffectedByHitDetection() {
        return false;
    }
}