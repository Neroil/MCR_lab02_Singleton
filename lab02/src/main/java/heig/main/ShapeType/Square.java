package heig.main.ShapeType;
import heig.main.BounceableObject;

import java.awt.*;

public abstract class Square extends BounceableObject {
    private final int side;

    public Square(Point pos, int side){
        super(pos);
        this.side = side;
    }

    @Override
    public Shape getShape() {
        return new Rectangle(pos.x,pos.y,side,side);
    }

    public double getHeight(){
        return side;
    }

    public double getWidth(){
        return side;
    }
}