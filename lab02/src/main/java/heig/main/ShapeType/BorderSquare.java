package heig.main.ShapeType;

import javax.swing.text.Position;
import java.awt.*;

public class BorderSquare extends Square{

    BorderSquare(Point pos, int side){super(pos, side);}

    @Override
    public void draw() {

    }



    @Override
    public Color getColor() {
        return Color.RED;
    }
}
