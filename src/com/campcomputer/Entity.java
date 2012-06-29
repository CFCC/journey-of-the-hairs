package com.campcomputer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    private int health = 100;
    private int attackDamage = 10;

    private float x = 0;
    private float y = 0;

    private float xVel = 0;
    private float yVel = 0;

    private boolean affectedByGravity = true;
    private boolean facingRight = true;

    protected GameEngine engine;
    protected List<BufferedImage> frames = new ArrayList<BufferedImage>();
    protected int currentFrame = 0;

    public Entity(GameEngine engine) {
        this.engine = engine;
        loadImages();
        if (frames.size() == 0)
            frames.add(Images.ReadImage(new File("images/Cheese.jpg")));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getxVel() {
        return xVel;
    }

    public void setxVel(float xVel) {
        this.xVel = xVel;
    }

    public float getyVel() {
        return yVel;
    }

    public void setyVel(float yVel) {
        this.yVel = yVel;
    }

    public int getHeight() {
        return 1;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setEngine(GameEngine engine) {
        this.engine = engine;
    }

    public boolean isFacingLeft() {
        return !facingRight;
    }

    public boolean isAffectedByGravity() {
        return affectedByGravity;
    }

    public void setAffectedByGravity(boolean affectedByGravity) {
        this.affectedByGravity = affectedByGravity;
    }

    public void moveLeft() {
        setX(getX() - getxVel());
    }

    public void moveRight() {
        setX(getX() + getxVel());
    }

    public void moveUp() {
        setY(getY() + getyVel());
    }

    public void moveDown() {
        setY(getY() - getyVel());
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    abstract protected void loadImages();

    public List<BufferedImage> getFrames() {
        return frames;
    }

    public void tick() {
        currentFrame++;
        if (currentFrame > frames.size() - 1)
            currentFrame = 0;
    }

    abstract public void attack(Entity entity);

    public BufferedImage getCurrentFrame() {
        return frames.get(currentFrame);
    }

    protected List<BufferedImage> loadFrames(String name) {
        List<BufferedImage> frames = new ArrayList<BufferedImage>();

        File frameDir = new File("frames/" + name);

        for (File file : frameDir.listFiles()) {
            if (file.isFile())
                frames.add(Images.ReadImage(file));
        }
        return frames;

    }

    public boolean attacked() {
        setHealth(health -= 25);
        return health > 0;
    }
}
