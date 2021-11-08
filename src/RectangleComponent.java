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
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle square = new Rectangle(x, y, width, height);
        g2.setColor(color);
        g2.fill(square);
        g2.draw(square);
    }


}
