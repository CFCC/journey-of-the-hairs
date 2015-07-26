package com.campcomputer.journeyofthehairs.entity.shot;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.map.MapListener;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Bullet extends Shot {
	public List<BufferedImage> bulletLeft;

	public List<BufferedImage> bulletRight;

	private PhysicsEngine engine;

	public Bullet(PhysicsEngine engine, MapListener mapListener) {
		super(engine, mapListener);
		this.engine = engine;
		setAffectedByGravity(false);

		setDamage(1);
		setBulletSpeed(1);
	}

	public void tick() {
		if (frames == bulletLeft) {
			moveLeft();
		} else {
			moveRight();
		}

		for (Entity entity : engine.getEntities()) {
			Point2D bPosition = new Point2D.Float(getX(), getY());
			Point2D ePosition = new Point2D.Float(entity.getX(), entity.getY());
			if ((bPosition.distance(ePosition) < 1f) && ! (entity instanceof Player) && ! (entity instanceof Bullet)) {
				entity.takeDamage(entity);
				if (entity.getHealth() <= 0) {
					engine.removeEntity(entity);
				}
				engine.removeEntity(this);
			}
		}
	}

	@Override
	protected void loadImages() {
		bulletLeft = new ArrayList<BufferedImage>();
		bulletRight = new ArrayList<BufferedImage>();
		bulletRight.add(Images.ReadImage("/images/entities/shots/bullet right.png"));
		bulletLeft.add(Images.ReadImage("/images/entities/shots/bullet right.png"));
	}
}
