package heig.main.Renderers;

import heig.main.Bounceable;
import heig.main.Renderer;

import java.awt.*;

public class BorderRenderer implements Renderer {

    private static BorderRenderer instance = null;

    private BorderRenderer() {
    }

    public static BorderRenderer getInstance() {
        if (instance == null) {
            instance = new BorderRenderer();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bounceable b) {
        g.setColor(b.getColor());
        g.setStroke(new BasicStroke(2));
        g.draw(b.getShape());
    }
}
