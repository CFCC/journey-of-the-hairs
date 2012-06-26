package com.campcomputer;

import java.util.Collection;

public class GameEngine {
    final static int MAIN_CHAR = 1;
    final static int TOMATO = 2;
    final static int STEM = 3;
    final static int PIT = 4;
    final static int AIR = 5;
    final static int GROUND = 6;

    Entity player;
    Collection<Entity> Entities;


    public GameEngine() {
        InitializeMap();
    }

    private void InitializeMap() {
        int[][] Map = new int[16][12];
        for (int x = 0; x < Map.length; x++)
            for (int y = 0; y < Map[0].length; y++)
                Map[x][y] = AIR;
        for (int i = 0; i < Map.length; i++)
            Map[i][11] = GROUND;
        Map[0][10] = MAIN_CHAR;
        Map[6][10] = TOMATO;
        Map[4][10] = STEM;
        Map[5][11] = PIT;
    }

    public Entity getPlayer() {
        return player;
    }

    public Collection<Entity> getEntities() {
        return Entities;
    }


    public void tick(){

    }
}
