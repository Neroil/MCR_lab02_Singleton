package heig.main.FactoryType;

import heig.main.Bounceable;
import heig.main.Renderer;
import heig.main.ShapeFactory;
import heig.main.ShapeType.Circle;
import heig.main.ShapeType.Square;

import java.awt.*;

public class FilledShapeFactory extends ShapeFactory {

    private static FilledShapeFactory instance;

    private FilledShapeFactory() {
        super(new Renderer() {
            @Override
            public void display(Graphics2D g, Bounceable b) {
                g.setColor(b.getColor());
                g.fill(b.getShape());
            }
        });
    }

    public static FilledShapeFactory getInstance() {
        if (instance == null) {
            instance = new FilledShapeFactory();
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
                return Color.BLUE;
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
                return Color.YELLOW;
            }
        };
    }

}