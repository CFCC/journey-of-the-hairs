package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.*;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.map.MapListener;
import com.campcomputer.journeyofthehairs.weapon.*;
import com.campcomputer.journeyofthehairs.map.Map;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Class Name: GameEngine
 * Purpose: Acts as a physics engine, but also happens to handle all of the different lists of entities
 */

public class GameEngine implements MapListener {
	/**
	 * The universal amount of force gravity gives on every entity affected by it. A relatively small amount, but it
	 * keeps entities from floating in the air, so it does the job.
	 */
	protected static final float GRAVITY = .2f;

	/**
	 * The amount of power given to an entity to jump. This upward force is naturally degraded by gravity. The lower
	 * the number, the higher the entity jumps. At its current setting, the entity jumps 4 tiles high.
	 */
	protected static final float JUMP_POWER = -1.5f;

	/**
	 * The amount of sideways force applied to entities when they are moving. The higher the number, the faster, and
	 * consequently farther, they will move.
	 */
	protected static final float MOVE_SPEED = .3f;

	/**
	 * The player that the user controls. It is created in the constructor for the engine.
	 * TODO: Make this variable an array to allow for >1 player
	 */
	private Player player;

	/**
	 * This is an array of every entity currently on the map. It is the array that is checked for images to
	 * paint and for ticks to invoke. In order for something to be removed from the game, it must be removed
	 * from this array via entitiesToRemove array. Consequently, if, for testing purposes, something needs not
	 * be added in the game at runtime, the only line that needs commenting out is the addEntity() line.
	 */
	private ArrayList<Entity> entities = new ArrayList<Entity>();

	/**
	 * List of entities tha need adding to the entities array. This is used instead of entities.add() because
	 * of an error that is thrown when the console expects an amount of objects in the array that would be higher
	 * if .add() is used that crashes the program.
	 */
	private ArrayList<Entity> entitiesToAdd = new ArrayList<Entity>();

	/**
	 * List of entities that need to be removed from the game. This is used instead of entities.remove() because
	 * of an error that is thrown when the console expects an amount of objects in the array that would be lower
	 * if .remove() is used that crashes the program.
	 */
	private ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();

	/**
	 * The active map being used in the game. Maps change from time to time, but this is the only one that
	 * is checked for drawing tiles and detecting obstacles.
	 */
	private Map activeMap;

	/**
	 * Constructor for the game engine. Creates Player 1.
	 */
	public GameEngine() {
		player = new Player(this);
		player.setX(0);
		player.setY(9);
		player.weapon = new Pistol();
		addEntity(player);
	}

	/**
	 * Sets the game to have a new map. The method removes everything in the map (except the player), then changes
	 * the game panel's background to the map background. Finally, changes the active map to the parameter and puts
	 * the player at the beginning of the map, (0, 9).
	 *
	 * @param map the map to become active.
	 */
	public void setMap(Map map) {
		if (entities.size() > 0) {
			for (Entity entity : entities) {
				if (!(entity instanceof Player))
					removeEntity(entity);
			}
		}
		for (Entity entity : map.getEntities()) {
			addEntity(entity);
		}
		activeMap = map;
	}

	/**
	 * On each tick (as specified in the JourneyOfThHairsFrame class), the engine
	 * updates the weapons, pickups, and entities arrays by removing and adding appropriately.
	 *
	 * It also applies movement and gravity to each of the entities on the map. Additionally, it invokes
	 * the tick method in all of the entities on the map
	 */
	public void tick() {
		entities.addAll(entitiesToAdd);
		entities.removeAll(entitiesToRemove);
		entitiesToAdd.clear();
		entitiesToRemove.clear();

		applyGravity();

		for (Entity entity : entities) {
			entity.tick();
			if (entity.isAffectedByHitDetection())
				applyMovement(entity);
		}
	}

	/**
	 * @return Player 1, or alternatively, the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the map that is currently active.
	 */
	public Map getMap() {
		return activeMap;
	}

