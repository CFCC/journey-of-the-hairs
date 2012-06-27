package com.campcomputer;

import com.campcomputer.entity.Player;

import java.util.Collection;

public class GameEngine {

    private Tile[][] Map;
    private Entity player;
    private Collection<Entity> Entities;


    public GameEngine() {
        InitializeMap();

        player = new Player();
        player.setX(2);
        player.setY(7);
    }

    private void InitializeMap() {
        Map = new Tile[200][12];
        for (int x = 0; x < Map.length; x++)
            for (int y = 0; y < Map[0].length; y++)
                Map[x][y] = Tile.AIR;
        for (int i = 0; i < Map.length; i++)
            Map[i][11] = Tile.GROUND;
        Map[6][10] = Tile.PLANT;
//        Map[4][10] = Tile.STEM;
        Map[5][11] = Tile.PIT;
        Map[4][10] = Tile.CARROT;
    }

    public Entity getPlayer() {
        return player;
    }

    public Collection<Entity> getEntities() {
        return Entities;
    }

    public Tile[][] getMap() {
        return Map;
    }

    public void tick() {
        applyGravity();
    }

    public void moveForward() {
        player.setxVel(1);
    }

    public void moveBackward() {
        player.setxVel(-1);
    }

    public void jump() {
        player.setyVel(3);
    }

    public void applyGravity() {
        player.setyVel(-1);
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
        //if player is on a platform, he shouldn't fall
    }

    public void isPlayerBelow() {
        //
    }

}

