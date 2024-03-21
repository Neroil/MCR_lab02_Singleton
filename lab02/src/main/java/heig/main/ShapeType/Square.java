package heig.main.ShapeType;
import heig.main.Form;

import java.awt.*;

public class Square extends Rectangle implements Form{
    public Square(int side) {
        super(side, side);
    }

    @Override
    public Shape drawShape() {
        return this;
    }

    @Override
    public void place(Point loc) {
        this.setLocation(loc);
    }

}
