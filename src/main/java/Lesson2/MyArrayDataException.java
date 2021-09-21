package Lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super("There is a mistake in element [" + i + "] [" + j + "].");
    }
}
