package heig.main.ShapeType;

import heig.main.BounceableObject;

import java.awt.*;

public abstract class Circle extends BounceableObject {
    private double diameter;

    public Circle(Point pos, double diameter) {
        super(pos);
        this.diameter = diameter;
    }

    public Circle(int x, int y, double diameter) {
        this(new Point(x,y),diameter);
    }

}