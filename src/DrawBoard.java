import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class DrawBoard {

    private Board board;
    JFrame frame;
    int frameWidth, frameHeight;

    public DrawBoard(Board board) {
        this.board = board;
        frameWidth = 500;
        frameHeight = 500;

        frame = new JFrame();
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void draw() {
        frame.getContentPane().removeAll();
        // ROWS ARE Y AXIS
        // COL ARE X AXIS
        for(int row = 0; row < board.getRowSize(); row++) {
            for(int col = 0; col < board.getColSize(); col++) {
                RectangleComponent square;
                TextComponent letter;
                // if it is an integer make it black
                if((board.getValue(col, row) instanceof Integer)){
                    Color color = Color.black;
                    square = new RectangleComponent(row*45, col*45, 40, 40, color);
                    frame.add(square);
                }

                // if it is not an integer
                else {
                    //square = new RectangleComponent(row*45, col*45, 40, 40, Color.orange);
                    letter = new TextComponent( board.getValue(row, col).toString(),row*45, col*45);
                    //frame.add(square);
                    frame.add(letter);



                }

                frame.setVisible(true);
            }
        }

    }
}