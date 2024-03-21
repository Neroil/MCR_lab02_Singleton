package heig.main.ShapeType;

import heig.main.Form;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Circle extends Ellipse2D.Double implements Form {

    private final int diameter;

    public Circle(double radius) {
        super(0, 0, radius * 2, radius * 2);
        this.diameter = (int) radius * 2;
    }

    public Shape drawShape(){
        return this;
    }

    @Override
    public void place(Point loc) {
        setFrame(loc, new Dimension(diameter, diameter));
    }
}
