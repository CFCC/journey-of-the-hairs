package com.campcomputer.journeyofthehairs.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.Player;
import javafx.scene.shape.Circle;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
        stasisFrames.add(Images.ReadImage("images/grenade.png"));
        explosionFrames.add(Images.ReadImage("images/grenade explosion.png"));
    }

    public void tick() {
        if (timeLeft > 0)
            timeLeft--;
        else {
            Circle tierOneCircle = new Circle();
            Circle tierTwoCircle = new Circle();
            tierOneCircle.setRadius(DAMAGE_TIER_1_RANGE);
            tierTwoCircle.setRadius(DAMAGE_TIER_2_RANGE);

            for (Entity entity : engine.getEntities()) {
                if (!(entity instanceof Player) && tierOneCircle.contains(entity.getLocation()))
                    entity.setHealth(entity.getHealth() - TIER_1_DAMAGE);
                if (!(entity instanceof Player) && tierTwoCircle.contains(entity.getLocation()))
                    entity.setHealth(entity.getHealth() - TIER_2_DAMAGE);
            }

            engine.removeEntity(this);
        }

    }
}
