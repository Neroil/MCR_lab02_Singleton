package heig.main;

import heig.main.ShapeType.Circle;
import heig.main.ShapeType.Square;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class ShapeDisplay implements Displayer {
    private static ShapeDisplay instance;
    private final JFrame frame = new JFrame();
    private Image image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public static ShapeDisplay getInstance() {
        if (instance == null) {
            instance = new ShapeDisplay();
        }
        return instance;
    }

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private ShapeDisplay(){
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(getGraphics());
                g.drawImage(image, 0, 0, this);
            }

        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setContentPane(panel);
        frame.setVisible(true);
        panel.setBackground(Color.WHITE);

        //To not have flickering
        panel.setOpaque(false);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }

    public void addKeyListener(KeyAdapter keyAdapter){
        frame.addKeyListener(keyAdapter);
    }

    @Override
    public int getWidth() {
        return frame.getContentPane().getWidth();
    }

    @Override
    public int getHeight() {
        return frame.getContentPane().getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }

    @Override
    public void repaint() {
        frame.repaint();
    }

    @Override
    public void setTitle(String title){
        frame.setTitle(title);
    }
}