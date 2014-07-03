package com.campcomputer.journeyofthehairs.map;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.Tile;
import com.campcomputer.journeyofthehairs.Weapons;
import com.campcomputer.journeyofthehairs.entity.creatures.ChuckNorris;
import com.campcomputer.journeyofthehairs.entity.creatures.DragonFly;
import com.campcomputer.journeyofthehairs.entity.creatures.RocketWorm;
import com.campcomputer.journeyofthehairs.entity.creatures.SuicideStinkBug;
import com.campcomputer.journeyofthehairs.entity.pickup.*;

import java.awt.image.BufferedImage;

public class World1Stage1 extends Map implements Weapons {
	/**
	 * This is the tile array that represents the map of level 1-1. It was created by a combination of ideas from all
	 * original contributors of the project. It has several garden themed obstacles: potatoes, carrots, and tomatoes.
	 * At the end of this level is the undefeatable, at least until camp ended and more features were added, boss,
	 * Chuck Norris. This level also features several regular enemies, real and imaginary: a dragonfly (a fly that is a
	 * dragon), a rocket shooting worm, and a suicide stink bug.
	 */
	private static final Tile[][] theMap = {
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
	};

	private static final BufferedImage theImage = Images.ReadImage("levels/1-1");

	public World1Stage1(GameEngine engine, MapListener mapListener) {
		map = theMap;
		image = theImage;

		ChuckNorris chuckNorris = new ChuckNorris(engine, mapListener);
		chuckNorris.setX(map.length - 5);
		chuckNorris.setY(2);

		DragonFly dragonFly = new DragonFly(engine, mapListener);
		dragonFly.setX(3);
		dragonFly.setY(3);

		SuicideStinkBug stinkbug = new SuicideStinkBug(engine, mapListener);
		stinkbug.setX(9);
		stinkbug.setY(7);

		RocketWorm worm = new RocketWorm(engine, mapListener);
		worm.setX(32);
		worm.setY(9);

		com.campcomputer.journeyofthehairs.entity.pickup.Weapon rifle = new com.campcomputer.journeyofthehairs.entity.pickup.Weapon(Weapon.RIFLE, engine, mapListener);
		rifle.setX(1);
		rifle.setY(7);

		com.campcomputer.journeyofthehairs.entity.pickup.Weapon minigun = new com.campcomputer.journeyofthehairs.entity.pickup.Weapon(Weapon.MINIGUN, engine, mapListener);
		minigun.setX(3);
		minigun.setY(7);

		com.campcomputer.journeyofthehairs.entity.pickup.Weapon pistol = new com.campcomputer.journeyofthehairs.entity.pickup.Weapon(Weapon.PISTOL, engine, mapListener);
		pistol.setX(5);
		pistol.setY(7);

		com.campcomputer.journeyofthehairs.entity.pickup.Weapon shotgun = new com.campcomputer.journeyofthehairs.entity.pickup.Weapon(Weapon.SHOTGUN, engine, mapListener);
		shotgun.setX(9);
		shotgun.setY(7);

		com.campcomputer.journeyofthehairs.entity.pickup.Weapon grenadeGun = new com.campcomputer.journeyofthehairs.entity.pickup.Weapon(Weapon.GRENADE_GUN, engine, mapListener);
		grenadeGun.setX(11);
		grenadeGun.setY(7);

		Portal portal = new Portal(engine, mapListener);
		portal.setX(17);
		portal.setY(5);

		entities.add(portal);
//		entities.add(dragonFly);
		entities.add(stinkbug);
		entities.add(worm);
		entities.add(chuckNorris);

		entities.add(rifle);
		entities.add(minigun);
		entities.add(pistol);
		entities.add(shotgun);
		entities.add(grenadeGun);

		entities.add(portal);
	}
}
