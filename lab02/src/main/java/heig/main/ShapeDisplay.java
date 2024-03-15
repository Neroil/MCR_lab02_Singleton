package heig.main;

import javax.swing.*;
import java.awt.*;

public class ShapeDisplay extends JFrame implements Displayer{

    private static ShapeDisplay instance;
    private JPanel panel;
    private Image image;

    public static ShapeDisplay getInstance(){
        if(instance == null){
            instance = new ShapeDisplay();
        }
        return instance;
    }

    public void setData(){

    }

    private ShapeDisplay(){
        this.panel = new JPanel(){
            //Override the paint method to draw the shapes maybe
        };
        image = panel.createImage(20, 20);
    }

    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }

    @Override
    public void repaint() {

    }

    @Override
    public void setTitle(String title) {

    }
}
