import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    class BoardMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getComponent().getBounds().contains(e.getPoint())) {
                coord.x = ((RectangleComponent) e.getComponent()).getx()/45;
                coord.y = (RectangleComponent) e.getComponent()).gety()/45;

            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

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

    //Maps a char value to a color
    Color getColor(char code) {
        //I used the ascii value of the parameter to hash rgb values and create a color
        //you can hard code color values and use a switch as well
        int r = 0, g = 0, b = 0;
        if(((int) code) % 3 == 0);
    }

    public void draw() {
        //This is how you clear content from your frame.
        //You should do this each time you need to draw your board.
        frame.getContentPane().removeAll();


        // Your code to draw the board should go here
        // You should loop through the board and determine
        // when you should draw a RectangleComponent vs. a TextComponent
        for(int row = 0; row < board.getRowSize(); row++) {
            for(int col = 0; col < board.getColSize(); col++) {
                RectangleComponent s;
                if((int) board.getValue(col, row).getCharacter()) {
                    Color color = getColor(board.getValue(col, row).getCharacter());
                    s = new RectangleComponent(row*45, col*45, 40, 40, color);
                    s.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            super.mousePressed(e);
                        }
                    });

                }
                else {
                    s = new RectangleComponent(row*45, col*45, 40, 40, color);

                }
                frame.add(s);
                frame.setVisible(true);

                TextComponent text = new TextComponent(board.getValue(row, col).toString(), col * cellWidth + xOffset, row * cellHeight + yOffset);

                //panel.add(text);
                frame.add(new RectangleComponent((col * cellWidth), (row * cellHeight), cellWidth - 10, cellHeight- 10, Color.orange));
                frame.add(text);
                //frame.add(new RectangleComponent( col, row, 100, 100, Color.orange));


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