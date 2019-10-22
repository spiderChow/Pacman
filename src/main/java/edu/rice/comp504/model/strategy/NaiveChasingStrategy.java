package edu.rice.comp504.model.strategy;

import edu.rice.comp504.model.APlacedObject.Ghost;
import edu.rice.comp504.model.APlacedObject.Pacman;
import edu.rice.comp504.model.Map;

import java.util.Arrays;

public class NaiveChasingStrategy implements IChasingStrategy {
    private int preDirection = 0; // right

    /**
     * choose previous direction, which mimic going in straight line
     * @param ghost
     * @param pacman
     * @param map
     */
    @Override
    public void chase(Ghost ghost, Pacman pacman, Map map) {
        boolean[] directions = map.getValidDirectionAt(ghost.getLocation());
        // System.out.println(Arrays.toString(directions));
        if (directions[preDirection]) {
            ghost.movingInDirection(preDirection);
            //System.out.println(preDirection);
            return;
        }

        for (int i = 0; i < 3; i++) {
            preDirection = (1 + preDirection) % 4;
            if (directions[preDirection]) {
                ghost.movingInDirection(preDirection);
                //System.out.println(preDirection);

                break;
            }
        }

    }
}
