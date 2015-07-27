package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;
import com.campcomputer.journeyofthehairs.map.Map;
import com.campcomputer.journeyofthehairs.weapon.Pistol;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * The Physics Engine is responsible for all of Entities and their movement in the game.
 * Any method related to movement, collision detecting, entity adding/destroying, etc
 * is contained within this class.
 */
public class PhysicsEngine {
	/**
	 * The universal amount of force gravity gives on every entity affected by it.
	 */
	private static final float GRAVITY = .2f;

	/**
	 * The amount of power given to an entity to jump. This upward force is naturally degraded by gravity. The lower
	 * the number, the higher the entity jumps. At its current setting, the entity jumps 4 tiles high.
	 */
	private static final float JUMP_POWER = - 1.5f;

	/**
	 * The amount of sideways force applied to entities when they are moving. The higher the number, the faster, and
	 * consequently farther, they will move.
	 */
	private static final float MOVE_SPEED = .3f;

	/**
	 * The player that the user controls.
	 * <p/>
	 * TODO: Make multiplayer possible?
	 */
	private Player player;

	/**
	 * This is an array of every entity currently on the map. The only entities the user will see in the game
	 * will be the entities that are contained within this array. It can't be modified directly, so to add/delete,
	 * use entitiesToAdd.add() or entitiesToRemove.remove() to avoid any errors.
	 * <p/>
	 * TODO: Get rid of this variable to use the entities collection in Map
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
	 * The active map being used in the game. Maps can change, but this is the only one that
	 * is checked for drawing tiles and detecting obstacles, so be sure to use setMap() to
	 * change the map
	 */
	private Map activeMap;

	/**
	 * Constructor for the game engine. Creates Player 1 and adds a default weapon.
	 */
	public PhysicsEngine() {
		player = new Player(this);
		player.setX(0);
		player.setY(7);
		player.weapon = new Pistol();
		addEntity(player);
	}

