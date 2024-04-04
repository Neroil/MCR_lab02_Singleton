package heig.main.ShapeType;

import javax.swing.text.Position;
import java.awt.*;

public class BorderSquare extends Square{

    public BorderSquare(Point pos, int side){
        super(pos, side);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

}
