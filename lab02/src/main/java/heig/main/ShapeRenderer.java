package heig.main;

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
        g.fill(b.getShape());
    }
}