	/**
	 * Called by the game timer on every tick. It updates the weapons, pickups, and entities arrays
	 * by removing and adding appropriately.
	 * <p/>
	 * It also applies movement and gravity to each of the entities on the map. Furthermore, it invokes
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
			if (entity.isAffectedByHitDetection()) {
				applyMovement(entity);
			}
		}
	}

	/**
	 * A simple getter for the player
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * A simple getter for the map
	 *
	 * @return the map that is currently active.
	 */
	public Map getMap() {
		return activeMap;
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
				if (! (entity instanceof Player)) {
					removeEntity(entity);
				}
			}
		}
		for (Entity entity : map.getEntities()) {
			addEntity(entity);
		}
		activeMap = map;
	}

	/**
	 * A simple getter for
	 *
	 * @return An ArrayList of Entities currently on the map
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	/**
	 * Calculates the distance between the character and a given entity
	 *
	 * @param entity: the entity to be used for comparison to the player
	 * @return the distance between the player and an entity in the form of a double
	 */
	public double getDistanceBetweenEntityAndPlayer(Entity entity) {
		Point2D playerPosition = new Point2D.Float(player.getX(), player.getY());
		Point2D entityPosition = new Point2D.Float(entity.getX(), entity.getY());

		return playerPosition.distance(entityPosition);
	}

	/**
	 * Adds entities the correct way to suppress errors
	 *
	 * @param entity: the entity to be added to the map on the next tick
	 */
	public void addEntity(Entity entity) {
		entitiesToAdd.add(entity);
	}

	/**
	 * Removes entities the correct way to suppress errors
	 *
	 * @param entity: the entity to be removed from the map on the next tick
	 */
	public void removeEntity(Entity entity) {
		entitiesToRemove.add(entity);
	}

	/**
	 * Tests for player proximity in relation to a given entity. Used for
	 * enemies that start attacking the player when Hair walks by them
	 *
	 * @param entity: the entity used for comparison
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
		return player.getY() > entity.getY();
	}

	/**
	 * Determines if a given entity's position is to the left or right of the player by testing
	 * both entities' x coordinate
	 *
	 * @param entity the entity to test
	 * @return true if the player is to the left of the entity, false if right
	 */
	public boolean isPlayerToLeft(Entity entity) {
		return player.getX() < entity.getX();
	}

	/**
	 * For all the entities on the map that are affected by gravity, the method weighs them down
	 * by adding the force of gravity on to their Y velocity.
	 */
	private void applyGravity() {
		for (Entity entity : entities) {
			if (entity.isAffectedByGravity()) {
				entity.setYVelocity(entity.getYVelocity() + GRAVITY);
			}
		}
	}

	/**
	 * This method applies movement by doing 2 things. First, applies the velocity to the location simply by
	 * adding it on. Next, it does location checks based on hit detection. It uses the findFirstSolid method to
	 * find where there are obstacles to the side and below. If there is an obstacle, the method stops the entity from moving
	 * <p/>
	 * TODO: Make sure the player can't jump into obstacles, as that is a known bug
	 */
	private void applyMovement(Entity entity) {
		float oldX = entity.getX();
		float oldY = entity.getY();
		float yVelocity = entity.getYVelocity();
		float xVelocity = entity.getXVelocity();
		// When determining obstacles from below, the method stops movement at the point (oldX, obstacleY - height)
		float height = entity.getHeight();

		float newX, newY;

		// Block for calculations if the player is under water. They won't move as quickly
		if (activeMap.getTiles()[(int) entity.getX()][(int) entity.getY()] == Tile.WATER) {
			newX = calculateHorizontalCollision(oldX, oldY, xVelocity / 3);
			newY = calculateVerticalCollision(oldX, oldY, height, yVelocity / 3);
		} else {
			newX = calculateHorizontalCollision(oldX, oldY, xVelocity);
			newY = calculateVerticalCollision(oldX, oldY, height, yVelocity);
		}

		if (newX < 0) {
			newX = 0;
		}

		float rightEdgeOfMap = activeMap.getTiles().length - 1;
		if (newX > rightEdgeOfMap) {
			newX = rightEdgeOfMap;
		}

		if (newY < 0) {
			newY = 0;
		}

		entity.setX(newX);
		entity.setY(newY);
	}

	/**
	 * @param x         The x coordinate of the entity
	 * @param y         The y coordinate of the entity
	 * @param xVelocity The current horizontal velocity of the entity
	 * @return The new x coordinate of the entity. This coordinate is either however far the entity
	 * can go with their current velocity or as far as they could go without crashing into a wall
	 */
	private float calculateHorizontalCollision(float x, float y, float xVelocity) {
		float newX = x + xVelocity;

		if (xVelocity > 0) {
			Point rightWall = findFirstSolid(x + 1, y, 1, 0, 0, 0, getMap().getTiles().length - 1, getMap().getTiles()[0].length - 1);
			if (rightWall.x < newX + 1) {
				newX = rightWall.x - 1;
			}
		} else {
			Point leftWall = findFirstSolid(x, y, - 1, 0, 0, 0, getMap().getTiles().length - 1, getMap().getTiles()[0].length - 1);
			if (leftWall.x + 1 > newX) {
				newX = leftWall.x + 1;
			}
		}

		return newX;
	}

	/**
	 * @param x         The x coordinate of the entity
	 * @param y         The y coordinate of the entity
	 * @param yVelocity The current vertical velocity of the entity
	 * @return The new y coordinate of the entity. This coordinate is either however far the entity
	 * can go with their current velocity or as far as they could go without crashing into a wall.
	 * Note that hit detection is only calculated when the entity is going downward to allow for jumping through
	 * objects going up.
	 */
	private float calculateVerticalCollision(float x, float y, float height, float yVelocity) {
		float newY = y + yVelocity;
		Tile[][] map = activeMap.getTiles();

		// Do vertical collision detection only if we are falling (allows for jumping up through platforms)
		if (yVelocity > 0) {
			Point nextPlatformOnLeftCorner = findFirstSolid(x, y + height, 0, 1, 0, 0, map.length - 1, map[0].length - 1);
			Point nextPlatformOnRightCorner = findFirstSolid(x + 1, y + height, 0, 1, 0, 0, map.length - 1, map[0].length - 1);

			int highestLandingPoint = (int) (nextPlatformOnLeftCorner.y - height);
			if (nextPlatformOnRightCorner.y - height < highestLandingPoint) {
				highestLandingPoint = (int) (nextPlatformOnRightCorner.y - height);
			}

			if (newY >= highestLandingPoint) {
				newY = highestLandingPoint;
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
	 * @param dX     the amount which x is incremented at each test. Can be negative
	 * @param dY     the amount at which y is incremented at each test. Can be negative
	 * @param minX   the X at which testing is stopped, but only applies if dX is negative
	 * @param minY   the y at which testing is stopped, but only applies if dY is negative
	 * @param maxX   the x at which testing is stopped, but only applies if dX is positive
	 * @param maxY   the y at which testing is stopped, but only applies if dY is positive
	 * @return the first tile that isn't air found on the test line
	 */
	private Point findFirstSolid(float startX, float startY, int dX, int dY, int minX, int minY, int maxX, int maxY) {
		if (startX >= maxX || startX <= minX || startY >= maxY || startY <= minY) {
			int x = startX <= minX ? minX : maxX;
			int y = startY <= minY ? minY : maxY;

			return new Point(x, y);
		}

		switch (activeMap.getTiles()[(int) startX][(int) startY]) {
			case PLANT:
			case LETTUCE:
			case CARROT:
			case GROUND:
			case CHEESE:
				return new Point((int) startX, (int) startY);
		}

		return findFirstSolid(startX + dX, startY + dY, dX, dY, minX, minY, maxX, maxY);
	}

	/**
	 * Adds the constant for moving speed to the player's x velocity
	 */
	public void startMoveForward() {
		player.setXVelocity(MOVE_SPEED);
	}

	/**
	 * Sets the x velocity of the player to 0. Created so when the user releases D (that's what she said),
	 * the user stops moving.
	 */
	public void endMoveForward() {
		player.setXVelocity(0);
	}

	/**
	 * Adds the opposite of the moving constant to the x velocity so the player moves backwards instead of forwards
	 */
	public void startMoveBackward() {
		player.setXVelocity(- MOVE_SPEED);
	}

	/**
	 * Sets x velocity of the player to 0. Created so the player stops moving when user releases A.
	 */
	public void endMoveBackward() {
		player.setXVelocity(0);
	}

	/**
	 * Tests to see if the player is standing on something, and not in the air (to prevent double+ jumping). If
	 * this is true, the constant for jumping power is made the player's y velocity
	 * <p/>
	 * TODO: Add width variable to let the player jump from the left edge of a ledge
	 */
	public void jump() {
		boolean airLeft = getMap().getTiles()[((int) player.getX())][((int) (player.getY() + player.getHeight()))] == Tile.AIR;
		boolean airRight = getMap().getTiles()[((int) player.getX() + 1)][((int) (player.getY() + player.getHeight()))] == Tile.AIR;
		if (! (airLeft && airRight)) {
			player.setYVelocity(JUMP_POWER);
		}
	}
}