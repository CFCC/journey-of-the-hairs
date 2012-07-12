package com.campcomputer;

import com.campcomputer.entity.*;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;

import static com.campcomputer.Tile.*;

public class GameEngine {
    private static final float GRAVITY = .2f;
    private static final float JUMP_POWER = -1.5f;
    private static final float MOVE_SPEED = .3f;
    public static int whatWeapon;

    private Tile[][] map = {
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, PLANT, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, PLANT, AIR, AIR, PLANT, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, PLANT, AIR, PLANT, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, PLANT, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, CARROT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CARROT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, PLANT, PLANT, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CHUCKNORRIS, CHUCKNORRIS, CHUCKNORRIS, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CHUCKNORRIS, CHUCKNORRIS, CHUCKNORRIS, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, CHUCKNORRIS, CHUCKNORRIS, CHUCKNORRIS, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
            {AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, GROUND,},
    };

    private Player player;
    private ChuckNorris chuckNorris;
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private ArrayList<Entity> entitiesToAdd = new ArrayList<Entity>();
    private ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();

    public GameEngine() {

        player = new Player(this);
        player.setX(1);
        player.setY(0);

        ChuckNorris chuckNorris = new ChuckNorris(this);
        chuckNorris.setX(map.length - 5);
        chuckNorris.setY(2);

        DragonFly dragonFly = new DragonFly(this);
        dragonFly.setX(3);
        dragonFly.setY(3);

        SuicideStinkBug stinkbug = new SuicideStinkBug(this);
        stinkbug.setX(9);
        stinkbug.setY(7);

        RocketWorm worm = new RocketWorm(this);
        worm.setX(32);
        worm.setY(9);


        entities.add(player);
        entities.add(chuckNorris);
        entities.add(dragonFly);
        entities.add(stinkbug);
        entities.add(worm);

        whatWeapon = 0;
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
        entities.addAll(entitiesToAdd);
        entities.removeAll(entitiesToRemove);
        entitiesToAdd.clear();
        entitiesToRemove.clear();

        for (Entity entity : entities) {
            entity.tick();
        }
        applyGravity();
        applyMovement();
        if (player.getHealth() <= 0)
            System.exit(0);
    }

    private void applyGravity() {
        for (Entity entity : entities) {
            if (entity.isAffectedByGravity())
                entity.setyVel(entity.getyVel() + GRAVITY);
        }
    }

