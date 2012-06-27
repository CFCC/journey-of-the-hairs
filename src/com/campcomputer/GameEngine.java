package com.campcomputer;

import com.campcomputer.entity.ChuckNorris;
import com.campcomputer.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameEngine {

    private Tile[][] map;
    private Entity player;
    private ArrayList<Entity> entities = new ArrayList<Entity>();


    public GameEngine() {
        InitializeMap();

        player = new Player(this);
        player.setX(10);
        player.setY(10);

        entities.add(player);
        entities.add(new ChuckNorris(this));
    }

    private void InitializeMap() {
        map = new Tile[200][12];
        for (int x = 0; x < map.length; x++)
            for (int y = 0; y < map[0].length; y++)
                map[x][y] = Tile.AIR;
        for (int i = 0; i < map.length; i++)
            map[i][11] = Tile.GROUND;
        map[6][10] = Tile.CHEESE;
        map[5][10] = Tile.CHEESE;
        map[5][9] = Tile.CHEESE;
        map[6][9] = Tile.CHEESE;
        map[5][8] = Tile.CHEESE;
        map[6][8] = Tile.CHEESE;

    }

    public Entity getPlayer() {
        return player;
    }

    public Collection<Entity> getEntities() {
        return entities;
    }

    public Tile[][] getMap() {
        return map;
    }

    public void tick() {
        applyMovement();
    }

    private void applyMovement() {
        float playerY = player.getY();
        float playerX = player.getX();
        while (map[((int) playerX)][((int) (playerY + 1))] != Tile.GROUND) {
            float newvy = player.getyVel() + 1;
            player.setyVel(newvy);
            playerY++;
            if (map[((int) playerX)][((int) (playerY + 1))] == Tile.GROUND) {
                player.setyVel(0);
                player.setY(playerY);
            }
        }
    }

    public void moveForward() {
        player.setxVel(1);
    }

    public void moveBackward() {
        player.setxVel(-1);
    }

    public void jump() {
        float playerY = player.getY();
        float playerOldY = player.getY();
        //float playerX = player.getX();
        player.setyVel(-2);
        /*while (map[((int) playerX)][((int) (playerY - 1))] != Tile.GROUND && playerOldY - 2 != playerY) {
            player.setyVel(-2);
            playerY = playerY--;
            if (map[((int) playerX)][((int) (playerY - 1))] == Tile.GROUND)
                applyMovement();
        }*/
        if (playerOldY - 2 == playerY)
            applyMovement();
    }

    public void acceleration() {
        //increase velocity/tick
    }

    public void velocity() {
        //increase coordinate/tick
    }

    public boolean isPlayerClose() {
        //see if enemy is within a certain range of player
        return false;
    }

    public boolean isPlayerAbove() {
        return false;
    }

    public void isPlayerBelow() {

    }

}

