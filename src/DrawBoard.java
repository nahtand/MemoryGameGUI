import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class DrawBoard {

    private Board board;
    private Board answerKey;
    private JFrame frame;
    private ColorLibrary colorLibrary;
    private int frameWidth, frameHeight;
    private ArrayList<Object> pressedSquares;
    private ArrayList<Pair> pressedCoord;
    private ArrayList<Integer> pressedValues;

    public DrawBoard(Board board, Board answerKey) {
        this.board = board;
        this.answerKey = answerKey;
        frameWidth = 285;
        frameHeight = 308;

        frame = new JFrame("Memory Game");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // all these array lists needed for the button pressing opperation and checking if buttons pressed match
        colorLibrary = new ColorLibrary();
        pressedSquares = new ArrayList<>();
        pressedCoord = new ArrayList<>();
        pressedValues = new ArrayList<>();
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
                    square = new RectangleComponent(col, row, 45, 40, 40, answerKey, color);

                    square.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int r = e.getPoint().y / 45;
                            int c = e.getPoint().x / 45;

                            // if user presses on a colored square
                            if(board.getValue(r, c) instanceof Character) {
                                return;
                            }

                            int oldValue = (int) board.getValue(r, c);
                            Object letter = answerKey.getValue(r, c);
                            Pair coord = new Pair(r, c);



                            //changes value to whatever is on that square otherwise
                            board.setValue(letter, r, c);
                            draw();

                            //adds values and other important information to array lists that can be refferenced later
                            //after loop is done
                            pressedSquares.add(letter) ;
                            pressedCoord.add(coord);
                            pressedValues.add(oldValue);
                            System.out.println(pressedSquares);

                        }
                    });

                    frame.add(square);
                }

                // if it is not an integer, it makes it a colored square
                else {
                    square = new RectangleComponent( col, row, 45, 40, 40, answerKey, colorLibrary.getColor(board.getValue(row, col), 65));
                    frame.add(square);
                }

                // checks if 2 current colored squares are matching, if not they reset back to black
                if(pressedSquares.size() == 2) {
                    if(!pressedSquares.get(0).equals(pressedSquares.get(1))) {
                        board.setValue(pressedValues.get(0), pressedCoord.get(0).getRow(), pressedCoord.get(0).getCol());
                        board.setValue(pressedValues.get(1), pressedCoord.get(1).getRow(), pressedCoord.get(1).getCol());

                    }
                    // clears arrays so that it can only check 2 items
                    pressedSquares.clear();
                    pressedCoord.clear();
                    pressedValues.clear();
                }


                frame.setVisible(true);

            }
        }

    }
}