package Lesson2;

public class MyArraySizeException extends Exception{
    public MyArraySizeException(int i){
        super("Wrong number of elements in line " + i);
    }
}
