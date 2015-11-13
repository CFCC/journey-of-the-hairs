package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Player;

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

	public Health(PhysicsEngine engine, int amount) {
		super(engine);
		if (amount == 20) {
			frames = twenty;
		} else if (amount == 50) {
			frames = fifty;
		} else if (amount == 100) {
			frames = oneHundred;
		}
	}

	public void addImagesOfEntityToFrames() {
		twenty = new ArrayList<BufferedImage>();
		fifty = new ArrayList<BufferedImage>();
		oneHundred = new ArrayList<BufferedImage>();

		twenty.add(Images.ReadImage("/images/entities/pickups/health/20.png"));
		fifty.add(Images.ReadImage("/images/entities/pickups/health/50.png"));
		oneHundred.add(Images.ReadImage("/images/entities/pickups/health/100.png"));
	}

	@Override public void affectGame() {
		Player player = getEngine().getPlayer();
		if (frames == twenty) {
			player.heal(20);
		} else if (frames == fifty) {
			player.heal(50);
		} else if (frames == oneHundred) {
			player.heal(100);
		}

		if (player.getHealth() > Player.MAX_HEALTH) {
			player.restoreHealth();
		}
	}
}
