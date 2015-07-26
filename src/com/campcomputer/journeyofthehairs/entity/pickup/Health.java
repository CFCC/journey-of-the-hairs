package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.map.MapListener;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * If the user is low on health, they can pick up this random drop to replenish it. There are 3 versions -
 * one that replenishes 20 health, 50 health, and one that completely heals the user at 100.
 */
public class Health extends Pickup {
	private List<BufferedImage> twenty;
	private List<BufferedImage> fifty;
	private List<BufferedImage> oneHundred;

	public Health(PhysicsEngine engine, int amount, MapListener mapListener) {
		super(engine, mapListener);
		if (amount == 20) {
			frames = twenty;
		} else if (amount == 50) {
			frames = fifty;
		} else if (amount == 100) {
			frames = oneHundred;
		}
	}

	public void loadImages() {
		twenty = new ArrayList<BufferedImage>();
		fifty = new ArrayList<BufferedImage>();
		oneHundred = new ArrayList<BufferedImage>();

		twenty.add(Images.ReadImage("entities/pickups/health/20"));
		fifty.add(Images.ReadImage("entities/pickups/health/50"));
		oneHundred.add(Images.ReadImage("entities/pickups/health/100"));
	}

	@Override
	public void affectGame() {
		Player player = engine.getPlayer();
		if (frames == twenty) {
			player.setHealth(player.getHealth() + 20);
		} else if (frames == fifty) {
			player.setHealth(player.getHealth() + 50);
		} else if (frames == oneHundred) {
			player.setHealth(player.getHealth() + 100);
		}

		if (player.getHealth() > Player.MAX_HEALTH) {
			player.setHealth(Player.MAX_HEALTH);
		}
	}
}
