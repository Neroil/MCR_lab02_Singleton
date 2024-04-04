package heig.main;



import heig.main.ShapeType.BorderCircle;
import heig.main.ShapeType.BorderSquare;

import java.awt.*;

public class BorderShapeFactory implements ShapeFactory {

    private static BorderShapeFactory instance;

    private BorderShapeFactory() {}

    public static BorderShapeFactory getInstance() {
        if (instance == null) {
            instance = new BorderShapeFactory();
        }
        return instance;
    }

    @Override
    public Bounceable createCircle(Point pos, int size) {
        return new BorderCircle(pos, size);
    }

    @Override
    public Bounceable createSquare(Point pos, int size) {
        return new BorderSquare(pos, size);
    }

}
