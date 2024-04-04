package heig.main;

import heig.main.ShapeType.BorderCircle;
import heig.main.ShapeType.BorderSquare;

import java.awt.*;

public class ShapeRenderer implements Renderer {
    private static ShapeRenderer instance;

    private ShapeRenderer() {}

    public static ShapeRenderer getInstance() {
        if (instance == null) {
            instance = new ShapeRenderer();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bounceable b) {
        g.setColor(b.getColor());
        //C'est de la merde
        if (b instanceof BorderCircle || b instanceof BorderSquare) {
            g.setStroke(new BasicStroke(2));
            g.draw(b.getShape());
        } else {
            g.fill(b.getShape());
        }
    }
}