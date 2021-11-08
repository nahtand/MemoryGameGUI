import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Random;

public class DrawBoard {

    private Board board;
    private JFrame frame;
    private ColorLibrary colorLibrary;
    private int frameWidth, frameHeight;

    public DrawBoard(Board board) {
        this.board = board;
        frameWidth = 500;
        frameHeight = 500;

        frame = new JFrame();
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        colorLibrary = new ColorLibrary();
    }


    public void draw() {
        frame.getContentPane().removeAll();
        // ROWS ARE X AXIS
        // COL ARE Y AXIS
        for(int row = 0; row < board.getRowSize(); row++) {
            for(int col = 0; col < board.getColSize(); col++) {
                RectangleComponent square;
                // if it is an integer make it black
                if((board.getValue(row, col) instanceof Integer)){
                    Color color = Color.black;
                    square = new RectangleComponent(col*45, row*45, 40, 40, color);
                    frame.add(square);
                }

                // if it is not an integer, it makes it a colored square
                else {
                    square = new RectangleComponent( col*45, row*45, 40, 40, colorLibrary.getColor(board.getValue(row, col), 65));
                    frame.add(square);
                }

                frame.setVisible(true);
            }
        }
    }
}