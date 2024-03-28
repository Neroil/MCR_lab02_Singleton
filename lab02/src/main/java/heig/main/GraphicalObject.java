package heig.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalObject {
    Form form;
    Point pos;
    Point direction; //Mathematical vector
    int speed;

    private BufferedImage shapeImage;

    GraphicalObject(Form form, Point pos) {
        this.pos = pos;
        this.form = form;
        this.form.place(pos);
        //Generate a random direction
        direction = new Point((int)(Math.random()*10)+1, (int)(Math.random()*10)+1);
        speed = (int) (Math.random() * 10);
        createShapeImage(form);
    }

    private void createShapeImage(Form form) {
        Dimension size = form.getSize();
        shapeImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = shapeImage.createGraphics();
        g2d.setColor(form.getColor());
        g2d.fill(form.drawShape());
        g2d.dispose();
    }

    void drawItself(Graphics2D g) {
        g.drawImage(shapeImage, pos.x, pos.y, null);
    }

    public void moveAndBounce(int maxWidth, int maxHeight, Point windowLocation) {
        Dimension size = form.getSize();

        // Adjust the maximum width and height based on the window's location
        maxWidth += windowLocation.x;
        maxHeight += windowLocation.y;

        // Bounce if we reach the limits
        if (pos.x + direction.x < windowLocation.x || pos.x + size.width + direction.x > maxWidth) {
            direction.x = -direction.x;
        }
        if (pos.y + direction.y < windowLocation.y || pos.y + size.height + direction.y > maxHeight) {
            direction.y = -direction.y;
        }

        // If we resize the window, we need to update the position
        if (pos.x + size.width > maxWidth) {
            pos.x = maxWidth - size.width;
            direction.x = -Math.abs(direction.x);
        }
        if (pos.x < windowLocation.x) {
            pos.x = windowLocation.x;
            direction.x = Math.abs(direction.x);
        }
        if (pos.y + size.height > maxHeight) {
            pos.y = maxHeight - size.height;
            direction.y = -Math.abs(direction.y);
        }
        if (pos.y < windowLocation.y) {
            pos.y = windowLocation.y;
            direction.y = Math.abs(direction.y);
        }

        // Move the object
        pos.x += direction.x;
        pos.y += direction.y;
        form.place(pos);
    }
}
