package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.map.MapListener;

/**
 * This is one of the enemies, the dragonfly. Its origin was the misleading name. The game's creators decided
 * to take the name literally. If examined closely enough, the dragon fly is literally a dragon the size of
 * a fly. It is more a nuisance than dangerous, but if ignored, it can cause serious damage to the player.
 */
public class DragonFly extends Entity {
	/**
	 * This is, by far, the most common attack of the fly. It breaths fire onto the entity, causing a
	 * minuscule 1 damage. This attack happens rather quickly, though, so it can be dangerous.
	 */
	private static final int BREATH_FIRE_DAMAGE = 1;

	/**
	 * Once the fly's prey is weak enough to be eaten (has 10 health), the fly eats its prey, removing it from the map
	 */
	private static final int EATING_DAMAGE = 10;

	/**
	 * In theory, the dragonfly cannot fly forever; its wings would get tired. To represent this scenario
	 * is this field. The fly can fly at any time as long as the value is positive. Once it reaches
	 * 0, the fly cant fly and has to wait until it reaches a certain minimum before it can begin flying
	 * again.
	 * <p/>
	 * If the fly can't fly, it is merely gliding on the ground (changing x coordinate) and just not going up
	 * and down. Physics apply to this variable. If the fly is going down, the fly spends less energy than going
	 * up since gravity is working against the fly going up and for it going down.
	 */
	private int flyingEnergy = 25;

	/**
	 * Constructor
	 */
	public DragonFly(PhysicsEngine engine, MapListener mapListener) {
		super(engine, mapListener);
		setAffectedByGravity(false);
		setHealth(5);
	}

	/**
	 * Checks to see how/where the fly should move and if it should attack
	 */
	@Override
	public void tick() {
		super.tick();
		if (chasePlayer1() != 1) {
			if (! engine.isPlayerAbove(this)) {
				moveUp();
				flyingEnergy -= 2;
			} else if (engine.isPlayerAbove(this)) {
				moveDown();
				flyingEnergy -= 1;
			}
		}

		if (engine.isPlayerToLeft(this)) {
			moveLeft();
			flyingEnergy += 1;
		} else if (! engine.isPlayerToLeft(this)) {
			moveRight();
			flyingEnergy += 1;
		} else {
			setXVelocity(0);
			setX(getX());
		}

		Player player = engine.getPlayer();
		if (engine.isOnTopOfPlayer(this)) {
			if (player.getHealth() <= EATING_DAMAGE) {
				eats(player);
			} else if (engine.isPlayerClose(this)) {
				breathFire(player);
			}
		}
	}

	/**
	 * Self explanatory
	 */
	@Override
	protected void loadImages() {
		frames.add(Images.ReadImage("entities/creatures/dragonfly"));
	}

	/**
	 * Attempts to eat the entity. Since the DragonFlies are small, it doesn't do a lot of damage to a player, but the
	 * dragonfly gains health from eating.
	 *
	 * @param entity the thing to eat
	 */
	public void eats(Entity entity) {
		// make the enemy lose health
		entity.setHealth(entity.getHealth() - EATING_DAMAGE);

		if (entity.getHealth() <= 0) {
			// makes the dragonfly gain health
			setHealth(getHealth() + EATING_DAMAGE / 2);
		}
	}

	/**
	 * Breathe fire onto the given entity, usually a player. Instantly does a bunch of damage to it.
	 *
	 * @param entity the thing to breathe fire on.
	 */
	public void breathFire(Entity entity) {
		entity.setHealth(entity.getHealth() - BREATH_FIRE_DAMAGE);
	}

	/**
	 * By the looks of it, determines how the fly should chase an entity. Poorly written; needs refactor desperately
	 * <p/>
	 * TODO: Change this mess of code into something readable
	 */
	public int chasePlayer1() {
		if (flyingEnergy > 7) {
			// fly towards the player,
			// solid object in the way
			return 0;
		}
		if (flyingEnergy <= 0) {
			return 1;
		}
		//walk towards the player,
		// can also jump.
		else {
			return 2;
		}
	}

	/**
	 * @return the current flying energy
	 */
	public int getFlyingEnergy() {
		return flyingEnergy;
	}

	/**
	 * Flying energy setter
	 *
	 * @param flyingEnergy the new flying energy
	 */
	public void setFlyingEnergy(int flyingEnergy) {
		this.flyingEnergy = flyingEnergy;
	}

	/**
	 * Override method. The fly can fly through obstacles
	 */
	public boolean isAffectedByHitDetection() {
		return false;
	}
}