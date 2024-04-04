package heig.main.ShapeType;

import java.awt.*;

public class FilledSquare extends Square{

    public FilledSquare(Point pos, int side) {
        super(pos, side);
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }
}
