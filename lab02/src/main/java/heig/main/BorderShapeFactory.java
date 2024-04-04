package heig.main;



import heig.main.ShapeType.BorderCircle;
import heig.main.ShapeType.BorderSquare;

import java.awt.*;

public class BorderShapeFactory implements ShapeFactory {

    Renderer renderer = new Renderer() {
        @Override
        public void display(Graphics2D g, Bounceable b) {
            g.setColor(b.getColor());
            g.setStroke(new BasicStroke(2));
            g.draw(b.getShape());
        }
    };

    private static BorderShapeFactory instance;

    private BorderShapeFactory() {}

    public static BorderShapeFactory getInstance() {
        if (instance == null) {
            instance = new BorderShapeFactory();
        }
        return instance;
    }

    @Override
    public Bounceable createCircle(Point pos, int size) {
        return new BorderCircle(pos, size){
            @Override
            public void draw() {
                renderer.display(ShapeDisplay.getInstance().getGraphics(), this);
            }
        };
    }

    @Override
    public Bounceable createSquare(Point pos, int size) {
        return new BorderSquare(pos, size){
            @Override
            public void draw() {
                renderer.display(ShapeDisplay.getInstance().getGraphics(), this);
            }
        };
    }

}
