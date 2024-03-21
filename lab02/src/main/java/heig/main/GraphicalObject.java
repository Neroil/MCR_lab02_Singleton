package heig.main;

import java.awt.*;

public abstract class GraphicalObject implements Shape{
    Form form;
    Point pos;
    Point direction; //Mathematical vector
    int speed;

    GraphicalObject(Form form, Point pos){
        this.pos = pos;
        this.form = form;
        this.form.place(pos);
        //Generate a random direction
        direction = new Point((int)(Math.random()*10), (int)(Math.random()*10));
        speed = (int) (Math.random() * 10);
    }

    void drawItself(Graphics2D g){
        g.draw(form.drawShape());
    }
}
