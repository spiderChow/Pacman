package edu.rice.comp504.model.APlacedObject;

import java.awt.*;

public abstract class APlacedObject {
    private Point location;
    private String type;

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
