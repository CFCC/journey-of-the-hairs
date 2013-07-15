package com.campcomputer.journeyofthehairs.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.Player;
import javafx.scene.shape.Circle;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grenade extends Ammo {
    public static final int DAMAGE_TIER_1_RANGE = 1;
    public static final int TIER_1_DAMAGE = 5;
    public static final int DAMAGE_TIER_2_RANGE = 2;
    public static final int TIER_2_DAMAGE = 2;
    private int timeLeft = 1000;

    public Grenade(GameEngine engine) {
        super(engine);
    }

    @Override
    public void loadImages() {
        frames.add(Images.ReadImage("images/grenade.png"));
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
