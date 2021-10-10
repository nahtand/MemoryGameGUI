public class MemoryGame {


    public static void main(String[] args) {
        Board letters = new Board(6, 6);
        Board numbers = new Board(6, 6);
        Shuffler shuffleArray = new Shuffler();
        Input response = new Input();
        RowColConverter converter = new RowColConverter();

        letters.populateLetters();
        Shuffler.shuffle(letters);
        numbers.populateNum();
        numbers.print();

        do{
            Pair input = response.getInput("enter two numbers");
            Pair num1 = RowColConverter.convert(input.getRow(), 6, 6);
            Pair num2 = RowColConverter.convert(input.getCol(), 6, 6);
            Object letter1 = ""+letters.getValue(num1.getRow(), num1.getCol());
            Object letter2 = ""+letters.getValue(num2.getRow(), num2.getCol());

            numbers.setValue(letter1, num1.getRow(), num1.getCol());
            numbers.setValue(letter2, num2.getRow(), num2.getCol());
            numbers.print();

            if(!letter1.equals(letter2)) {
                numbers.setValue(input.getRow(), num1.getRow(), num1.getCol());
                numbers.setValue(input.getCol(), num2.getRow(), num2.getCol());
            }

            numbers.print();

        } while(true);


    }
}
