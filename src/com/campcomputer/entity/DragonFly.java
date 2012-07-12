package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

public class DragonFly extends Entity {
    private int flyingEnergy = 25;
    private int breathFireDamage = 33;
    private int eatingDamage = 10;

    public DragonFly(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
        setHealth(5);
    }

    @Override
    public void tick() {
        super.tick();
        if (chasePlayer1() != 1) {
            if (engine.isPlayerAbove(this) == false) {
                setyVel(getyVel() + 0.3f);
                setY(getY() - getyVel());
                flyingEnergy -= 2;
            } else if (engine.isPlayerAbove(this) == true) {
                setyVel(getyVel() + 0.3f);
                setY(getY() + getyVel());
                flyingEnergy -= 1;
            }
        }

        if (engine.isPlayerToLeft(this) == true) {
            moveLeft();
            flyingEnergy += 1;
        } else if (engine.isPlayerToLeft(this) == false) {
            moveRight();
            flyingEnergy += 1;
        } else {
            setxVel(0);
            setX(getX());
        }
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage("images/dragonfly.png"));
    }

    @Override
    public void attack(Entity entity) {
        if (engine.isPlayerClose(this) && entity.getHealth() <= 10)
            eats(entity);
        else if (engine.isPlayerClose(this))
            breathfire(entity);
    }

    /**
     * Attempts to eat the entity. Since the DragonFlies are small, it doesn't do a lot of damage to a player, but the
     * dragonfly gains health from eating.
     *
     * @param entity the thing to eat
     */
    public void eats(Entity entity) {
        // make the enemy lose health
        entity.setHealth(entity.getHealth() - this.eatingDamage);

        if (entity.getHealth() <= 0) {
            // makes the dragonfly gain health
            setHealth(getHealth() + eatingDamage * 1 / 2);
        }
    }


    /**
     * Breathe fire onto the given entity, usually a player. Instantly does a bunch of damage to it.
     *
     * @param entity the thing to breathe fire on.
     */
    public void breathfire(Entity entity) {
        entity.setHealth(entity.getHealth() - this.breathFireDamage);
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


    public int getBreathFireDamage() {
        return breathFireDamage;
    }

    public void setBreathFireDamage(int breathFireDamage) {
        this.breathFireDamage = breathFireDamage;
    }

    public int getEatingDamage() {
        return eatingDamage;
    }

    public void setEatingDamage(int eatingDamage) {
        this.eatingDamage = eatingDamage;
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