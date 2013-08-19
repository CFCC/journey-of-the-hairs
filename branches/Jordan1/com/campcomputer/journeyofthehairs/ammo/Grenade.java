package com.campcomputer.journeyofthehairs.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.Player;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Grenade extends Ammo {
    public static final int DAMAGE_TIER_1_RANGE = 1;
    public static final int TIER_1_DAMAGE = 5;
    public static final int DAMAGE_TIER_2_RANGE = 2;
    public static final int TIER_2_DAMAGE = 2;

    public List<BufferedImage> stasisFrames;
    public List<BufferedImage> explosionFrames;

    private int timeLeft = 1000;

    public Grenade(GameEngine engine) {
        super(engine);
        setDamage(1);
        setFireRate(1);
        setBulletNumber(1);
        setBulletSpeed(1);
    }

    @Override
    public void loadImages() {
        stasisFrames = new ArrayList<BufferedImage>();
        explosionFrames = new ArrayList<BufferedImage>();

        stasisFrames.add(Images.ReadImage("images/grenade.png"));
        explosionFrames.add(Images.ReadImage("images/grenade explosion.png"));
    }

    public void tick() {
        if (timeLeft > 0){
            timeLeft--;
		} else {

            for (Entity entity : engine.getEntities()) {
                if (!(entity instanceof Player)){
					double distance = getLocation().distance(entity.getLocation());
					if (distance < DAMAGE_TIER_1_RANGE)
                    	entity.setHealth(entity.getHealth() - TIER_1_DAMAGE);
					else if (distance < DAMAGE_TIER_2_RANGE)
                    	entity.setHealth(entity.getHealth() - TIER_2_DAMAGE);
				}
            }
            engine.removeEntity(this);
        }

    }
}
