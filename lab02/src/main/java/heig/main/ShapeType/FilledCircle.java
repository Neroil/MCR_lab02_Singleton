package heig.main.ShapeType;

import heig.main.Renderer;
import heig.main.Renderers.FilledRenderer;

import java.awt.*;

public class FilledCircle extends Circle{

    public FilledCircle(Point pos, double diameter){
        super(pos, diameter);
    }

    @Override
    public Color getColor () {
        return Color.BLUE;
    }

    @Override
    protected Renderer getRenderer() {
        return FilledRenderer.getInstance();
    }
}
