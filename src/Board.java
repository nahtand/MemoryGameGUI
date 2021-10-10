import java.sql.Array;
import java.util.ArrayList;
/*
 * should have 2D array list as private instance variable
 * should have getter method to get value at particular row and column
 * should have setter method to set value at particular row and column
 */
public class Board {
    private ArrayList<ArrayList<Object>> array = new ArrayList<>();

    /**
     * creates a 2d array list using the provided information for the dimensions
     * @param row number of rows in the board
     * @param col number of columns in the board
     */
    public Board(int row, int col) {
        for(int i = 0; i < row; i++) {
            array.add(new ArrayList<>(col));
            for(int j = 0; j < col; j++) {
                array.get(i).add(j, 0);
            }
        }
    }


    public int getRowSize() {
        return array.size();
    }

    public int getColSize() {
        return array.get(0).size();
    }
    /**
     * returns the item at the user specified coordinates
     * @param row the row location of the item
     * @param col the column location of the item
     * @return item at the row and column
     */
    public Object getValue(int row, int col) {
        return array.get(row).get(col);
    }

    /**
     * sets the value at the user specified coordinates to the specified value
     * @param value value that the user wants to set
     * @param row row location that the user wants to use
     * @param col column location that the user wants to use
     */
    public void setValue(Object value, int row, int col) {
        array.get(row).set(col, value);
    }

    public void populateLetters() {
        char letter = 'A';
        for(int row = 0; row < getRowSize(); row++) {
            for(int col = 0; col < getColSize(); col++) {
                setValue(letter, row, col);
                if(col%2 == 1) {
                    letter++;
                }
            }
        }
    }

    public void populateNum() {
        int index = 1;
        for(int row = 0; row < getRowSize(); row++) {
            for(int col = 0; col < getColSize(); col++) {
                setValue(index, row, col);
                index++;
            }
        }

    }

    /**
     * prints the board with each value properly spaced out
     */
    public void print() {
        for (ArrayList<Object> rows : array) {
            for (Object cols : rows) {
                System.out.printf("%5s", cols);
            }
            System.out.println();
        }
        System.out.println();
    }
}
