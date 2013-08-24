package com.campcomputer.journeyofthehairs.map;

import com.campcomputer.journeyofthehairs.GameEngine;
import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.Tile;
import com.campcomputer.journeyofthehairs.entity.creatures.SuicideStinkBug;
import com.campcomputer.journeyofthehairs.item.Railgun;

import java.awt.image.BufferedImage;

public class CheeseMap extends Map {
    public Tile[][] cheeseMap = {
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},
            {Tile.AIR, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE, Tile.CHEESE,},
            {Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.AIR, Tile.CHEESE,},

    };

    public BufferedImage theImage = Images.ReadImage("images/cheese level.png");

    public CheeseMap(GameEngine engine) {
        map = cheeseMap;
        image = theImage;

        SuicideStinkBug suicideStinkBug = new SuicideStinkBug(engine);
        suicideStinkBug.setX(37);
        suicideStinkBug.setY(10);
        engine.addEntity(suicideStinkBug);

        SuicideStinkBug suicideStinkBug1 = new SuicideStinkBug(engine);
        suicideStinkBug1.setX(38);
        suicideStinkBug1.setY(10);
        engine.addEntity(suicideStinkBug1);

        Railgun railgun = new Railgun(engine);
        railgun.setX(cheeseMap.length - 4);
        railgun.setY(8);
        engine.addEntity(railgun);
    }
}
