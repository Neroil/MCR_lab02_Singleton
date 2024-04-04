package heig.main;

import heig.main.ShapeType.Circle;
import heig.main.ShapeType.FilledCircle;
import heig.main.ShapeType.FilledSquare;
import heig.main.ShapeType.Square;

import java.awt.*;

public class FilledShapeFactory implements ShapeFactory {

    Renderer renderer = new Renderer() {
        @Override
        public void display(Graphics2D g, Bounceable b) {
            g.setColor(b.getColor());
            g.fill(b.getShape());
        }
    };

    private static FilledShapeFactory instance;

    private FilledShapeFactory() {}

    public static FilledShapeFactory getInstance() {
        if (instance == null) {
            instance = new FilledShapeFactory();
        }
        return instance;
    }

    @Override
    public Bounceable createCircle(Point pos, int size) {
        return new FilledCircle(pos, size){
            @Override
            public void draw() {
                renderer.display(ShapeDisplay.getInstance().getGraphics(), this);
            }
        };
    }

    @Override
    public Bounceable createSquare(Point pos, int size) {
        return new FilledSquare(pos, size){
            @Override
            public void draw() {
                renderer.display(ShapeDisplay.getInstance().getGraphics(), this);
            }
        };
    }

}