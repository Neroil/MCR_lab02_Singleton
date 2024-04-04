package heig.main;

import heig.main.ShapeType.Circle;
import heig.main.ShapeType.Square;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class ShapeDisplay extends JFrame implements Displayer {
    private static ShapeDisplay instance;

    public static ShapeDisplay getInstance() {
        if (instance == null) {
            instance = new ShapeDisplay();
        }
        return instance;
    }

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private ShapeDisplay(){
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new BorderLayout());
        addKeyListener(new KeyAdapter() {
        });
        setVisible(true);
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
    }

    @Override
    public void setTitle(String title){
        super.setTitle(title);
    }
}