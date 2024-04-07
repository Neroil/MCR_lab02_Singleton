package heig.main;

import java.awt.*;

/**
 * Abstract class ShapeFactory
 *
 * @author Junod Arthur
 * @author Häffner Edwin
 * @version 1.0
 * @since 2024-03-14
 */
public abstract class ShapeFactory {
    protected Renderer renderer;

    /**
     * Constructor
     * @param renderer the renderer to use
     */
    protected ShapeFactory(Renderer renderer) {
        this.renderer = renderer;
    }

    /**
     * Draw the shape using the factory's renderer
     * @param b Bounceable the shape to draw
     */
    protected void drawShape(Bounceable b) {
        renderer.display(ShapeDisplay.getInstance().getGraphics(), b);
    }

    public abstract Bounceable createCircle(Point pos, int size);
    public abstract Bounceable createSquare(Point pos, int size);
}
