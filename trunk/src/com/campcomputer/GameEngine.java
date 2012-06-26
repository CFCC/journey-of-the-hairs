package com.campcomputer;

import java.util.Collection;

public class GameEngine {
    final static int MAIN_CHAR = 1;

    Entity player;
    Collection<Entity> Entities;


    public GameEngine() {
        InitializeMap();
    }

    private void InitializeMap() {
        Tile[][] Map = new Tile[16][12];
        for (int x = 0; x < Map.length; x++)
            for (int y = 0; y < Map[0].length; y++)
                Map[x][y] = Tile.AIR;
        for (int i = 0; i < Map.length; i++)
            Map[i][11] = Tile.GROUND;
        Map[6][10] = Tile.TOMATO;
        Map[4][10] = Tile.STEM;
        Map[5][11] = Tile.PIT;
    }

    public Entity getPlayer() {
        return player;
    }

    public Collection<Entity> getEntities() {
        return Entities;
    }


    public void tick(){

    }
    public void moveForward(){
        player.setxVel(1);
    }
    public void jump(){
        player.setyVel(3);
    }
    public void gravity(){
        player.setyVel(-1);
    }
    public void acceleration(){
        //increase velocity/tick
    }
    public void velocity(){
        //increase coordinate/tick
    }
}

