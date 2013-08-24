package com.campcomputer.journeyofthehairs.entity.ammo;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.item.MiniGun;
import com.campcomputer.journeyofthehairs.item.Pistol;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Bullet extends Ammo {
    public List<BufferedImage> bulletLeft;
    public List<BufferedImage> bulletRight;
    private GameEngine engine;

    public Bullet(GameEngine engine) {
        super(engine);
        this.engine = engine;
        setAffectedByGravity(false);

        if (engine.getPlayer().getWeapon() instanceof Pistol) {
            setDamage(1);
            setFireRate(1);
            setBulletNumber(1);
            setBulletSpeed(1);
        } else if (engine.getPlayer().getWeapon() instanceof MiniGun) {
            setDamage(1);
            setFireRate(5);
            setBulletNumber(1);
            setBulletSpeed(1);
        }
    }

    public void tick() {
        if (frames == bulletLeft)
            moveLeft();
        else
            moveRight();

        for (Entity entity : engine.getEntities()) {
            Point2D bPosition = new Point2D.Float(getX(), getY());
            Point2D ePosition = new Point2D.Float(entity.getX(), entity.getY());
            if ((bPosition.distance(ePosition) < 1f) && !(entity instanceof Player) && !(entity instanceof Bullet)) {
                entity.takeDamage(entity);
                if (entity.getHealth() <= 0)
                    engine.removeEntity(entity);
                engine.removeEntity(this);
            }
        }
    }

    @Override
    protected void loadImages() {
        bulletLeft = new ArrayList<BufferedImage>();
        bulletRight = new ArrayList<BufferedImage>();
        bulletRight.add(Images.ReadImage("images/bullet bill right.png"));
        bulletLeft.add(Images.ReadImage("images/bullet bill left.png"));
    }
}
