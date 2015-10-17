package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.PhysicsEngine;
import com.campcomputer.journeyofthehairs.entity.Entity;

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
	 * Constructor
	 */
	public DragonFly(PhysicsEngine engine) {
		super(engine, 25);
	}

	/**
	 * Checks to see how/where the fly should move and if it should attack
	 */
	@Override
	public void tick() {
		super.tick();
		if (! getEngine().playerIsAbove(this)) {
			moveUp();
		} else { //if (getEngine().playerIsAbove(this))
			moveDown();
		}

		if (getEngine().playerIsToLeftOf(this)) {
			moveLeft();
		} else { //if (! getEngine().playerIsToLeftOf(this))
			moveRight();
		}

		Player player = getEngine().getPlayer();
		if (getEngine().isOnTopOfPlayer(this)) {
			if (player.getHealth() <= EATING_DAMAGE) {
				eat(player);
			} else if (getEngine().isPlayerClose(this)) {
				breathFire(player);
			}
		}
	}

	/**
	 * Self explanatory
	 */
	@Override
	protected void addImagesOfEntityToFrames() {
		frames.add(Images.ReadImage("/images/entities/creatures/dragonfly.png"));
	}

	/**
	 * Attempts to eat the entity. Since the DragonFlies are small, it doesn't do a lot of damage to a player, but the
	 * dragonfly gains health from eating.
	 *
	 * @param entity the thing to eat
	 */
	public void eat(Entity entity) {
		// make the enemy lose health
		entity.takeDamage(EATING_DAMAGE);
	}

	/**
	 * Breathe fire onto the given entity, usually a player. Instantly does a bunch of damage to it.
	 *
	 * @param entity the thing to breathe fire on.
	 */
	public void breathFire(Entity entity) {
		entity.takeDamage(BREATH_FIRE_DAMAGE);
	}

	@Override
	public boolean isAffectedByGravity() {
		return false;
	}
}