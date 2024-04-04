package heig.main;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Bouncers {
    private LinkedList<Bounceable> bouncers;

    public Bouncers() {
        bouncers = new LinkedList<>();
        // Create and add instances of FilledSquare to the bouncers list
        bouncers.add(new FilledSquare(50, 50, 50, Color.ORANGE));
        // Add more instances as needed
    }

    public void run() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                for (Bounceable shape : bouncers) {
                    ShapeRenderer.getInstance().display(g2d, shape);
                    shape.move();
                }
                repaint();
            }
        };

        ShapeDisplay frame = ShapeDisplay.getInstance();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String... args) {
        new Bouncers().run();
    }
}
