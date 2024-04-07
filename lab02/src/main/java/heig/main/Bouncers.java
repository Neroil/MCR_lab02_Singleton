package heig.main;

import heig.main.FactoryType.BorderShapeFactory;
import heig.main.FactoryType.FilledShapeFactory;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.Timer;

/**
 * The main class.
 * It calls the rendering loop with a timer and contains all the Bounceable and the display used.
 * It's also here that we define what to do when we press keys.
 * Program description:
 * This program allows you to create shapes that bounces on the walls of the window's frame. You can also resize the window
 * and the shapes will adapt to the new size. You can create filled shapes with the 'F' key, border shapes with the 'B'
 * key, clear the screen with the 'E' key and quit the program with the 'Q' key.
 *
 * @author Junod Arthur
 * @author Häffner Edwin
 * @version 1.0
 * @since 2024-03-14
 */
public class Bouncers {
    private static final int NUM_SHAPE_CREATED = 10;
    private static final int MAX_SIZE = 50;
    private static final int MIN_SIZE = 10;
    private static final int TIMER_DELAY = 16;

    private final LinkedList<Bounceable> bouncers;
    private final ShapeDisplay display;
    private final Random random = new Random();

    /**
     * Constructor that setups the display and the KeyEvents.
     */
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


    /**
     * Function that handle the events to call when certain keys are pressed.
     * @param keyCode The code of the key pressed.
     */
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

    /**
     * Create the shape with a random position and random size.
     * @param factory The factory we have to use when creating the shape
     */
    private void generateShapes(ShapeFactory factory) {
        for (int i = 0; i < NUM_SHAPE_CREATED; i++) {
            int size = random.nextInt(MAX_SIZE) + MIN_SIZE;
            int x = random.nextInt(display.getWidth() - size + 1);
            int y = random.nextInt(display.getHeight() - size + 1);
            if (random.nextBoolean()) {
                bouncers.add(factory.createCircle(new Point(x, y), size));
            } else {
                bouncers.add(factory.createSquare(new Point(x, y), size));
            }
        }
    }

    /**
     * This is where the timer used to render the shapes is started and where is defined the rendering loop.
     */
    public void run() {
        // Create a Timer that runs a TimerTask every 1000/60 milliseconds
        new Timer(TIMER_DELAY, e -> {
            display.resetImage();
            for (Bounceable shape : bouncers) {
                shape.move();
                shape.draw();
            }

            display.repaint();
        }).start();
    }


    /**
     * Main function that creates a new Bouncers and runs it.
     * @param args The arguments given to the program (not used here)
     */
    public static void main(String... args) {
        new Bouncers().run();
    }
}
