package heig.main.ShapeType;

import java.awt.geom.Ellipse2D;


public class Circle extends Ellipse2D.Double {
    public Circle(double x, double y, double radius) {
        super(x, y, radius * 2, radius * 2);
    }

    public Shape drawShape(){

    }
}
