package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.shot.WeaponShots;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The user will need ammo to use their weapon. They can get more by random drops. The drops are weapon specific,
 * so the user will need the ammo that goes with their weapon to use it. However, they will tend to see more
 * drops of the weapon they are currently carrying.
 */
public class Ammo extends Pickup {
	/**
	 * This is the type of ammo that the instance will be. There are 5 types of ammo enumerated in the
	 * WeaponShots enum, which is also the field type.
	 */
	private WeaponShots type;

	/**
	 * This is the amount of ammo to be added to the player's inventory. There is no set amount of
	 * ammo to be in every instance, especially since each weapon will require a different 'average' amount
	 * of ammo. For example, the railgun is very powerful, so its ammo amount will be 1, but miniguns fire very
	 * quickly, so their ammo amount will be higher, like 60.
	 */
	private int amount;

	/**
	 * Constructor
	 *
	 * @param type   the type of ammo to generate
	 * @param amount the amount of ammo to add
	 */
	public Ammo(PhysicsEngine engine, WeaponShots type, int amount) {
		super(engine);
		this.type = type;
		this.amount = amount;
	}

	/**
	 * Adds ammo to the player's active weapon
	 */
	@Override public void affectGame() {
		getEngine().getPlayer().getWeapon().addAmmo(amount);
	}

	/**
	 * Self explanatory. Loads images based on what type the instance is
	 */
	@Override protected void addImagesOfEntityToFrames() {
		switch (type) {
			case GRENADE:
				frames = new ArrayList<BufferedImage>(1);
				frames.add(Images.ReadImage("/images/entities/pickups/ammo/grenade gun ammo.png"));
				break;
			case BULLET:
				frames = new ArrayList<BufferedImage>(1);
				frames.add(Images.ReadImage("/images/entities/pickups/ammo/bullet ammo.png"));
				break;
			case RAILGUN_SHOT:
				frames = new ArrayList<BufferedImage>(1);
				frames.add(Images.ReadImage("/images/entities/pickups/ammo/railgun ammo.png"));
				break;
			case RIFLE_SHOT:
				frames = new ArrayList<BufferedImage>(1);
				frames.add(Images.ReadImage("/images/entities/pickups/ammo/rifle ammo.png"));
				break;
			case SHOTGUN_SHOT:
				frames = new ArrayList<BufferedImage>(1);
				frames.add(Images.ReadImage("/images/entities/pickups/ammo/shotgun ammo.png"));
				break;
		}
	}
}
