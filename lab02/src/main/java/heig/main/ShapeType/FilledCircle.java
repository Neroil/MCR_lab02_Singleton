package heig.main.ShapeType;

import java.awt.*;

public class FilledCircle extends Circle{

    public FilledCircle(Point pos, int diameter){
        super(pos,diameter);
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
