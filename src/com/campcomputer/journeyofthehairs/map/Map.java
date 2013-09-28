package com.campcomputer.journeyofthehairs.map;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Tile;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.pickup.Pickup;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Map {
    /**
     * The map to be used as the tile array in the engine variable
     */
    public Tile[][] map;

    /**
     * The buffered image used as a background in the game panel
     */
    public BufferedImage image;

    /**
     * Database of all saved maps. Index format:
     *
     * 0: Name
     * 1: Map instance
     * 2: Entity list
     * 3: Pickup list
     * 4: Player X
     * 5: Player Y
     */
    public static ArrayList<ArrayList> maps = new ArrayList<ArrayList>();

    public static void saveMap(String name, Tile[][] map, ArrayList<Entity> entities, ArrayList<Pickup> pickups, int x, int y) {
        ArrayList<Object> mapData = new ArrayList<Object>();
        mapData.add(name);
        mapData.add(map);
        mapData.add(entities);
        mapData.add(pickups);
        mapData.add(x);
        mapData.add(y);

        maps.add(mapData);
    }

    public static void loadMap(String name, GameEngine engine) {
        for (int i = 0; i < maps.size() - 1; i++) {
            if (maps.get(i).get(0).equals(name)) {
                engine.setMap((Map) maps.get(i).get(1));
                for (Entity entity : (ArrayList<Entity>) maps.get(i).get(2)) {
                    engine.addEntity(entity);
                }
                for (Pickup pickup : (ArrayList<Pickup>) maps.get(i).get(3)) {
                    engine.addPickup(pickup);
                }

                engine.getPlayer().setX((Float) maps.get(i).get(4));
                engine.getPlayer().setY((Float) maps.get(i).get(5));
            }
        }
    }
}
