package com.campcomputer.journeyofthehairs.entity.creatures;

import com.campcomputer.journeyofthehairs.*;
import com.campcomputer.journeyofthehairs.entity.Entity;
import com.campcomputer.journeyofthehairs.weapon.Weapon;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the player; it is one of the most important classes in the game. It is also the only controllable
 * entity. The player is used in almost every single class because without the player, there is no game.
 */
public class Player extends Entity {
    /**
     * Maximum amount of health the player can have at any one point. If it goes over this threshold, it is reset to
     * this variable.
     */
    public static final int MAX_HEALTH = 100;

    /**
     * The buffered image for when the player is going forward.
     */
    List<BufferedImage> forwardFrames;

    /**
     * The buffered image for when the player is going backwards.
     */
    List<BufferedImage> backwardFrames;

    /**
     * The amount of lives (left) the player has.
     *
     * TODO: When the player's health goes down to zero, they will lose a life and the level will restart.
     * Once their lives go down to zero, they will go to a "sorry, you lost" screen and be redirected back
     * to the main menu.
     */
    public int lives = 3;

    /**
     * The weapon that the player currently has equipped. The player may have other weapons in their inventory,
     * but this is the only active one and is the one that is checked for Weapons Type and statistics such as damage,
     * bullet speed, and the amount of ammo left.
     */
    public Weapon weapon;

    /**
     * An array of the items the player has acquired through pickups. The player may choose to have every item be used
     * upon pickup in a settings menu, but by default, each weapon is added to the inventory. The inventory can be
     * accessed in-game by a hot key 'E', a la Minecraft.
     *
     * This array can contain anything that extends the Pickup class.
     */
    public ArrayList<Weapon> inventory;

    /**
     * This is the player's defense. It can only be increased by collecting armor or invincibility on
     * a map. Any damage to the player is calculated by newHealth = oldHealth - (enemyDamage - defense)
     */
    private int defense;

    /**
     * Constructor for a new player. For now, fairly simple.
     * TODO: Add ID key to player to allow multiplayer gameplay
     *
     * @param engine is the super class for the player class
     */
    public Player(GameEngine engine) {
        super(engine);
        setHealth(MAX_HEALTH);
    }

    /**
     * Self explanatory.
     */
    @Override
    protected void loadImages() {
        forwardFrames = new ArrayList<BufferedImage>();
        backwardFrames = new ArrayList<BufferedImage>();
        forwardFrames.add(Images.ReadImage("entities/creatures/hare forward"));
        backwardFrames.add(Images.ReadImage("entities/creatures/hare back"));
        frames = forwardFrames;
    }

    /**
     * Does same as superclass, but changes frames appropriately.
     * TODO: Make more efficient by editing Entity class
     */
    @Override
    public void setXVel(float xVel) {
        super.setXVel(xVel);
        if (xVel < 0)
            frames = backwardFrames;
        if (xVel > 0)
            frames = forwardFrames;
    }

    /**
     * Changes a variable, which describes which way the player is facing, appropriately. Also routinely lowers the
     * ticks until the player's weapon can be fired again (in accordance with its cool down rate).
     *
     * Also checks to see if the life variable needs to be lowered.
     */
    @Override
    public void tick() {
        super.tick();
        if (frames == forwardFrames)
            facingLeft = false;
        if (frames == backwardFrames)
            facingLeft = true;
        getWeapon().lowerTicksTillFire();
        if (getHealth() <= 0 && lives >= 0)
            lives -= 1;
    }

    /**
     * Changes the player's active weapon.
     * TODO: Can only be something from the inventory.
     *
     * @param weapon The weapon to become active.
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * @return the player's current active weapon.
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Setter for the player's defense
     *
     * @param defense the new defense amount
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * @return the player's defense
     */
    public int getDefense() {
        return defense;
    }
}
