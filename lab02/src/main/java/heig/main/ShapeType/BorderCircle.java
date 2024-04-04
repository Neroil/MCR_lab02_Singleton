package heig.main.ShapeType;

import java.awt.*;

public class BorderCircle extends Circle{

    public BorderCircle(Point pos, int diameter){
        super(pos,diameter);
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
