package heig.main;


import java.awt.*;

public interface Form {
    Shape drawShape();

    void place(Point loc);

    Dimension getSize();

    Color getColor();
}
