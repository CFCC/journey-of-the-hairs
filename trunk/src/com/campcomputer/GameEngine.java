package com.campcomputer;

import com.campcomputer.entity.Player;

import java.util.Collection;

public class GameEngine {

    private Tile[][] map;
    private Entity player;
    private Collection<Entity> Entities;


    public GameEngine() {
        InitializeMap();

        player = new Player();
        player.setX(2);
        player.setY(7);
    }

    private void InitializeMap() {
        map = new Tile[16][12];
        for (int x = 0; x < map.length; x++)
            for (int y = 0; y < map[0].length; y++)
                map[x][y] = Tile.AIR;
        for (int i = 0; i < map.length; i++)
            map[i][11] = Tile.GROUND;
        map[6][10] = Tile.PLANT;
//        map[4][10] = Tile.STEM;
        map[5][11] = Tile.CARROT;
    }

    public Entity getPlayer() {
        return player;
    }

    public Collection<Entity> getEntities() {
        return Entities;
    }

    public Tile[][] getMap() {
        return map;
    }

    public void tick() {
        applyGravity();
        applyMovement();
    }

    private void applyMovement() {
        //if gety(player)+1=gety(rock)->stop applying gravity


            player.setyVel(0);
    }

    public void moveForward() {
        player.setxVel(1);
    }

    public void moveBackward() {
        player.setxVel(-1);
    }

    public void jump() {
        player.setyVel(-3);
    }

    public void applyGravity() {
        float newvy=player.getyVel()+1;
        player.setyVel(newvy);
    }

    public void acceleration() {
        //increase velocity/tick
    }

    public void velocity() {
        //increase coordinate/tick
    }

    public void isPlayerClose() {
        //see if enemy is within a certain range of player
    }

    public void isPlayerAbove() {

    }

    public void isPlayerBelow() {

    }

}

