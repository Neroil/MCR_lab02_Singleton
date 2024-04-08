package heig.main.ShapeType;

import heig.main.Renderer;
import heig.main.Renderers.BorderRenderer;

import java.awt.*;

public class BorderSquare extends Square {
    public BorderSquare(Point pos, int side) {
        super(pos, side);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    protected Renderer getRenderer() {
        return BorderRenderer.getInstance();
    }
}
