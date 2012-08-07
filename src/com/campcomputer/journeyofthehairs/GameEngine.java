package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.*;
import com.campcomputer.journeyofthehairs.item.*;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GameEngine {
    private static final float GRAVITY = .2f;
    private static final float JUMP_POWER = -1.5f;
    private static final float MOVE_SPEED = .3f;
    private Player player;
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private ArrayList<Entity> entitiesToAdd = new ArrayList<Entity>();
    private ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();
    ArrayList<Item> items = new ArrayList<Item>();
    Item item = new Item(this) {
        @Override
        protected void loadImages() {
        }

        @Override
        public void attack(Entity entity) {
        }
    };

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
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHUCKNORRIS, Tile.CHUCKNORRIS, Tile.CHUCKNORRIS, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHUCKNORRIS, Tile.CHUCKNORRIS, Tile.CHUCKNORRIS, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHUCKNORRIS, Tile.CHUCKNORRIS, Tile.CHUCKNORRIS, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.GROUND,},
    };

    public GameEngine() {
        player = new Player(this);
        player.setX(1);
        player.setY(0);

        com.campcomputer.journeyofthehairs.entity.ChuckNorris chuckNorris = new ChuckNorris(this);
        chuckNorris.setX(map.length - 5);
        chuckNorris.setY(2);

        DragonFly dragonFly = new DragonFly(this);
        dragonFly.setX(3);
        dragonFly.setY(3);

        SuicideStinkBug stinkbug = new com.campcomputer.journeyofthehairs.entity.SuicideStinkBug(this);
        stinkbug.setX(9);
        stinkbug.setY(7);

        com.campcomputer.journeyofthehairs.entity.RocketWorm worm = new com.campcomputer.journeyofthehairs.entity.RocketWorm(this);
        worm.setX(32);
        worm.setY(9);

        com.campcomputer.journeyofthehairs.item.MiniGun miniGun = new MiniGun(this);
        miniGun.setX(0);
        miniGun.setY(0);

        com.campcomputer.journeyofthehairs.item.Railgun railgun = new Railgun(this);
        railgun.setX(0);
        railgun.setY(1);

        com.campcomputer.journeyofthehairs.item.Rifle rifle = new Rifle(this);
        rifle.setX(1);
        rifle.setY(0);

        com.campcomputer.journeyofthehairs.item.Shotgun shotgun = new Shotgun(this);
        shotgun.setX(1);
        shotgun.setY(1);

        com.campcomputer.journeyofthehairs.item.GrenadeGun grenadeGun = new GrenadeGun(this);
        grenadeGun.setX(1);
        grenadeGun.setY(2);

        com.campcomputer.journeyofthehairs.item.Pistol pistol = new Pistol(this);
        pistol.setX(2);
        pistol.setY(1);

        entities.add(player);
        entities.add(chuckNorris);
        entities.add(dragonFly);
        entities.add(stinkbug);
        entities.add(worm);

        items.add(pistol);
        items.add(grenadeGun);
        items.add(miniGun);
        items.add(rifle);
        items.add(railgun);
        items.add(shotgun);

        item.setItems(getItems());
        this.item = pistol;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList getItems() {
        return items;
    }

    public ArrayList<Entity> getEntities() {
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
        item = Item.getActiveItem();

        for (Entity entity : entities)
            entity.tick();

        applyGravity();
        applyMovement();
        nextLife();
//        item.pickUpItem();
    }

    public void nextLife() {
        if (!player.isPlayerAlive() && player.getLives() > 0) {
            player.subtractLife();
            player.setHealth(player.MAX_HEALTH);
            String x[] = {"A", "B"};
            JourneyOfTheHairs.main(x);
        }
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
                        } else
                            highestLandingPoint = landingPoint2.y;

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

            //dY over dX is the slope
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

    public boolean isEntityClose(Entity entity, Entity otherEntity) {
        return getDistanceBetweenTwoEntities(entity, otherEntity) < 3f;
    }

    public double getDistanceBetweenTwoEntities(Entity entityOne, Entity entityTwo) {
        Point2D entityOnePosition = new Point2D.Float(entityOne.getX(), entityOne.getY());
        Point2D entityTwoPosition = new Point2D.Float(entityTwo.getX(), entityTwo.getY());

        return entityOnePosition.distance(entityTwoPosition);
    }

    public boolean isOnTopOfEntity(Entity entity, Entity otherEntity) {
        return getDistanceBetweenTwoEntities(entity, otherEntity) < 2;
    }

    public boolean isPlayerOnTopOfNorris() {
        return map[((int) player.getX())][((int) player.getY())] == Tile.CHUCKNORRIS;
    }

    public boolean isPlayerAbove(Entity entity) {
        return player.getY() > entity.getY();
    }

    public boolean isPlayerToLeft(Entity entity) {
        return player.getX() < entity.getX();
    }

    public void shoot() {
        int ammoLeft = item.getAmmo();
        ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();
        float playerX = player.getX();
        float playerY = player.getY();
        if (player.isFacingLeft() && ammoLeft > 0) {
            for (Entity entity : entities) {
                Point2D shootLocation = new Point2D.Float(playerX - 1, playerY);
                Point2D entityLocation = new Point2D.Float(entity.getX(), entity.getY());
                item.subtractAmmo();
                if (shootLocation.distance(entityLocation) < 1) {
                    if (!entity.attacked())
                        entitiesToRemove.add(entity);
                }
            }
        }
        if (player.isFacingRight() && ammoLeft > 0) {
            for (Entity entity : entities) {
                Point2D shootLocation = new Point2D.Float(playerX + 1, playerY);
                Point2D entityLocation = new Point2D.Float(entity.getX(), entity.getY());
                item.subtractAmmo();
                if (shootLocation.distance(entityLocation) < 1) {
                    if (!entity.attacked())
                        entitiesToRemove.add(entity);
                }
            }
        }
        entities.removeAll(entitiesToRemove);
    }

    public void addEntity(Entity entity) {
        entitiesToAdd.add(entity);
    }

    public void removeEntity(Entity entity) {
        entitiesToRemove.add(entity);
    }

    public void directions() {

    }
}

