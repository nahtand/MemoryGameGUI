import java.util.Scanner;
/*
 * will have private Scanner variable
 * method get input that returns a pair object containing the row and column values entered by user
 */
public class Input {
    private Scanner userInput = new Scanner(System.in);

    public Pair getInput(String message) {
        System.out.println(message);
        Pair response = new Pair();
        response.setCol(userInput.nextInt());
        response.setRow(userInput.nextInt());
        return response;
    }
}
