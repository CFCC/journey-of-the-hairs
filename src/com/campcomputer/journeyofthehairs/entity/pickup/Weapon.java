package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.Weapons;
import com.campcomputer.journeyofthehairs.map.MapListener;
import com.campcomputer.journeyofthehairs.weapon.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Weapon extends Pickup implements Weapons {
	Weapons.Weapon type;
	private List<BufferedImage> pistolFrame;
	private List<BufferedImage> minigunFrame;
	private List<BufferedImage> railgunFrame;
	private List<BufferedImage> grenadeGunFrame;
	private List<BufferedImage> rifleFrame;
	private List<BufferedImage> shotgunFrame;

	public Weapon(Weapons.Weapon type, GameEngine engine, MapListener mapListener) {
		super(engine, mapListener);
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
				engine.getPlayer().setWeapon(new GrenadeGun());
				break;
			case PISTOL:
				engine.getPlayer().setWeapon(new Pistol());
				break;
			case SHOTGUN:
				engine.getPlayer().setWeapon(new Shotgun());
				break;
			case RIFLE:
				engine.getPlayer().setWeapon(new Rifle());
				break;
			case RAILGUN:
				engine.getPlayer().setWeapon(new Railgun());
				break;
			case MINIGUN:
				engine.getPlayer().setWeapon(new MiniGun());
				break;
		}
	}

	@Override
	protected void loadImages() {
		pistolFrame = new ArrayList<BufferedImage>();
		minigunFrame = new ArrayList<BufferedImage>();
		railgunFrame = new ArrayList<BufferedImage>();
		grenadeGunFrame = new ArrayList<BufferedImage>();
		rifleFrame = new ArrayList<BufferedImage>();
		shotgunFrame = new ArrayList<BufferedImage>();

		pistolFrame.add(Images.ReadImage("weapons/pistol"));
		minigunFrame.add(Images.ReadImage("weapons/minigun"));
		railgunFrame.add(Images.ReadImage("weapons/railgun"));
		grenadeGunFrame.add(Images.ReadImage("weapons/grenade gun"));
		rifleFrame.add(Images.ReadImage("weapons/rifle"));
		shotgunFrame.add(Images.ReadImage("weapons/shotgun"));
	}
}
