package com.campcomputer.journeyofthehairs.map;

import com.campcomputer.journeyofthehairs.entity.Entity;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Map {
	private static final String fileName = "saved%20maps.ser";

	/**
	 * Database of all saved maps.
	 * <p/>
	 * Index 0 is reserved for temp maps (portals). 1-3 are game saves
	 */
	private static ArrayList<Map> maps = new ArrayList<Map>();

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

	public static void saveMap(Map map) {
		maps.add(map);
	}

	public static void saveMap(Map map, int index) {
		maps.set(index, map);
	}

	public static Map getMap(int index) {
		return maps.get(index);
	}

	public static ArrayList<Map> LoadMaps() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fin);
		ArrayList<Map> maps = (ArrayList<Map>) ois.readObject();
		ois.close();
		return maps;
	}

	private static void SaveMaps(ArrayList<Map> maps) throws IOException {
		if (new File(fileName).exists()) {
			System.out.println("Any previous maps not loaded have been deleted.");
		}

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(maps);
		out.close();
	}

	public Tile[][] getTiles() {
		return map;
	}

	public BufferedImage getImage() {
		return image;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}
}
