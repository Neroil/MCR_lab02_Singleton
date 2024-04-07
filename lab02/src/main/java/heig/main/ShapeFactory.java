package heig.main;

import heig.main.ShapeType.*;

import java.awt.*;

public abstract class ShapeFactory {
    protected Renderer renderer;

    public ShapeFactory(Renderer renderer) {
        this.renderer = renderer;
    }

    protected void drawShape(Bounceable b) {
        renderer.display(ShapeDisplay.getInstance().getGraphics(), b);
    }

    public abstract Bounceable createCircle(Point pos, int size);
    public abstract Bounceable createSquare(Point pos, int size);
}
