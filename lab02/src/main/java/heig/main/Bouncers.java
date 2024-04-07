package heig.main;

import heig.main.FactoryType.BorderShapeFactory;
import heig.main.FactoryType.FilledShapeFactory;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.Timer;


public class Bouncers {
    private final LinkedList<Bounceable> bouncers;
    private final ShapeDisplay display;
    private final Random random = new Random();


    public Bouncers() {
        bouncers = new LinkedList<>();
        display = ShapeDisplay.getInstance();
        display.setTitle("Bouncers");

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyCode());
            }
        };

        display.addKeyListener(keyAdapter);
    }



    private void handleKeyPress(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_E:
                bouncers.clear();
                break;
            case KeyEvent.VK_B:
                generateShapes(BorderShapeFactory.getInstance());
                break;
            case KeyEvent.VK_F:
                generateShapes(FilledShapeFactory.getInstance());
                break;
            case KeyEvent.VK_Q:
                System.exit(0);
                break;
        }
    }

    private void generateShapes(ShapeFactory factory) {
        for (int i = 0; i < 10; i++) {
            int size = random.nextInt(50) + 10;
            int x = random.nextInt(display.getWidth() - size + 1);
            int y = random.nextInt(display.getHeight() - size + 1);
            if (random.nextBoolean()) {
                bouncers.add(factory.createCircle(new Point(x, y), size));
            } else {
                bouncers.add(factory.createSquare(new Point(x, y), size));
            }
        }
    }

    public void run() {
        // Create a Timer that runs a TimerTask every 1000/60 milliseconds
        new Timer(16, e -> {
            display.resetImage();
            for (Bounceable shape : bouncers) {
                shape.move();
                shape.draw();
            }

            display.repaint();
        }).start();
    }


    public static void main(String... args) {
        new Bouncers().run();
    }
}
