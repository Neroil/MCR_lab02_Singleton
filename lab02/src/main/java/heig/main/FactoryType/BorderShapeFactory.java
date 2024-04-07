package heig.main.FactoryType;


import heig.main.Bounceable;
import heig.main.Renderer;
import heig.main.ShapeFactory;
import heig.main.ShapeType.Circle;
import heig.main.ShapeType.Square;

import java.awt.*;

/**
 * Factory for creating shapes with only a border
 *
 * @author Junod Arthur
 * @author Häffner Edwin
 * @version 1.0
 * @since 2024-03-14
 */
public class BorderShapeFactory extends ShapeFactory {

    private static BorderShapeFactory instance;

    /**
     * Private constructor to use with the singleton model. It creates a renderer that we'll use only with the
     * border shapes.
     */
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

    /**
     * The function that allow us to access the instance of BorderShapeFactory.
     * @return A new instance if there isn't already one or the existing one.
     */
    public static BorderShapeFactory getInstance() {
        if (instance == null) {
            instance = new BorderShapeFactory();
        }
        return instance;
    }

    /**
     * Create a border circle at the given pos with the given size.
     * We implement the missing abstract methods of our shape.
     * @param pos Position of the circle
     * @param size Size of the circle
     * @return A new border circle
     */
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

    /**
     * Create a border square at the given pos with the given size.
     * We implement the missing abstract methods of our shape.
     * @param pos Position of the square
     * @param size Size of the square
     * @return A new border square
     * */
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
