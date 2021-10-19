import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawBoard {

    private Board board;
    JFrame frame;
    //GridLayout grid;
    //JPanel panel;
    int frameWidth, frameHeight;
    int rowSize, colSize;
    int cellWidth, cellHeight;
    int xOffset, yOffset;
    ArrayList<RectangleComponent> rectangles;

    //Constructor take the board that it will contiously draw
    public DrawBoard(Board board) {


        this.board = board;

        frameWidth = 500;
        frameHeight = 500;

        rowSize = board.getRowSize();
        colSize = board.getColSize();

        cellWidth = frameWidth / rowSize;
        cellHeight = frameHeight / colSize;

        xOffset = cellWidth/2;
        yOffset = cellHeight/2;

        frame = new JFrame();
        frame.setSize(frameWidth, frameHeight);

        //grid = new GridLayout(rowSize, colSize);
        //panel = new JPanel(grid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rectangles = new ArrayList<RectangleComponent>();


    }

//    //Maps a char value to a color
//    Color getColor(char code) {
//        //I used the ascii value of the parameter to hash rgb values and create a color
//        //you can hard code color values and use a switch as well
//    }

    public void draw() {
        //This is how you clear content from your frame.
        //You should do this each time you need to draw your board.
        frame.getContentPane().removeAll();


        // Your code to draw the board should go here
        // You should loop through the board and determine
        // when you should draw a RectangleComponent vs. a TextComponent
        int i = 0;
        for(int row = 0; row < board.getRowSize(); row++) {
            for(int col = 0; col < board.getColSize(); col++) {

                TextComponent text = new TextComponent(board.getValue(row, col).toString(), col * cellWidth + xOffset, row * cellHeight + yOffset);

                //panel.add(text);
                frame.add(new RectangleComponent((col * cellWidth), (row * cellHeight), cellWidth - 10, cellHeight- 10, Color.orange));
                frame.add(text);
                //frame.add(new RectangleComponent( col, row, 100, 100, Color.orange));


                i++;
                frame.setVisible(true);

            }

        }


        //frame.getContentPane().add(panel);
        frame.setVisible(true);


        //This is how you redraw items added to your frame
        frame.validate();
        frame.repaint();

    }
}