package heig.main.Renderers;

import heig.main.Bounceable;
import heig.main.Renderer;

import java.awt.*;

public class FilledRenderer implements Renderer {


    private static FilledRenderer instance = null;

    private FilledRenderer() {}

    public static FilledRenderer getInstance() {
        if (instance == null) {
            instance = new FilledRenderer();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bounceable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