	/**
	 * @return the list of entities currently on the map
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	/**
	 * Calculates the distance between the character and a given entity
	 *
	 * @param entity the entity to be used for comparison to the player
	 * @return the distance between the player and an entity in the form of a double
	 */
	public double getDistanceBetweenEntityAndPlayer(Entity entity) {
		Point2D playerPosition = new Point2D.Float(player.getX(), player.getY());
		Point2D entityPosition = new Point2D.Float(entity.getX(), entity.getY());

		return playerPosition.distance(entityPosition);
	}

	/**
	 * @param entity the entity to be added to the map on the next tick
	 */
	public void addEntity(Entity entity) {
		entitiesToAdd.add(entity);
	}

	/**
	 * @param entity the entity to be removed from the map on the next tick
	 */
	public void removeEntity(Entity entity) {
		entitiesToRemove.add(entity);
	}

	/**
	 * Tests for player proximity in relation to a given entity
	 *
	 * @param entity the entity used for comparison
	 * @return boolean, true if the two are close, false if not
	 */
	public boolean isPlayerClose(Entity entity) {
		return getDistanceBetweenEntityAndPlayer(entity) < 10f;
	}

	/**
	 * Determines if a given entity's position is the same as that of the player. This method was created
	 * because if the positions are compared directly, the only instance of the result being "true" is if
	 * both entities' positions were on the exact same pixel, which not only doesn't seem like a visible
	 * difference to the naked human eye, but also doesn't serve a good purpose for the game. Short distances
	 * on the map are tested instead to prevent this problem
	 *
	 * @param entity the entity to test
	 * @return true if both positions are the same, false if not
	 */
	public boolean isOnTopOfPlayer(Entity entity) {
		return getDistanceBetweenEntityAndPlayer(entity) < 2f;
	}

	/**
	 * Determines if a given entity's position is above or below the player by testing both
	 * entities' y coordinate
	 *
	 * @param entity the entity to test
	 * @return true if the entity is above the player, false if below
	 */
	public boolean isPlayerAbove(Entity entity) {
		return (player.getY() > entity.getY());
	}

	/**
	 * Determines if a given entity's position is to the left or right of the player by testing
	 * both entities' x coordinate
	 *
	 * @param entity the entity to test
	 * @return true if the player is to the left of the entity, false if right
	 */
	public boolean isPlayerToLeft(Entity entity) {
		return (player.getX() < entity.getX());
	}

	/**
	 * For all the entities on the map that are affected by gravity, the method weighs them down
	 * by adding the force of gravity on to their Y velocity.
	 */
	private void applyGravity() {
		for (Entity entity : entities) {
			if (entity.isAffectedByGravity())
				entity.setYVel(entity.getYVel() + GRAVITY);
		}
	}

	/**
	 * This method applies movement by doing 2 things. First, applies the velocity to the location simply by
	 * adding it on. Next, it does location checks based on hit detection. It uses the findFirstSolid method to
	 * find where there are obstacles to the side and below. If there is an obstacle, the method stops the entity from moving
	 *
	 * TODO: Make sure the player can't jump into obstacles, as that is a known bug
	 */
	private void applyMovement(Entity entity) {
			float x = entity.getX();
			float y = entity.getY();
			float vY = entity.getYVel();
			// When determining obstacles from below, the method stops movement at the point (x, obstacleY - height)
			float height = entity.getHeight();

			float newX = calcHorizontalCollision(x, y);
			float newY = calcVerticalCollision(x, y, height, vY);

			// Block for calculations if the player is under water. They won't move as quickly
			if (getMap().getMap()[(int) entity.getX()][(int) entity.getY()] == Tile.WATER) {
				newX = calcHorizontalCollision(x, y); // x + (vX / 3);
				newY = calcVerticalCollision(x, y, height, vY / 3);
			}

			if (newX < 0f) {
				newX = 0;
			}

			float rightEdge = activeMap.getMap().length - 1;
			if (newX > rightEdge) {
				newX = rightEdge;
			}

			if (newY < 0) {
				newY = 0;
			}

			entity.setX(newX);
			entity.setY(newY);
	}

