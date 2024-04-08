package heig.main.ShapeType;

import heig.main.Renderer;
import heig.main.Renderers.BorderRenderer;

import java.awt.*;

public class BorderCircle extends Circle{

    public BorderCircle(Point pos, double diameter) {
        super(pos, diameter);
    }

        @Override
        public Color getColor () {
        return Color.GREEN;
    }

    @Override
    protected Renderer getRenderer() {
        return BorderRenderer.getInstance();
    }

}

