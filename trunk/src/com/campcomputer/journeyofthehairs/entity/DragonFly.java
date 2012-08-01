package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;

import java.util.ArrayList;

public class DragonFly extends Entity {
    private int flyingEnergy = 25;
    private int breathFireDamage = 33;
    private int eatingDamage = 10;
    private ArrayList<Entity> entities = new ArrayList<Entity>();

    public DragonFly(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
        setHealth(5);
    }

    public ArrayList getEntities() {
        return entities;
    }

    @Override
    public void tick() {
        super.tick();
        if (!engine.isPlayerAbove(this)) {
            setyVel(getyVel() + 0.3f);
            setY(getY() - getyVel());
            flyingEnergy -= 2;
        } else if (engine.isPlayerAbove(this)) {
            setyVel(getyVel() + 0.3f);
            setY(getY() + getyVel());
            flyingEnergy -= 1;
        }

        if (engine.isPlayerToLeft(this)) {
            moveLeft();
            if (getX() < 1)
                flyingEnergy += 1;
        } else if (!engine.isPlayerToLeft(this)) {
            moveRight();
            if (getX() < 1)
                flyingEnergy += 1;
        } else {
            setxVel(0);
            setX(getX());
        }
        for (Entity entity : entities) {
            attack(entity);
        }
    }

    @Override
    protected void loadImages() {
        frames.add(Images.ReadImage("images/dragonfly.png"));
    }

    @Override
    public void attack(Entity entity) {
        if (engine.isEntityClose(this, entity) && entity.getHealth() <= 10)
            eats(entity);
//        if (engine.isEntityClose(this, entity))
//            breathfire(entity);
    }

    /**
     * Attempts to eat the entity. Since the DragonFlies are small, it doesn't do a lot of damage to a player, but the
     * dragonfly gains health from eating.
     *
     * @param entity the thing to eat
     */
    public void eats(Entity entity) {
        // make the enemy lose health
        entity.setHealth(entity.getHealth() - eatingDamage);
        // makes the dragonfly gain health
        setHealth(getHealth() + eatingDamage / 2);

    }


    /**
     * Breathe fire onto the given entity, usually a player. Instantly does a bunch of damage to it.
     *
     * @param entity the thing to breathe fire on.
     */
    public void breathfire(Entity entity) {
        entity.setHealth(entity.getHealth() - this.breathFireDamage);
    }

    public boolean isThereFlyingEnergy() {
        return flyingEnergy > 0;
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