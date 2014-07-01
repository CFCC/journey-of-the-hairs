package com.campcomputer.journeyofthehairs.map;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Tile;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.pickup.Pickup;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Map {
	/**
	 * The map to be used as the tile array in the engine variable
	 */
	protected Tile[][] map;

	/**
	 * The buffered image used as a background in the game panel
	 */
	protected BufferedImage image;

	/**
	 * List of entities in the map
	 */
	protected ArrayList<Entity> entities = new ArrayList<Entity>();

	/**
	 * Database of all saved maps.
	 *
	 * Index 0 is reserved for temp maps (portals). 1-3 are game saves
	 */
	private static ArrayList<Map> maps = new ArrayList<Map>();

	public Tile[][] getMap() {
		return map;
	}

	public BufferedImage getImage() {
		return image;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public static void saveMap(Map map) {
		maps.add(map);
	}

	public static Map loadMap(int index) {
		return maps.get(index);
	}
}