	public float calcHorizontalCollision(float x, float y) {
		float newX = 0;
		Point leftWall = findFirstSolid(x, y, -1, 0, 0, 0, activeMap.getMap().length - 1, activeMap.getMap()[0].length - 1);
		Point rightWall = findFirstSolid(x + 1, y, 1, 0, 0, 0, activeMap.getMap().length - 1, activeMap.getMap()[0].length - 1);
		if (leftWall != null && newX < leftWall.x + 1)
			newX = leftWall.x + 1;
		if (rightWall != null && newX > rightWall.x - 1)
			newX = rightWall.x - 1;

		return newX;
	}

	public float calcVerticalCollision(float x, float y, float height, float vY) {
		float newY = 0;
		// Do vertical collision detection only if we are falling (allows for jumping up through platforms)
		if (vY > 0) {

			Point landingPoint1 = findFirstSolid(x, y + height, 0, 1, 0, 0, activeMap.getMap().length - 1, activeMap.getMap()[0].length - 1);
			Point landingPoint2 = findFirstSolid(x + 1, y + height, 0, 1, 0, 0, activeMap.getMap().length - 1, activeMap.getMap()[0].length - 1);

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
				}
			}
		}
		return newY;
	}

	/**
	 * This method takes a position, a range to test for solids, and a slope which is used to test for solids.
	 * Basically, for a domain of [minX, maxX], given startX is between the 2, test for solids on the line y = dY/dX * x + startY
	 *
	 * @param startX the x at which testing starts
	 * @param startY the y at which testing starts
	 * @param dX	 the amount which x is incremented at each test. Can be negative
	 * @param dY	 the amount at which y is incremented at each test. Can be negative
	 * @param minX   the X at which testing is stopped, but only applies if dX is negative
	 * @param minY   the y at which testing is stopped, but only applies if dY is negative
	 * @param maxX   the x at which testing is stopped, but only applies if dX is positive
	 * @param maxY   the y at which testing is stopped, but only applies if dY is positive
	 * @return the first tile that isn't air found on the test line
	 */
	private Point findFirstSolid(float startX, float startY, int dX, int dY, int minX, int minY, int maxX, int maxY) {
		int x = (int) startX;
		int y = (int) startY;
		while (x <= maxX && y <= maxY && x >= minX && y >= minY) {

			switch (activeMap.getMap()[x][y]) {

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

	/**
	 * Adds the constant for moving speed to the player's x velocity
	 */
	public void startMoveForward() {
		player.setXVel(MOVE_SPEED);
	}

	/**
	 * Sets the x velocity of the player to 0. Created so when the user releases D (that's what she said),
	 * the user stops moving.
	 */
	public void endMoveForward() {
		player.setXVel(0);
	}

	/**
	 * Adds the opposite of the moving constant to the x velocity so the player moves backwards instead of forwards
	 */
	public void startMoveBackward() {
		player.setXVel(-MOVE_SPEED);
	}

	/**
	 * Sets x velocity of the player to 0. Created so the player stops moving when user releases A.
	 */
	public void endMoveBackward() {
		player.setXVel(0);
	}

	/**
	 * Tests to see if the player is standing on something, and not in the air (to prevent double+ jumping). If
	 * this is true, the constant for jumping power is made the player's y velocity
	 * <p/>
	 * TODO: Add width variable to let the player jump from the left edge of a ledge
	 */
	public void jump() {
		Point firstSolid = findFirstSolid(player.getX(), player.getY(), 0, 1, 0, 0, activeMap.getMap().length, activeMap.getMap()[0].length);
		if (firstSolid != null && firstSolid.y - player.getY() <= 1) {
			player.setYVel(JUMP_POWER);
		}
	}
}