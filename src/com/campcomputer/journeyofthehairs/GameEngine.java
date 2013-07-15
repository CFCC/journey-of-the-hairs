package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.*;
import com.campcomputer.journeyofthehairs.item.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;

public class GameEngine {
    private static final float GRAVITY = .2f;
    private static final float JUMP_POWER = -1.5f;
    private static final float MOVE_SPEED = .3f;

    public Player player;
    public ChuckNorris chuckNorris;

    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Item> itemsToRemove = new ArrayList<Item>();
    public ArrayList<Entity> entities = new ArrayList<Entity>();
    public ArrayList<Entity> entitiesToAdd = new ArrayList<Entity>();
    public ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();

    private Tile[][] map = {
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.CARROT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CARROT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.PLANT, Tile.PLANT, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
    };

    public GameEngine() {

        player = new Player(this);
        player.setX(0);
        player.setY(9);

        chuckNorris = new ChuckNorris(this);
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

        Rifle rifle = new Rifle(this);
        rifle.setX(1);
        rifle.setY(7);

        MiniGun minigun = new MiniGun(this);
        minigun.setX(3);
        minigun.setY(7);

        Pistol pistol = new Pistol(this);
        pistol.setX(5);
        pistol.setY(7);

        Railgun railgun = new Railgun(this);
        railgun.setX(7);
        railgun.setY(7);

        Shotgun shotgun = new Shotgun(this);
        shotgun.setX(9);
        shotgun.setY(7);

        GrenadeGun grenadeGun = new GrenadeGun(this);
        grenadeGun.setX(11);
        grenadeGun.setY(7);

        entities.add(player);
//        entities.add(dragonFly);
        entities.add(stinkbug);
//        entities.add(worm);
        entities.add(chuckNorris);

//        entities.add(rifle);
//        entities.add(minigun);
//        entities.add(pistol);
//        entities.add(railgun);
//        entities.add(shotgun);
//        entities.add(grenadeGun);
//
//        items.add(rifle);
//        items.add(minigun);
//        items.add(pistol);
//        items.add(railgun);
//        items.add(shotgun);
//        items.add(grenadeGun);

        rifle.setAffectedByGravity(false);
        minigun.setAffectedByGravity(false);
        pistol.setAffectedByGravity(false);
        railgun.setAffectedByGravity(false);
        shotgun.setAffectedByGravity(false);
        grenadeGun.setAffectedByGravity(false);

        player.weapon = new Pistol(this);
        player.getWeapon().addAmmo(100);
    }

    public ChuckNorris getChuckNorris() {
        return chuckNorris;
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

        items.removeAll(itemsToRemove);
        itemsToRemove.clear();

        for (Entity entity : entities) {
            entity.tick();
        }
        applyGravity();
        applyMovement();

        if (player.getHealth() <= 0 && player.lives >= 0)
            player.lives -= 1;

        collectWeapon();
    }


    public void collectWeapon() {
        for (Item item : items) {
            if (isOnTopOfPlayer(item)) {
                getPlayer().setWeapon(item);
                removeEntity(item);
                removeItem(item);
            }
        }
    }

    public void removeItem(Item item) {
        itemsToRemove.add(item);
    }

    private void applyGravity() {
        for (Entity entity : entities) {
            if (entity.isAffectedByGravity())
                entity.setYVel(entity.getYVel() + GRAVITY);
        }
    }

    private void applyMovement() {
        for (Entity entity : entities) {

            float x = entity.getX();
            float y = entity.getY();
            float vX = entity.getXVel();
            float vY = entity.getYVel();
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
                        } else
                            highestLandingPoint = landingPoint2.y;
                        if (newY >= highestLandingPoint - height) {
                            newY = highestLandingPoint - height;
                            entity.setYVel(0);
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
        player.setXVel(MOVE_SPEED);
    }

    public void endMoveForward() {
        player.setXVel(0);
    }

    public void startMoveBackward() {
        player.setXVel(-MOVE_SPEED);
    }

    public void endMoveBackward() {
        player.setXVel(0);
    }

    public void jump() {
        Point firstSolid = findFirstSolid(player.getX(), player.getY(), 0, 1, 0, 0, map.length, map[0].length);
        if (firstSolid != null && firstSolid.y - player.getY() <= 1) {
            player.setYVel(JUMP_POWER);
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

    public boolean isPlayerAbove(Entity entity) {
        return (player.getY() > entity.getY());
    }

    public boolean isPlayerToLeft(Entity entity) {
        return (player.getX() < entity.getX());
    }


    public void addEntity(Entity entity) {
        entitiesToAdd.add(entity);
    }

    public void removeEntity(Entity entity) {
        entitiesToRemove.add(entity);
    }

    public void directions() {
        JourneyOfTheHairsFrame.getTimer().stop();
        JOptionPane.showMessageDialog(JourneyOfTheHairs.getFrame(), "WAD = Movement, S = Shoot, E = Toggle Tiles");
        JourneyOfTheHairsFrame.getTimer().start();
    }
}

