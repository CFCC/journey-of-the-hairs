package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.*;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.entity.pickup.Pickup;
import com.campcomputer.journeyofthehairs.item.*;
import com.campcomputer.journeyofthehairs.map.Map;
import com.campcomputer.journeyofthehairs.panel.GamePanel;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GameEngine {
    private static final float GRAVITY = .2f;
    private static final float JUMP_POWER = -1.5f;
    private static final float MOVE_SPEED = .3f;

    public GamePanel gamePanel;
    public Player player;

    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Item> itemsToRemove = new ArrayList<Item>();
    public ArrayList<Entity> entities = new ArrayList<Entity>();
    public ArrayList<Entity> entitiesToAdd = new ArrayList<Entity>();
    public ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();
    public Tile[][] activeMap;
    public ArrayList<Pickup> pickupsToRemove = new ArrayList<Pickup>();
    public ArrayList<Pickup> pickups = new ArrayList<Pickup>();
    private ArrayList<Pickup> pickupsToAdd = new ArrayList<Pickup>();

    public GameEngine() {
        player = new Player(this);
        player.setX(0);
        player.setY(9);
        player.weapon = new Railgun(this);
        addEntity(player);
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Tile[][] getMap() {
        return activeMap;
    }

    public void setMap(Map map) {
        if (entities.size() > 0) {
            for (Entity entity : entities) {
                if (!(entity instanceof Player))
                    removeEntity(entity);
            } for (Item item : items) {
                removeItem(item);
            } for (Pickup pickup : pickups) {
                removePickup(pickup);
            }
        }

        gamePanel.setMapBackground(map.image);
        activeMap = map.map;
        player.setX(0);
        player.setY(9);
    }

    public void tick() {
        entities.addAll(entitiesToAdd);
        entities.removeAll(entitiesToRemove);
        entitiesToAdd.clear();
        entitiesToRemove.clear();

        items.removeAll(itemsToRemove);
        itemsToRemove.clear();

        pickups.addAll(pickupsToAdd);
        pickups.removeAll(pickupsToRemove);
        pickupsToRemove.clear();
        pickupsToAdd.clear();

        for (Entity entity : entities) {
            entity.tick();
        }
        applyGravity();
        applyMovement();
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

                    Point landingPoint1 = findFirstSolid(x, y + height, 0, 1, 0, 0, activeMap.length - 1, activeMap[0].length - 1);
                    Point landingPoint2 = findFirstSolid(x + 1, y + height, 0, 1, 0, 0, activeMap.length - 1, activeMap[0].length - 1);

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
                    Point leftWall = findFirstSolid(x, y, -1, 0, 0, 0, activeMap.length - 1, activeMap[0].length - 1);
                    Point rightWall = findFirstSolid(x + 1, y, 1, 0, 0, 0, activeMap.length - 1, activeMap[0].length - 1);
                    if (leftWall != null && newX < leftWall.x + 1)
                        newX = leftWall.x + 1;
                    if (rightWall != null && newX > rightWall.x - 1)
                        newX = rightWall.x - 1;
                }

                if (newX < 0f) {
                    newX = 0;
                }
                float rightEdge = activeMap.length - 1;
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

            switch (activeMap[x][y]) {

                case PLANT:
                case LETTUCE:
                case CARROT:
                case GROUND:
                case CHEESE:
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
        Point firstSolid = findFirstSolid(player.getX(), player.getY(), 0, 1, 0, 0, activeMap.length, activeMap[0].length);
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

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Pickup> getPickups() {
        return pickups;
    }

    public void removePickup(Pickup pickup) {
        pickupsToRemove.add(pickup);
    }

    public void addPickup(Pickup portal) {
        pickupsToAdd.add(portal);
    }
}

