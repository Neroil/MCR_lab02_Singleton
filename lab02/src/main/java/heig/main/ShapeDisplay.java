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
    private final List<BounceableObject> shapes = new ArrayList<>();
    private final Random random = new Random();

    public static ShapeDisplay getInstance() {
        if (instance == null) {
            instance = new ShapeDisplay();
        }

        return instance;
    }

    private ShapeDisplay() {
        initShapes();
        startTimer();
    }

    private void initShapes() {
        for (int i = 0; i < 10; i++) {
            //Figure out why the shapes are not centered
            int x = this.getWidth() / 2;
            int y = this.getHeight() / 2;
            if (random.nextBoolean()) {
                shapes.add(new BounceableObject(new Circle(random.nextInt(50) + 10, new Point(x, y)), new Point(x, y)));
            } else {
                shapes.add(new BounceableObject(new Square(random.nextInt(50) + 10, new Point(x, y)), new Point(x, y)));
            }
        }
    }

    private void startTimer() {
        new Timer(16, e -> {
            for (BounceableObject shape : shapes) {
                shape.moveAndBounce(getWidth(), getHeight());
            }
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (BounceableObject shape : shapes) {
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