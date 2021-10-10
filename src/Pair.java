/*
 * should have two member values row and col
 * should have getters and setters
 */
public class Pair {
    private int row;
    private int col;

    public Pair(int row, int col) {
        setRow(row);
        setCol(col);
    }

    public Pair() {}

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
