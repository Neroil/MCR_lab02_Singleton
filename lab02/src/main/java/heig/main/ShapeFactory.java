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
public interface ShapeFactory {
    public abstract Bounceable createCircle(Point pos, int size);
    public abstract Bounceable createSquare(Point pos, int size);
}
