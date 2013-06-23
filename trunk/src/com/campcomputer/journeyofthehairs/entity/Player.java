package com.campcomputer.journeyofthehairs.entity;

import com.campcomputer.journeyofthehairs.*;
import com.campcomputer.journeyofthehairs.item.Item;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

    public static final int MAX_HEALTH = 100;
    List<BufferedImage> forwardFrames;
    List<BufferedImage> backwardFrames;
    public int lives = 3;
    public Item weapon;

    public Player(GameEngine engine) {
        super(engine);
        setHealth(MAX_HEALTH);
    }

    @Override
    protected void loadImages() {
        forwardFrames = new ArrayList<BufferedImage>();
        backwardFrames = new ArrayList<BufferedImage>();
        forwardFrames.add(Images.ReadImage("images/hare forward.png"));
        backwardFrames.add(Images.ReadImage("images/hare back.png"));
        frames = forwardFrames;
    }

    @Override
    public void setXVel(float xVel) {
        super.setXVel(xVel);
        if (xVel < 0)
            frames = backwardFrames;
        if (xVel > 0)
            frames = forwardFrames;
    }

    @Override
    public void tick() {
        super.tick();
    }

    public void shoot() {
        ArrayList<Entity> entities = engine.entities;
        float playerX = getX();
        float playerY = getY();
        if (isFacingLeft()) {
            if (weapon.getAmmo() > 0) {
                for (Entity entity : entities) {
                    if (!(entity instanceof Player)) {
                        Point2D shootLocation = new Point2D.Float(playerX - 1, playerY);
                        Point2D entityLocation = new Point2D.Float(entity.getX(), entity.getY());
                        weapon.subtractAmmo();
                        if (shootLocation.distance(entityLocation) < 1) {
                            if (!entity.attacked())
                                engine.removeEntity(entity);
                        }
                    }
                }
            }
        }

        if (isFacingRight()) {
            if (weapon.getAmmo() > 0) {
                ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();
                for (Entity entity : entities) {
                    if (!(entity instanceof Player)) {
                        Point2D shootLocation = new Point2D.Float(playerX + 1, playerY);
                        Point2D entityLocation = new Point2D.Float(entity.getX(), entity.getY());
                        weapon.subtractAmmo();
                        if (shootLocation.distance(entityLocation) < 1) {
                            if (!entity.attacked())
                                entitiesToRemove.add(entity);
                        }
                    }
                }
                entities.removeAll(entitiesToRemove);
            }
        }
    }

    public void setWeapon(Item item) {
        this.weapon = item;
    }

}
