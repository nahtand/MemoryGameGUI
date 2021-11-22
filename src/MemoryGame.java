public class MemoryGame {


    public static void main(String[] args) {
        Board letters = new Board(6, 6);
        Board numbers = new Board(6, 6);
        //DrawBoard lettersGUI = new DrawBoard(letters);

        Shuffler shuffleArray = new Shuffler();
        Input response = new Input();
        RowColConverter converter = new RowColConverter();

        letters.populateLetters();
        Shuffler.shuffle(letters);
        letters.print();

        numbers.populateNum();
        numbers.print();
        DrawBoard numbersGUI = new DrawBoard(numbers, letters);
        numbersGUI.draw();

    }
}
