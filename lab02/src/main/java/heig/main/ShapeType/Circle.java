package heig.main.ShapeType;

import heig.main.BounceableObject;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Circle extends BounceableObject {
    private final double diameter;

    public Circle(Point pos, double diameter) {
        super(pos);
        this.diameter = diameter;
    }

    public Circle(int x, int y, double diameter) {
        this(new Point(x,y),diameter);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(pos.x,pos.y,diameter,diameter);
    }

    public double getWidth(){
        return diameter;
    }

    public double getHeight(){
        return diameter;
    }
}