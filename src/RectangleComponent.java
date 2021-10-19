import javax.swing.*;
import java.awt.*;

public class RectangleComponent extends JComponent {
    private int x, y, width, height;
    private java.awt.Color color;

    public RectangleComponent() {
        this(0, 0, 40, 40, Color.red);
    }

    public RectangleComponent(int x, int y, int width, int height, java.awt.Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        /*
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(color);

         */
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle square = new Rectangle(x, y, width, height);
        g2.setColor(color);
        g2.fill(square);
        g2.draw(square);
    }

    /*
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

     */
}
