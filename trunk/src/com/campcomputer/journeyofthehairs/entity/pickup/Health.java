package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Health extends Pickup {
    private List<BufferedImage> twenty;
    private List<BufferedImage> fifty;
    private List<BufferedImage> oneHundred;

    public Health (GameEngine engine, int amount) {
        super(engine);
        if (amount == 20)
            frames = twenty;
        else if (amount == 50)
            frames = fifty;
        else if (amount == 100)
            frames = oneHundred;
    }

    public void loadImages() {
        twenty = new ArrayList<BufferedImage>();
        fifty = new ArrayList<BufferedImage>();
        oneHundred = new ArrayList<BufferedImage>();

        twenty.add(Images.ReadImage("entities/pickups/health/20"));
        fifty.add(Images.ReadImage("entities/pickups/health/50"));
        oneHundred.add(Images.ReadImage("entities/pickups/health/100"));
    }

    @Override
    public void affectGame() {
        Player player = engine.getPlayer();
        if (frames == twenty)
            player.setHealth(player.getHealth() + 20);
        else if (frames == fifty)
            player.setHealth(player.getHealth() + 50);
        else if (frames == oneHundred)
            player.setHealth(player.getHealth() + 100);

        if (player.getHealth() > Player.MAX_HEALTH)
            player.setHealth(Player.MAX_HEALTH);
    }
}
