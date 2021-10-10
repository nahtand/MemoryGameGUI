/*
 * will have static method that will have a Board object as a parameter and shuffles its contents
 */
public class Shuffler {

    public static Board shuffle(Board b) {
        int totalSize = b.getColSize() * b.getRowSize();
        for(int i = 0; i < totalSize; i++) {
            int rowSize = b.getRowSize();
            int colSize = b.getColSize();

            // first set of coordinates
            int row = (int) (Math.random() * rowSize);
            int col = (int) (Math.random() * colSize);

            // second set of coordinates
            int row1 = (int) (Math.random() * rowSize);
            int col1 = (int) (Math.random() * colSize);

            Object temp = b.getValue(row, col);
            b.setValue(b.getValue(row1, col1), row, col);
            b.setValue(temp, row1, col1);
        }

        return b;
    }

}
