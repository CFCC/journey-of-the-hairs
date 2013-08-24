package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.entity.creatures.Player;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Health extends Pickup {
    public List<BufferedImage> twenty;
    public List<BufferedImage> fifty;
    public List<BufferedImage> oneHundred;

    public Health (GameEngine engine, int amount) {
        super(engine);
        if (amount == 5)
            frames = twenty;
        else if (amount == 10)
            frames = fifty;
        else if (amount == 50)
            frames = oneHundred;
    }

    public void loadImages() {
        twenty = new ArrayList<BufferedImage>();
        fifty = new ArrayList<BufferedImage>();
        oneHundred = new ArrayList<BufferedImage>();

        twenty.add(Images.ReadImage("images/five health.png"));
        fifty.add(Images.ReadImage("images/ten health.png"));
        oneHundred.add(Images.ReadImage("images/fifty health.png"));
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
