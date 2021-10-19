import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class TextComponent extends JComponent {
    private String text;  // text that will be drawn
    private int x, y;  // x and y that things will be drawn at

    public TextComponent(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;

    }


    public void paintComponent(Graphics g) {
        if (g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.drawString(text, x, y);
        }
    }

    public String getText() {
        return text;
    }


}
