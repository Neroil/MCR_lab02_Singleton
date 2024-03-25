package heig.main;

import java.awt.*;

public class GraphicalObject {
    Form form;
    Point pos;
    Point direction; //Mathematical vector
    int speed;

    GraphicalObject(Form form, Point pos){
        this.pos = pos;
        this.form = form;
        this.form.place(pos);
        //Generate a random direction
        direction = new Point((int)(Math.random()*10)+1, (int)(Math.random()*10)+1);
        speed = (int) (Math.random() * 10);
    }

    void drawItself(Graphics2D g){
        g.setColor(form.getColor());
        g.fill(form.drawShape());
    }

    public void moveAndBounce(int maxWidth, int maxHeight) {
        Dimension size = form.getSize();

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

        pos.x += direction.x;
        pos.y += direction.y;
        form.place(pos);
    }
}
