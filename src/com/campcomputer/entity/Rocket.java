package com.campcomputer.entity;

import com.campcomputer.Entity;
import com.campcomputer.GameEngine;
import com.campcomputer.Images;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Rocket extends Entity {

	private static final int ROCKET_DAMAGE = 10;
    private static final float SPEED_MAGNITUDE = 0.1f;

    List<BufferedImage> rocketLeft;
    List<BufferedImage> rocketRight;

    public Rocket(GameEngine engine) {
        super(engine);
        setAffectedByGravity(false);
    }

    @Override
    public void tick() {
        super.tick();


        float playerX = engine.getPlayer().getX();
        float playerY = engine.getPlayer().getY();

        /*
        float newXvel = (getX() + (getX() + playerX)) * SPEED_DIVISOR;
        float newYvel = (getY() + (getY() + playerY)) * SPEED_DIVISOR;
        */

        if (playerX < getX()) {
            frames = rocketLeft;
            setxVel(-1 * SPEED_MAGNITUDE);
        } else {
            frames = rocketRight;
            setxVel(SPEED_MAGNITUDE);
        }

        if (playerY < getY()) {
            frames = rocketRight;
            setyVel(-1 * SPEED_MAGNITUDE);
        } else {
            frames = rocketRight;
            setyVel(SPEED_MAGNITUDE);
        }

        if (engine.isOnTopOfPlayer(this)) {
            engine.getPlayer().setHealth(engine.getPlayer().getHealth() - ROCKET_DAMAGE);
            setHealth(0);
            engine.removeEntity(this);
        }
    }

    @Override
    protected void loadImages() {
        rocketLeft = new ArrayList<BufferedImage>(1);
        rocketRight = new ArrayList<BufferedImage>(1);
        rocketLeft.add(Images.ReadImage(new File("images/rocket.png")));

        BufferedImage original = rocketLeft.get(0);
        BufferedImage flipped = new BufferedImage(original.getWidth(), original.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);

        Graphics2D g2 = (Graphics2D) flipped.getGraphics();
        g2.drawImage(original, AffineTransform.getScaleInstance(-1, 1),null );
        rocketRight.add(flipped);
        frames = rocketLeft;
    }

    @Override
    public void attack(Entity entity) {

    }
	public boolean isAffectedByHitDetection() {
		return false;
	}
}
