package com.campcomputer;

import com.campcomputer.entity.ChuckNorris;
import com.campcomputer.entity.Player;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;

import static com.campcomputer.Tile.*;

public class GameEngine {

    private Tile[][] map = {
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, PLANT, AIR, AIR, AIR, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, AIR, AIR, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, AIR, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, AIR, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, PLANT, AIR, AIR, PLANT, AIR, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, PLANT, AIR, AIR, PLANT, AIR, AIR, GROUND, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND, GROUND,},
    };
    private Player player;
    private ArrayList<Entity> entities = new ArrayList<Entity>();


    public GameEngine() {
        InitializeMap();

        player = new Player(this);
        player.setX(1);
        player.setY(0);

        ChuckNorris chuckNorris = new ChuckNorris(this);
        chuckNorris.setX(5);
        chuckNorris.setY(5);

        entities.add(player);
        entities.add(chuckNorris);
    }

    private void InitializeMap() {

/* Each line is one row of tiles; each column is one column */
//        map = new Tile[200][12];
//        for (int x = 0; x < map.length; x++)
//            for (int y = 0; y < map[0].length; y++)
//                map[x][y] = Tile.AIR;
//        for (int i = 0; i < map.length; i++)
//        map[i][11] = Tile.GROUND;
//        map[6][10] = Tile.CHEESE;
//        map[5][10] = Tile.CHEESE;
//        map[5][9] = Tile.CHEESE;
//        map[6][9] = Tile.CHEESE;
//        map[5][8] = Tile.CHEESE;
//        map[6][8] = Tile.CHEESE;

    }

    public Player getPlayer() {
        return player;
    }

    public Collection<Entity> getEntities() {
        return entities;
    }

    public Tile[][] getMap() {
        return map;
    }

    public void tick() {
        for (Entity entity : entities) {
            entity.tick();
        }
        applyMovement();
    }

    private void applyMovement() {
        float playerY = player.getY();
        float playerX = player.getX();
        //gravity accelerates player if no ground below player
        //find if not air below
        float playerYVel = player.getyVel();
        player.setyVel(playerYVel++);
        player.setY(playerY + playerYVel);
        playerY = player.getY();
        if (playerY - 1 < 0)
            player.setyVel(0);
        else if (map[((int) playerX)][((int) (playerY - 1))] != Tile.AIR)
            player.setyVel(0);


        // player doesn't fall through ground
        if (map[((int) playerX)][((int) (playerY + 1))] != Tile.AIR) {
            float playerRoundY = player.getY() - (player.getY() % 1);
            player.setyVel(0);
            player.setY(playerRoundY + 1);
        }
        if (playerX - 1 == 0)
            moveForward();
        if (playerY - 1 == 0)
            player.setY(1);

        if (playerY < 0)
            player.setY(1);
        // player doesn't run through blocks
        if (map[((int) playerX + 1)][((int) (playerY))] != Tile.AIR && player.getxVel() > 0)
            //only go left
            player.setxVel(0);
        if (player.getX() - 1 < 0) {
            player.setxVel(0);
            moveForward();
        } else if (map[((int) playerX - 1)][((int) (playerY))] != Tile.AIR && player.getxVel() > 0)
            //only go right
            player.setxVel(0);


        for (Entity entity : entities) {
            entity.setX(entity.getX() + entity.getxVel());
            entity.setY(entity.getY() + entity.getyVel());


            entity.setxVel(entity.getxVel() * .3f);
            if (Math.abs(entity.getxVel()) < .1)
                entity.setxVel(0);
            entity.setyVel(entity.getyVel() * .3f);
            if (Math.abs(entity.getyVel()) < .1)
                entity.setyVel(0);
        }

    }

    public void moveForward() {
        player.setxVel(1);
    }

    public void moveBackward() {
        player.setxVel(-1);
    }

    public void jump() {
        //  if(map[((int) player.getX())][((int) player.getY()-1)]!=Tile.AIR){
        float playerOldY = player.getY();
        //float playerX = player.getX();
        player.setyVel(-2);
        /*while (map[((int) playerX)][((int) (playerY - 1))] != Tile.GROUND && playerOldY - 2 != playerY) {
            player.setyVel(-2);
            playerY = playerY--;
            if (map[((int) playerX)][((int) (playerY - 1))] == Tile.GROUND)
                applyMovement();
        }*/
        if (playerOldY - 2 == player.getY()) {
            player.setyVel(0);
            player.setY(player.getY() - player.getyVel());
            applyMovement();
        }
    }
//}

    public void acceleration(int x, int y) {
        if (x == 1) {
            velocity(1, player);

        }
        if (x == 2) {
            velocity(2, player);
        }
    }

    public void velocity(int x, Entity object) {
        if (x == 1) {
            int objectX = (int) object.getX();
            objectX++;
            object.setX(objectX);
        }
        if (x == 2) {
            int objectX = (int) object.getX();
            objectX--;
            object.setX(objectX);
        }
    }

    public boolean isPlayerClose(Entity entity) {

        Point2D playerPosition = new Point2D.Float(player.getX(), player.getY());
        Point2D entityPosition = new Point2D.Float(entity.getX(), entity.getY());

        return playerPosition.distance(entityPosition) < 10f;
    }

    public boolean isPlayerAbove(Entity entity) {
        return true;
    }

    public boolean isPlayerBelow(Entity entity) {
        return false;
    }

}

