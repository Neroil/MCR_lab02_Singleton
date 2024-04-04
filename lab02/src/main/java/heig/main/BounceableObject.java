package heig.main;

import java.awt.*;
import java.awt.geom.Dimension2D;

public abstract class BounceableObject implements Bounceable {
    protected Point pos;
    protected Point direction;
    protected int maxWidth;
    protected int maxHeight;

    protected BounceableObject(Point pos) {
        this.pos = pos;
        direction = new Point((int)(Math.random()*10)+1, (int)(Math.random()*10)+1);
        maxWidth = ShapeDisplay.getInstance().getWidth();
        maxHeight = ShapeDisplay.getInstance().getHeight();
    }

    @Override
    public void draw() {
        ShapeRenderer.getInstance().display(ShapeDisplay.getInstance().getGraphics(), this);
    }

    @Override
    public void move() {
        Insets insets = ShapeDisplay.getInstance().getInsets();
        maxWidth = ShapeDisplay.getInstance().getWidth() - insets.left - insets.right;
        maxHeight = ShapeDisplay.getInstance().getHeight() - insets.top - insets.bottom;


        // Bounce if we reach the limits
        if (pos.x + direction.x < 0 || pos.x + getWidth() + direction.x >= maxWidth) {
            direction.x = -direction.x;
        }
        if (pos.y + direction.y < 0 || pos.y + getHeight() + direction.y >= maxHeight) {
            direction.y = -direction.y;
        }

        // If we resize the window, we need to update the position
        if (pos.x + getWidth() > maxWidth) {
            pos.x = (int) (maxWidth - getWidth());
            direction.x = -Math.abs(direction.x);
        }
        if (pos.x < 0) {
            pos.x = 0;
            direction.x = Math.abs(direction.x);
        }
        if (pos.y + getHeight() > maxHeight) {
            pos.y = (int) (maxHeight - getHeight());
            direction.y = -Math.abs(direction.y);
        }
        if (pos.y < 0) {
            pos.y = 0;
            direction.y = Math.abs(direction.y);
        }

        // Move the object
        pos.x += direction.x;
        pos.y += direction.y;
    }

    public abstract Color getColor();
    public abstract Shape getShape();
}