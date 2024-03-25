// Circle.java
package heig.main.ShapeType;

import heig.main.Form;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse2D.Double implements Form {
    private final int diameter;

    public Circle(double radius, Point loc) {
        super(loc.x, loc.y, radius * 2, radius * 2);
        this.diameter = (int) radius * 2;
    }

    public Shape drawShape(){
        return this;
    }

    @Override
    public void place(Point loc) {
        setFrame(loc.x, loc.y, diameter, diameter);
    }

    @Override
    public Dimension getSize() {
        return new Dimension(diameter, diameter);
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}