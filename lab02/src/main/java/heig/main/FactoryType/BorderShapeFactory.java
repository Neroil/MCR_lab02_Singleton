package heig.main.FactoryType;


import heig.main.Bounceable;
import heig.main.Renderer;
import heig.main.ShapeFactory;
import heig.main.ShapeType.Circle;
import heig.main.ShapeType.Square;

import java.awt.*;

public class BorderShapeFactory extends ShapeFactory {

    private static BorderShapeFactory instance;

    private BorderShapeFactory() {
        super(new Renderer() {
            @Override
            public void display(Graphics2D g, Bounceable b) {
                g.setColor(b.getColor());
                g.setStroke(new BasicStroke(2));
                g.draw(b.getShape());
            }
        });
    }

    public static BorderShapeFactory getInstance() {
        if (instance == null) {
            instance = new BorderShapeFactory();
        }
        return instance;
    }

    @Override
    public Bounceable createCircle(Point pos, int size) {
        return new Circle(pos, size){
            @Override
            public void draw() {
                drawShape(this);
            }

            @Override
            public Color getColor() {
                return Color.GREEN;
            }
        };
    }

    @Override
    public Bounceable createSquare(Point pos, int size) {
        return new Square(pos, size){
            @Override
            public void draw() {
                drawShape(this);
            }

            @Override
            public Color getColor() {
                return Color.RED;
            }
        };
    }
}
