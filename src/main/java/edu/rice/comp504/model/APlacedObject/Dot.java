package edu.rice.comp504.model.APlacedObject;

import java.awt.*;

public class Dot extends APlacedObject {
    public Dot(Point loc) {
        setLocation(loc);
        setType("dot");
    }
}
