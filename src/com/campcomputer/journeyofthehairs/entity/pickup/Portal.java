package com.campcomputer.journeyofthehairs.entity.pickup;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.map.CheeseMap;

public class Portal extends Pickup {
    public String location;

    public void loadImages() {

    }

    public Portal(GameEngine engine, String location) {
        super(engine);
        this.location = location;
    }

    @Override
    public void affectGame() {
        if (location.equals("cheese map")) {
            CheeseMap cheeseMap = new CheeseMap(engine);
            engine.setMap(cheeseMap);
        }
    }
}
