package edu.rice.comp504.model.APlacedObject;

import edu.rice.comp504.model.strategy.IChasingStrategy;

import java.awt.*;

public class Ghost extends APlacedObject{
    private String color;
    private IChasingStrategy chasingStrategy;
    private int direction;

    public Ghost() {
        direction = 0;
        setType("ghost");
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void nextLocation(int deltaX, int deltaY) {
        getLocation().translate(deltaX, deltaY);
    }

    /**
     * move location along with the direction
     * @param direction 0 is right, 1 is down, 2 is left, 3 is up
     */
    public void movingInDirection(int direction) {
        if (direction == 0) {
            nextLocation(1, 0);
        } else if (direction == 1) {
            nextLocation(0, 1);
        } else if (direction == 2) {
            nextLocation(-1, 0);
        } else if (direction == 3) {
            nextLocation(0, -1);
        }

        setDirection(direction);
    }


    public IChasingStrategy getChasingStrategy() {
        return chasingStrategy;
    }

    public void setChasingStrategy(IChasingStrategy chasingStrategy) {
        this.chasingStrategy = chasingStrategy;
    }
}
