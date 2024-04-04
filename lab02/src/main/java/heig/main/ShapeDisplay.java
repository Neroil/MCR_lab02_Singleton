package heig.main;

import heig.main.ShapeType.Circle;
import heig.main.ShapeType.Square;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ShapeDisplay extends JFrame implements Displayer {
    private static ShapeDisplay instance;

    private final JPanel panel = new JPanel(){
    };

    public static ShapeDisplay getInstance() {
        if (instance == null) {
            instance = new ShapeDisplay();
        }

        return instance;
    }

    private ShapeDisplay() {
        startTimer();
    }

//    private void initShapes() {
//        for (int i = 0; i < 10; i++) {
//            //Figure out why the shapes are not centered
//            int x = this.getWidth() / 2;
//            int y = this.getHeight() / 2;
//            if (random.nextBoolean()) {
//                shapes.add(new BounceableObject(new Circle(random.nextInt(50) + 10, new Point(x, y)), new Point(x, y)));
//            } else {
//                shapes.add(new BounceableObject(new Square(random.nextInt(50) + 10, new Point(x, y)), new Point(x, y)));
//            }
//        }
//    }

//    private void startTimer() {
//        new Timer(16, e -> {
//            for (BounceableObject shape : shapes) {
//                shape.moveAndBounce(getWidth(), getHeight());
//            }
//            repaint();
//        }).start();
//    }



    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) panel.getGraphics();
    }
}