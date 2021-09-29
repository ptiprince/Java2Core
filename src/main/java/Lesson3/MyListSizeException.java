package Lesson3;

public class MyListSizeException extends Throwable {
    public MyListSizeException(int i){
        super("The list is empty");
    }
}
