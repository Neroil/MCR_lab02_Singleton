package heig.main.ShapeType;
import heig.main.BounceableObject;

import java.awt.*;

public abstract class Square extends BounceableObject {
    private int side;

    public Square(Point pos, int side){
        super(pos);
        this.side = side;
    }
}