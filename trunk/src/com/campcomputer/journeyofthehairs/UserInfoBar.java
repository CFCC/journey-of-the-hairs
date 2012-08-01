package com.campcomputer.journeyofthehairs;


import com.campcomputer.journeyofthehairs.entity.Entity;

public abstract class UserInfoBar extends Entity {
    GamePanel gamePanel;

    private InfoBar[][] userBar = {
            {InfoBar.LIFEINFO, InfoBar.LIFE, InfoBar.NULL, InfoBar.HEALTHINFO, InfoBar.HEALTH, InfoBar.NULL, InfoBar.NULL, InfoBar.NULL, InfoBar.NULL, InfoBar.NULL, InfoBar.NULL, InfoBar.NULL, InfoBar.NULL, InfoBar.NULL, InfoBar.NULL, InfoBar.NULL,},
    };

    public UserInfoBar(GameEngine engine) {
        super(engine);
    }

    public void loadImages() {
        frames.add(Images.ReadImage("images/userInfoBar.png"));
    }

    public void tick() {
//        setX(gamePanel.getxScreenPlace());
//        setY(0);
    }
}
