package heig.main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true"); // Enable hardware acceleration

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(ShapeDisplay.getInstance());
        frame.setVisible(true);
    }
}