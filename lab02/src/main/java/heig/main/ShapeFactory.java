package heig.main;

import heig.main.ShapeType.*;

import java.awt.*;

public interface ShapeFactory {

    Bounceable createCircle(Point pos, int size);
    Bounceable createSquare(Point pos, int size);
}
