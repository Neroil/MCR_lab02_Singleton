package heig.main;

import java.awt.*;


//Creer shape à la volée lorsqu'on fait un appel à draw -> return un graphicalAWTObject
public interface Bounceable {
    void draw();
    void move();
    Color getColor();
    Shape getShape();
}
