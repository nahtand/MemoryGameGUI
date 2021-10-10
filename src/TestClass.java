public class TestClass {
    public static void main(String[] args) {
        Board array1 = new Board(10, 10);
        array1.print();
        array1.setValue(10, 2, 2);
        array1.print();
        System.out.println(array1.getValue(2, 2));

    }
}
