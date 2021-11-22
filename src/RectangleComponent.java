import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RectangleComponent extends JComponent {
    private int x, y, xBoardPos, yBoardPos,  width, height;
    private Board answerKey;
    private java.awt.Color color;

    public RectangleComponent() {
    }

    public RectangleComponent(int x, int y, int offset, int width, int height, Board answerKey, java.awt.Color color) {
        this.x = x;
        this.y = y;
        this.xBoardPos = x*offset;
        this.yBoardPos = y*offset;
        this.width = width;
        this.height = height;
        this.answerKey = answerKey;
        this.color = color;
    }


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle square = new Rectangle(xBoardPos, yBoardPos, width, height);
        g2.setColor(color);
        g2.fill(square);
        g2.draw(square);


    }


}
