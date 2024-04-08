package heig.main.ShapeType;

import heig.main.Renderer;
import heig.main.Renderers.FilledRenderer;

import java.awt.*;

public class FilledSquare extends Square{

    public FilledSquare(Point pos, int side) {
        super(pos, side);
    }

    @Override
    public Color getColor () {
        return Color.YELLOW;
    }

    @Override
    protected Renderer getRenderer() {
        return FilledRenderer.getInstance();
    }
}
