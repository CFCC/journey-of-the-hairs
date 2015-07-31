package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.weapon.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class WeaponPickup extends Pickup {
	com.campcomputer.journeyofthehairs.entity.weapon.Weapon.Weapons type;
	private List<BufferedImage> pistolFrame;
	private List<BufferedImage> minigunFrame;
	private List<BufferedImage> railgunFrame;
	private List<BufferedImage> grenadeGunFrame;
	private List<BufferedImage> rifleFrame;
	private List<BufferedImage> shotgunFrame;

	public WeaponPickup(com.campcomputer.journeyofthehairs.entity.weapon.Weapon.Weapons type, PhysicsEngine engine) {
		super(engine);
		this.type = type;

		switch (type) {
			case GRENADE_GUN:
				frames = grenadeGunFrame;
				break;
			case PISTOL:
				frames = pistolFrame;
				break;
			case SHOTGUN:
				frames = shotgunFrame;
				break;
			case RIFLE:
				frames = rifleFrame;
				break;
			case RAILGUN:
				frames = railgunFrame;
				break;
			case MINIGUN:
				frames = minigunFrame;
				break;
		}
	}

	@Override
	public void affectGame() {
		switch (type) {
			case GRENADE_GUN:
				getEngine().getPlayer().setWeapon(new GrenadeGun(getEngine()));
				break;
			case PISTOL:
				getEngine().getPlayer().setWeapon(new Pistol(getEngine()));
				break;
			case SHOTGUN:
				getEngine().getPlayer().setWeapon(new Shotgun(getEngine()));
				break;
			case RIFLE:
				getEngine().getPlayer().setWeapon(new Rifle(getEngine()));
				break;
			case RAILGUN:
				getEngine().getPlayer().setWeapon(new Railgun(getEngine()));
				break;
			case MINIGUN:
				getEngine().getPlayer().setWeapon(new MiniGun(getEngine()));
				break;
		}
	}

	@Override
	protected void addImagesOfEntityToFrames() {
		pistolFrame = new ArrayList<BufferedImage>();
		minigunFrame = new ArrayList<BufferedImage>();
		railgunFrame = new ArrayList<BufferedImage>();
		grenadeGunFrame = new ArrayList<BufferedImage>();
		rifleFrame = new ArrayList<BufferedImage>();
		shotgunFrame = new ArrayList<BufferedImage>();

		pistolFrame.add(Images.ReadImage("/images/weapons/pistol.png"));
		minigunFrame.add(Images.ReadImage("/images/weapons/minigun.png"));
		railgunFrame.add(Images.ReadImage("/images/weapons/railgun.png"));
		grenadeGunFrame.add(Images.ReadImage("/images/weapons/grenade gun.png"));
		rifleFrame.add(Images.ReadImage("/images/weapons/rifle.png"));
		shotgunFrame.add(Images.ReadImage("/images/weapons/shotgun.png"));
	}
}
