// ShapeDisplay.java
package heig.main;

import heig.main.ShapeType.Circle;
import heig.main.ShapeType.Square;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapeDisplay extends JPanel implements Displayer {
    private static ShapeDisplay instance;
    private final List<GraphicalObject> shapes = new ArrayList<>();
    private final Random random = new Random();

    public static ShapeDisplay getInstance() {
        if (instance == null) {
            instance = new ShapeDisplay();
        }
        return instance;
    }

    private ShapeDisplay() {}

    @Override
    public void addNotify() {
        super.addNotify();
        initShapes();
        startTimer();
    }

    private void initShapes() {
        for (int i = 0; i < 10; i++) {
            int x = this.getWidth() / 2;
            int y = this.getHeight() / 2;
            if (random.nextBoolean()) {
                shapes.add(new GraphicalObject(new Circle(random.nextInt(50) + 10, new Point(x, y)), new Point(x, y)));
            } else {
                shapes.add(new GraphicalObject(new Square(random.nextInt(50) + 10, new Point(x, y)), new Point(x, y)));
            }
        }
    }

    private void startTimer() {
        new Timer(16, e -> {
            for (GraphicalObject shape : shapes) {
                shape.moveAndBounce(getWidth(), getHeight());
            }
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (GraphicalObject shape : shapes) {
            shape.drawItself(g2d);
        }
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
    }

    @Override
    public void setTitle(String title) {
        TitledBorder border = BorderFactory.createTitledBorder(title);
        this.setBorder(border);
    }
}