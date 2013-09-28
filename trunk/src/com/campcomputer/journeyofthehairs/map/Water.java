package com.campcomputer.journeyofthehairs.map;

import com.campcomputer.journeyofthehairs.Images;
import com.campcomputer.journeyofthehairs.Tile;

import java.awt.image.BufferedImage;

/**
 * Literally every single game makes the whole plot tons more difficult by putting a level under water. Bam.
 */
public class Water extends Map {
    private Tile[][] map = {
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
    };

    private BufferedImage image = Images.ReadImage("levels/water");

    public Water() {
        this.map = map;
        this.image = image;
    }
}
