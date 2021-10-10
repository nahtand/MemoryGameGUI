/*
 * has static method that takes 3 parameters: value, rowSize, and colSize,
 * returns a pair containing the row and col that coresponds to the int value
 */
public class RowColConverter {

    public RowColConverter() {

    }

    public static Pair convert(int value, int rowSize, int colSize) {
        int row = (value-1)/rowSize;
        int col = (value-1)%colSize;
        Pair coord = new Pair(row, col);
        return coord;
    }
}
