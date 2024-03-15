package heig.main;

import java.awt.*;

public abstract class GraphicalObject extends Shape{
    Form form;
    Point pos;
    Point direction; //Mathematical vector
    int speed;

    GraphicalObject(Form form){
        new GraphicalObject(form,new Point(0,0));
    }

    GraphicalObject(Form form, int x, int y){
        new GraphicalObject(form,new Point(x,y));
    }

    GraphicalObject(Form form, Point pos){
        this.pos = pos;
        //Generate a random direction
        direction = new Point((int)(Math.random()*10), (int)(Math.random()*10));
        speed = (int) (Math.random() * 10);
    }
}
