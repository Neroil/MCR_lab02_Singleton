package heig.main;

import heig.main.ShapeType.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;
import java.util.TimerTask;

public class Bouncers {
    private final LinkedList<Bounceable> bouncers;
    private final JPanel panel;
    private final ShapeDisplay display;
    private final JFrame frame;

    public Bouncers() {
        bouncers = new LinkedList<>();
        display = ShapeDisplay.getInstance();
        frame = ShapeDisplay.getInstance();

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Clear the background
                Graphics2D g2d = (Graphics2D) g;
                for (Bounceable shape : bouncers) {
                    ShapeRenderer.getInstance().display(g2d, shape); // Doesn't work with draw()
                }
            }
        };

        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(600, 600);
        display.add(panel);
        display.setVisible(true);

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
                generateBorderedShapes();
                break;
            case KeyEvent.VK_F:
                generateFilledShapes();
                break;
            case KeyEvent.VK_Q:
                System.exit(0);
                break;
        }
    }

    private void generateBorderedShapes() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int size = random.nextInt(50) + 10;
            int x = random.nextInt(display.getWidth() - size);
            int y = random.nextInt(display.getHeight() - size);
            if (random.nextBoolean()) {
                bouncers.add(new BorderCircle(new Point(x, y), size));
            } else {
                bouncers.add(new BorderSquare(new Point(x, y), size));
            }
        }
    }

    private void generateFilledShapes() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int size = random.nextInt(50) + 10;
            int x = random.nextInt(display.getWidth() - size);
            int y = random.nextInt(display.getHeight() - size);
            if (random.nextBoolean()) {
                bouncers.add(new FilledCircle(new Point(x, y), size));
            } else {
                bouncers.add(new FilledSquare(new Point(x, y), size));
            }
        }
    }

    public void run() {

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'e':
                        bouncers.clear();
                        break;
                    case 'b':
                        generateBorderedShapes();
                        break;
                    case 'f':
                        generateFilledShapes();
                        break;
                    case 'q':
                        System.exit(0);
                        break;
                }
            }
        });

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
