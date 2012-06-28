package com.campcomputer;

import com.campcomputer.entity.*;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;

import static com.campcomputer.Tile.*;

public class GameEngine {

    private static final float GRAVITY = .2f;
    private static final float MINIMUM_X_VELOCITY = .3f;
    private static final float JUMP_POWER = -1.5f;
    private static final float MOVE_SPEED = .3f;

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

        DragonFly dragonFly = new DragonFly(this);
        dragonFly.setX(3);
        dragonFly.setY(3);

        SuicideStinkBug stinkbug = new SuicideStinkBug(this);
        stinkbug.setX(9);
        stinkbug.setY(1);

        RocketWorm worm = new RocketWorm(this);
        worm.setX(7);
        worm.setY(8);



        entities.add(player);
        entities.add(chuckNorris);
        entities.add(dragonFly);
        entities.add(stinkbug);
        entities.add(worm);
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
        applyGravity();
        applyMovement();
    }

    private void applyGravity() {
        for (Entity entity : entities) {
            if (entity.isAffectedByGravity())
                entity.setyVel(entity.getyVel() + GRAVITY);
        }
    }

    private void applyMovement() {
//        float pY = player.getY();
//        float playerX = player.getX();
//        //gravity accelerates player if no ground below player
//        //find if not air below
//        float playerYVel = player.getyVel();
//        player.setyVel(playerYVel++);
//        player.setY(pY + playerYVel);
//        pY = player.getY();
//        if (pY - 1 < 0)
//            player.setyVel(0);
//        else if (map[((int) playerX)][((int) (pY - 1))] != Tile.AIR)
//            player.setyVel(0);
//
//
//        // player doesn't fall through ground
//        if (map[((int) playerX)][((int) (pY + 1))] != Tile.AIR) {
//            float playerRoundY = player.getY() - (player.getY() % 1);
//            player.setyVel(0);
//            player.setY(playerRoundY + 1);
//        }
//        if (playerX - 1 == 0)
//            moveForward();
//        if (pY - 1 == 0)
//            player.setY(1);
//
//        if (pY < 0)
//            player.setY(1);
//        // player doesn't run through blocks
//        if (map[((int) playerX + 1)][((int) (pY))] != Tile.AIR && player.getxVel() > 0)
//            //only go left
//            player.setxVel(0);
//        if (player.getX() - 1 < 0) {
//            player.setxVel(0);
//            moveForward();
//        } else if (map[((int) playerX - 1)][((int) (pY))] != Tile.AIR && player.getxVel() > 0)
//            //only go right
//            player.setxVel(0);


        for (Entity entity : entities) {

            float x = entity.getX();
            float y = entity.getY();
            float vX = entity.getxVel();
            float vY = entity.getyVel();

            float newX = x + vX;
            float newY = y + vY;

            // Slow x movement
            entity.setxVel(vX * MINIMUM_X_VELOCITY);
            if (Math.abs(vX) < .1)
                entity.setxVel(0);

            Point landingPoint1 = findFirstSolid(x, y, 0, 1, 0, 0, map.length, map[0].length);
            Point landingPoint2 = findFirstSolid(x+1, y, 0, 1, 0, 0, map.length, map[0].length);

            if (landingPoint1 != null || landingPoint2 != null) {
                int highestLandingPoint;
                if (landingPoint1 != null){
                    highestLandingPoint = landingPoint1.y;
                    if (landingPoint2 != null && landingPoint2.y < highestLandingPoint)
                        highestLandingPoint = landingPoint2.y;
                }else{
                    highestLandingPoint = landingPoint2.y;
                }
                if (newY >= highestLandingPoint - 1) {
                    newY = highestLandingPoint - 1;
                    entity.setyVel(0);
                }
            }
            entity.setX(newX);
            entity.setY(newY);
        }

    }

    private Point findFirstSolid(float startX, float startY, int dX, int dY, int minX, int minY, int maxX, int maxY) {
        int x = (int) startX;
        int y = (int) startY;
        while (x <= maxX && y <= maxY && x >= minX && y >= minY) {

            switch (map[x][y]) {

                case PLANT:
                case LETTUCE:
                case CARROT:
                case GROUND:
                    return new Point(x, y);
            }

            x += dX;
            y += dY;
        }
        return null;
    }

    public void moveForward() {
        player.setxVel(MOVE_SPEED);
    }

    public void moveBackward() {
        player.setxVel(-MOVE_SPEED);
    }

    public void jump() {
        Point firstSolid = findFirstSolid(player.getX(), player.getY(),0,1,0,0,map.length, map[0].length);
        if (firstSolid!= null && firstSolid.y- player.getY() <= 1)
            player.setyVel(JUMP_POWER);
    }

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

