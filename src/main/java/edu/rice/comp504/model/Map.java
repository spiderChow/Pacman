package edu.rice.comp504.model;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;


/**
 * The map has the information about dims, walls, free space.
 */
public class Map {
    private char[][] mapArray;

    public Map(int level) {
        if (level == 1) {
            loadMapLevelOne();
        }
    }


    public void loadMapLevelOne() {
        try {
            File file = new File("map-level-one.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            mapArray = reader.lines().map(String::toCharArray).toArray(char[][]::new);
        }  catch (IOException e) {
            e.printStackTrace();
        }

//        Arrays.stream(mapArray).forEach(line -> {
//            new String(line).chars().forEach(cell -> System.out.print((char)(cell)));
//            System.out.println();
//        });

    }

    public static void main(String[] args) throws IOException {
        Map map = new Map(1);

    }

    public char[][] getMapArray() {
        return mapArray;
    }

    /**
     * Return if the location is in not at obstacles, if is collision free
     * @param location
     * @return
     */
    public boolean isFreeAt(Point location) {
        int x = location.x;
        int y = location.y;

        return mapArray[y][x] == '1';
    }

    /**
     * Get valid directions moving from the location
     * @param location
     * @return right, down, left, up is valid or not
     */
    public boolean[] getValidDirectionAt(Point location) {
        assert isFreeAt(location);

        int x = location.x;
        int y = location.y;

        boolean[] directions = new boolean[4];
        // right
        if (x + 1 < mapArray[y].length) {
            directions[0] = isFreeAt(new Point(x+1, y));
        }
        // down
        if (y + 1 < mapArray.length) {
            directions[1] = isFreeAt(new Point(x, y + 1));
        }
        // left
        if (x - 1 >= 0) {
            directions[2] = isFreeAt(new Point(x-1, y));
        }
        // up
        if (y - 1 >= 0) {
            directions[3] = isFreeAt(new Point(x, y - 1));
        }

        return directions;
    }
}
