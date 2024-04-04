package heig.main;

import heig.main.ShapeType.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.Timer;


public class Bouncers {
    private final LinkedList<Bounceable> bouncers;
    private final JPanel panel;
    private final ShapeDisplay display;

    public Bouncers() {
        bouncers = new LinkedList<>();
        display = ShapeDisplay.getInstance();

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                // Create an off-screen image for double buffering
                Image offScreenImage = createImage(getWidth(), getHeight());
                Graphics offScreenGraphics = offScreenImage.getGraphics();

                // Clear the off-screen image
                super.paintComponent(offScreenGraphics);

                // Draw the shapes on the off-screen image
                for (Bounceable shape : bouncers) {
                    ((BounceableObject)shape).setGraphics(offScreenGraphics);
                    shape.draw();
                }

                // Copy the off-screen image to the screen
                g.drawImage(offScreenImage, 0, 0, this);

                // Dispose the off-screen graphics to free up system resources
                offScreenGraphics.dispose();
            }
        };

        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(600, 600);
        display.add(panel);
        display.setVisible(true);
        panel.setDoubleBuffered(true);
        panel.setBackground(Color.WHITE);
        panel.setOpaque(false);

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
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int size = random.nextInt(50) + 10;
            int x = random.nextInt(display.getWidth() - size);
            int y = random.nextInt(display.getHeight() - size);
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
            for (Bounceable shape : bouncers) {
                shape.move();
            }
            panel.repaint();
        }).start();
    }


    public static void main(String... args) {
        new Bouncers().run();
    }
}
