package com.campcomputer.journeyofthehairs;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class MapConverter {

    public static final String[] COLOR_NAMES = new String[]{"black:null/*k*/", "blue:null/*b*/", "cyan:AIR",
            "gray:null/*a*/", "green:null/*g*/", "magenta:null/*m*/", "orange:CARROT", "pink:LETTUCE",
            "red:PLANT", "white:null/*w*/", "yellow:null/*y*/", "brown:GROUND"};

    public static final Color[] CONSTANT_COLORS = new Color[COLOR_NAMES.length];
    public static final String[] COLOR_CONSTANTS = new String[COLOR_NAMES.length];

    static {
        Map<String,Color> extraColors = new HashMap<String, Color>();
        extraColors.put("brown", new Color(128, 86, 42));
        for (int i = 0; i < COLOR_NAMES.length; i++) {
            String str = COLOR_NAMES[i];
            String colorName = str.substring(0,str.indexOf(':'));
            COLOR_CONSTANTS[i] = str.substring(str.indexOf(':')+1);
            try {
                CONSTANT_COLORS[i] = (Color) Color.class.getField(colorName).get(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                Color c = extraColors.get(colorName);
                if (c == null) {
                    throw new RuntimeException("no such color " + colorName);
                }
                CONSTANT_COLORS[i] = c;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedImage image = ImageIO.read(file);
        @SuppressWarnings("unchecked") 
        List<Integer>[][] coloridx = (List<Integer>[][]) new List[image.getWidth()/64][image.getHeight()/64];
        for (List<Integer>[] colorList : coloridx) {
            for (int j = 0; j < colorList.length; j++) {
                colorList[j] = new ArrayList<Integer>();
            }
        }
        for (int x = 0; x < image.getWidth(); x++) {
            int xi = x/64;
            for (int y = 0; y < image.getHeight(); y++) {
                int yi = y/64;
                int colorIndex = round(new Color(image.getRGB(x, y)));
                coloridx[xi][yi].add(colorIndex);
            }
        }
        
        String[][] grid = new String[image.getWidth()/64][image.getHeight()/64];
        for (int xi = 0; xi < grid.length; xi++) {
            for (int yi = 0; yi < grid[xi].length; yi++) {
                Map<Integer,Integer> count = new HashMap<Integer, Integer>();
                List<Integer> colorIndices = coloridx[xi][yi];
                for (int index : colorIndices) {
                    if (count.get(index) == null) {
                        count.put(index, 1);
                    } else {
                        count.put(index, count.get(index)+1);
                    }
                }
                int max = 0;
                int maxColor = 0;
                for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                    int color = entry.getKey();
                    int countz = entry.getValue();
                    if (countz > max) {
                        max = countz;
                        maxColor = color;
                    }
                }
                grid[xi][yi] = COLOR_CONSTANTS[maxColor];
            }
        }
        System.out.println("import static com.campcomputer.journeyofthehairs.Tile.*;");
        System.out.println();
        System.out.println("/* Each line is one row of tiles; each column is one column */");
        System.out.println("Tile[][] map_" + file.getName().replaceAll("[^a-zA-Z0-9]", "_") + " = {");
        for (int x = 0; x < grid.length; x++) {
            System.out.print("{ ");
            for (int y = 0; y < grid[x].length; y++) {
                String s = grid[x][y];
                if (s == null) {
                    throw new RuntimeException("what?? " + x + "," + y);
                }
                System.out.format("%-10s ", s+",");
            }
            System.out.println("},");
        }
        System.out.println("};");
    }
    
    public static int round(Color color) {
        
        Color nearestColor = null;
        double nearestDistance = 1000000;
        int nearestIndex = -1;

        for (int i = 0, constantColorsLength = CONSTANT_COLORS.length; i < constantColorsLength; i++) {
            Color constantColor = CONSTANT_COLORS[i];
            double newDist = Math.sqrt(
                    Math.pow(color.getRed() - constantColor.getRed(), 2)
                            + Math.pow(color.getGreen() - constantColor.getGreen(), 2)
                            + Math.pow(color.getBlue() - constantColor.getBlue(), 2));
            if (nearestDistance > newDist) {
                nearestColor = constantColor;
                nearestDistance = newDist;
                nearestIndex = i;
            }
        }
        return nearestIndex;
    }
}
