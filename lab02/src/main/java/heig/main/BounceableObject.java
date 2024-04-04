package heig.main;

import java.awt.*;

public abstract class BounceableObject implements Bounceable {
    protected Point pos;
    Point direction; //Mathematical vector
    protected Dimension size;
    protected int maxWidth;
    protected int maxHeight;

    protected BounceableObject(Point pos){
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
        //Bounce if we reach the limits
        if (pos.x + direction.x < 0 || pos.x + size.width + direction.x > maxWidth) {
            direction.x = -direction.x;
        }
        if (pos.y + direction.y < 0 || pos.y + size.height + direction.y > maxHeight) {
            direction.y = -direction.y;
        }
        //If we resize the window, we need to update the position
        if (pos.x + size.width > maxWidth) {
            pos.x = maxWidth - size.width;
            direction.x = -Math.abs(direction.x);
        }

        if (pos.x < 0) {
            pos.x = 0;
            direction.x = Math.abs(direction.x);
        }
        if (pos.y + size.height > maxHeight) {
            pos.y = maxHeight - size.height;
            direction.y = -Math.abs(direction.y);
        }
        if (pos.y < 0) {
            pos.y = 0;
            direction.y = Math.abs(direction.y);
        }

        //Move the object
        pos.x += direction.x;
        pos.y += direction.y;
        form.place(pos);
    }
}
