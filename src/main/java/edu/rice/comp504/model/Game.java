package edu.rice.comp504.model;

import edu.rice.comp504.model.APlacedObject.*;
import edu.rice.comp504.model.strategy.NaiveChasingStrategy;
import edu.rice.comp504.model.strategy.NullChasingStrategy;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Game {

    private Map map;
    // placed objects
    private Pacman pacman;
    private Ghost[] ghosts;
    private Fruit[] fruits;
    private APlacedObject[][] objectsMap;

    // game statistics
    private int score;
    private int time;



    public Game() {


    }

    public void loadLevelOne() {
        // init map
        map = new Map(1);
        char[][] mapArray = map.getMapArray();
        objectsMap = new APlacedObject[mapArray.length][mapArray[0].length];

        // init pacman
        pacman = new Pacman();
        pacman.setLocation(new Point(38,16));
        objectsMap[pacman.getLocation().y][pacman.getLocation().x] = pacman;

        // init ghosts
        ghosts = new Ghost[4];
        Ghost ghost1 = new Ghost();
        ghost1.setColor("#F00");
        ghost1.setLocation(new Point(39, 10));
        ghost1.setChasingStrategy(new NaiveChasingStrategy());
        ghosts[0] = ghost1;

        Ghost ghost2 = new Ghost();
        ghost2.setColor("#F93");
        ghost2.setLocation(new Point(37, 10));
        ghost2.setChasingStrategy(new NullChasingStrategy());
        ghosts[1] = ghost2;

        Ghost ghost3 = new Ghost();
        ghost3.setColor("#0CF");
        ghost3.setLocation(new Point(36, 10));
        ghost3.setChasingStrategy(new NullChasingStrategy());
        ghosts[2] = ghost3;

        Ghost ghost4 = new Ghost();
        ghost4.setColor("#F9C");
        ghost4.setLocation(new Point(34, 10));
        ghost4.setChasingStrategy(new NullChasingStrategy());
        ghosts[3] = ghost4;

        for (Ghost g: ghosts) {
            objectsMap[g.getLocation().y][g.getLocation().x] = g;
        }

        // init fruits
        fruits = new Fruit[4];
        Fruit fruit1 = new Fruit();
        fruit1.setLocation(new Point(5, 1));
        fruits[0] = fruit1;

        Fruit fruit2 = new Fruit();
        fruit2.setLocation(new Point(55, 1));
        fruits[1] = fruit2;

        Fruit fruit3 = new Fruit();
        fruit3.setLocation(new Point(5, 16));
        fruits[2] = fruit3;

        Fruit fruit4 = new Fruit();
        fruit4.setLocation(new Point(55, 16));
        fruits[3] = fruit4;

        for (Fruit f: fruits) {
            objectsMap[f.getLocation().y][f.getLocation().x] = f;
        }


        for(int i = 0; i < mapArray.length; i++) {
            for (int k = 0; k < mapArray[i].length; k++) {

                if (mapArray[i][k] == '1' && objectsMap[i][k] == null) {
                    objectsMap[i][k] = new Dot(new Point(k, i));
                }

            }
        }

    }

    /**
     * Update all the ghosts' location
     */
    public void update() {
        for(Ghost ghost: ghosts) {
            ghost.getChasingStrategy().chase(ghost, pacman, map);
        }
    }


    public void pacmanMove(int direction) {
        if (direction > 3 || direction < 0) return;
        // valid check
        Point directionVec = null;
        if (direction == 0) {
            directionVec = new Point(1, 0);
        } else if (direction == 1) {
            directionVec = new Point(0, 1);
        } else if (direction == 2) {
            directionVec = new Point(-1, 0);
        } else if (direction == 3) {
            directionVec = new Point(0, -1);
        }
        Point tempNext = new Point(pacman.getLocation().x + directionVec.x,  pacman.getLocation().y + directionVec.y);
        boolean isValid = map.isFreeAt(tempNext);

        if (isValid) {
            pacman.nextLocation(directionVec.x, directionVec.y);
            pacman.setDirection(direction);
        }
    }
}
