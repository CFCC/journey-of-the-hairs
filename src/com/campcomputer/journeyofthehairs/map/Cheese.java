package com.campcomputer.journeyofthehairs.map;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.Tile;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.SuicideStinkBug;
import com.campcomputer.journeyofthehairs.entity.pickup.Health;
import com.campcomputer.journeyofthehairs.entity.pickup.Portal;
import com.campcomputer.journeyofthehairs.entity.pickup.WeaponPickup;
import com.campcomputer.journeyofthehairs.entity.weapon.Weapon;

import java.awt.image.BufferedImage;

public class Cheese extends Map {

	/**
	 * This map is made completely of cheese. The idea for the map originates to a joke between the two boys who
	 * coded the Images class. The joke first started as a bug fix; if there were no frames for an entity, its image/frame
	 * was an image of cheese. This soon grew into an idea: what if there were a cheese level? After more than a year,
	 * the secret cheese level with the one weapon that could defeat Chuck Norris (yes, that last bit got added in
	 * later in the week) is implemented. The level is the same as the end of level 1-1 in Super Mario Bros. The Railgun
	 * in the end of the level teleports the player back to the first level.
	 */
	private static final Tile[][] cheeseMap = {
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
			{Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
			{Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},

	};

	private static final BufferedImage theImage = Images.ReadImage("/images/levels/cheese.png");

	/**
	 * The constructor for the level
	 */
	public Cheese(final PhysicsEngine engine, final Map currentMap) {
		Map.saveMap(currentMap);

		map = cheeseMap;
		image = theImage;

		SuicideStinkBug suicideStinkBug = new SuicideStinkBug(engine);
		suicideStinkBug.setX(37);
		suicideStinkBug.setY(10);
		engine.addEntity(suicideStinkBug);

		SuicideStinkBug suicideStinkBug1 = new SuicideStinkBug(engine);
		suicideStinkBug1.setX(38);
		suicideStinkBug1.setY(10);
		engine.addEntity(suicideStinkBug1);

		WeaponPickup railgun = new WeaponPickup(Weapon.Weapons.RAILGUN, engine) {
			@Override
			public void affectGame() {
				Map.getMap(0);
				for (Entity entity : engine.getEntities()) {
					if (entity instanceof Portal) {
						engine.removeEntity(entity);
					}
				}
			}
		};
		railgun.setX(cheeseMap.length - 4);
		railgun.setY(8);
		engine.addEntity(railgun);

		Health health = new Health(engine, 50);
		health.setX(37);
		health.setY(5);

		engine.getPlayer().setX(0);
		engine.getPlayer().setY(0);
	}
}
