package com.campcomputer.journeyofthehairs.map;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.Tile;

import java.awt.image.BufferedImage;

/**
 * Literally every single game makes the whole plot tons more difficult by putting a level under water. Bam.
 */
public class Water extends Map {
	private static final Tile[][] leMap = {
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER,  Tile.GROUND, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.GROUND,  Tile.GROUND, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER, Tile.WATER,  Tile.GROUND,  Tile.GROUND,  Tile.GROUND, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER,  Tile.GROUND, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER, Tile.WATER,  Tile.GROUND,  Tile.GROUND,  Tile.GROUND, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER,  Tile.GROUND, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.WATER, Tile.WATER,  Tile.WATER,  Tile.GROUND,  Tile.GROUND, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.AIR, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.WATER,  Tile.WATER, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
			{Tile.AIR, Tile.GROUND, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.GROUND},
	};

	private static final BufferedImage leImage = Images.ReadImage("levels/water");

	public Water(GameEngine engine) {
		super();
		map = leMap;
		image = leImage;
	}
}