    private void applyMovement() {
        for (Entity entity : entities) {

            float x = entity.getX();
            float y = entity.getY();
            float vX = entity.getxVel();
            float vY = entity.getyVel();
            float height = entity.getHeight();

            float newX = x + vX;
            float newY = y + vY;

            if (entity.isAffectedByHitDetection()) {
                // Do vertical collision detection only if we are falling (allows for jumping up through platforms)
                if (vY > 0) {

                    Point landingPoint1 = findFirstSolid(x, y + height, 0, 1, 0, 0, map.length - 1, map[0].length - 1);
                    Point landingPoint2 = findFirstSolid(x + 1, y + height, 0, 1, 0, 0, map.length - 1, map[0].length - 1);

                    if (landingPoint1 != null || landingPoint2 != null) {
                        int highestLandingPoint;
                        if (landingPoint1 != null) {
                            highestLandingPoint = landingPoint1.y;
                            if (landingPoint2 != null && landingPoint2.y < highestLandingPoint)
                                highestLandingPoint = landingPoint2.y;
                        } else {
                            highestLandingPoint = landingPoint2.y;
                        }
                        if (newY >= highestLandingPoint - height) {
                            newY = highestLandingPoint - height;
                            entity.setyVel(0);
                        }
                    }
                }
                // Do horizontal collision detection only if we are standing still or falling
                if (vY >= GRAVITY) {
                    Point leftWall = findFirstSolid(x, y, -1, 0, 0, 0, map.length - 1, map[0].length - 1);
                    Point rightWall = findFirstSolid(x + 1, y, 1, 0, 0, 0, map.length - 1, map[0].length - 1);
                    if (leftWall != null && newX < leftWall.x + 1)
                        newX = leftWall.x + 1;
                    if (rightWall != null && newX > rightWall.x - 1)
                        newX = rightWall.x - 1;
                }

                if (newX < 0f) {
                    newX = 0;
                }
                float rightEdge = map.length - 1;
                if (newX > rightEdge) {
                    newX = rightEdge;
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

    public void startMoveForward() {
        player.setxVel(MOVE_SPEED);
    }

    public void endMoveForward() {
        player.setxVel(0);
    }

    public void startMoveBackward() {
        player.setxVel(-MOVE_SPEED);
    }

    public void endMoveBackward() {
        player.setxVel(0);
    }

    public void jump() {
        Point firstSolid = findFirstSolid(player.getX(), player.getY(), 0, 1, 0, 0, map.length, map[0].length);
        if (firstSolid != null && firstSolid.y - player.getY() <= 1) {
            player.setyVel(JUMP_POWER);
        }
    }

    public boolean isPlayerClose(Entity entity) {

        return getDistanceBetweenEntityAndPlayer(entity) < 10f;
    }

    public double getDistanceBetweenEntityAndPlayer(Entity entity) {
        Point2D playerPosition = new Point2D.Float(player.getX(), player.getY());
        Point2D entityPosition = new Point2D.Float(entity.getX(), entity.getY());

        return playerPosition.distance(entityPosition);
    }

    public boolean isOnTopOfPlayer(Entity entity) {
        return getDistanceBetweenEntityAndPlayer(entity) < 2f;
    }

    public boolean isOnTopOfPlayerChuckNorris () {
        float pX = player.getX();
        float pY = player.getY();
        if(map [((int) pX)] [((int) pY)] == Tile.CHUCKNORRIS)
            return true;
        else
            return false;
    }

    public boolean isPlayerAbove(Entity entity) {
        if (player.getY() > entity.getY())
            return true;
        else
            return false;
    }

    public boolean isPlayerToLeft(Entity entity) {
        if (player.getX() < entity.getX())
            return true;
        else
            return false;
    }

    public void shoot(/*float x, float y*/) {
        float playerX = player.getX();
        float playerY = player.getY();
        if (player.isFacingLeft()) {
            ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();
            for (Entity entity : entities) {
                if (!(entity instanceof Player)) {
                    Point2D shootLocation = new Point2D.Float(playerX - 1, playerY);
                    Point2D entityLocation = new Point2D.Float(entity.getX(), entity.getY());
                    if (shootLocation.distance(entityLocation) < 1) {
                        if (!entity.attacked())
                            entitiesToRemove.add(entity);
                    }
                }
            }
            entities.removeAll(entitiesToRemove);
        }

        if (player.isFacingRight()) {
            ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();
            for (Entity entity : entities) {
                if (!(entity instanceof Player)) {
                    Point2D shootLocation = new Point2D.Float(playerX + 1, playerY);
                    Point2D entityLocation = new Point2D.Float(entity.getX(), entity.getY());

                    if (shootLocation.distance(entityLocation) < 1) {
                        if (!entity.attacked())
                            entitiesToRemove.add(entity);
                    }
                }
            }
            entities.removeAll(entitiesToRemove);
        }

    }

    public void addEntity(Entity entity) {
        entitiesToAdd.add(entity);
    }

    public void removeEntity(Entity entity) {
        entitiesToRemove.add(entity);
    }

    public void getGrenadeGun() {
        if (map[((int) player.getX())][((int) player.getY())] == Tile.GRENADEGUN) {
            //change weapon to grenade gun
        }
    }

    public void getMiniGun() {

    }

    public void getPistol() {
        if (whatWeapon == 0) {
            //have a pistol by default
        }
    }

    public void getRailgun() {

    }

    public void getRifle() {

    }

    public void getShotgun() {

    }

    public void userInfoBar() {

    }

    public void directions() {

    }
}

