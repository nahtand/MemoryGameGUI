import java.awt.*;
import java.util.ArrayList;

// creates a library of 26 colors to be used with the 26 letters of the alphabet
public class ColorLibrary {
    private ArrayList<Color> colorList;

    public ColorLibrary() {
        colorList = new ArrayList<>();
        //initializes array list with random colors
        //index 0 coresponds to A, 1 coresponds to B, etc
        for(int i = 0; i < 26; i++) {
            colorList.add(randomColor());
        }
    }

    // generates a random color
    public Color randomColor() {
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B = (int)(Math.random()*256);
        return new Color(R, G, B);
    }

    // add color to whatever index you want to add it to
    public void addColor(Color color, int index) {
        colorList.add(index, color);
    }

    // gets a color from the list which coresponds to the letter provided
    public Color getColor(Object code, int offset) {
        //turns object (what should be a string) into type string then turns into character
        char letter = code.toString().charAt(0);
        //gets ascii value of string and subtracts it by an offset
        //the offset should make it so that the index can be used with the 26 letters of the alphabet
        //for instance if the ascii value is 65 (char A) then the offset should be 65 to make it index of 0
        int index = ((int)letter) - offset;
        return colorList.get(index);
    }
}
