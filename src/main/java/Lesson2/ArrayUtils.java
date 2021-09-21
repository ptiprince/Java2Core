package Lesson2;


public class ArrayUtils {
    public static int arraySum(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        try {
            if (strings.length != 4) {
                throw new MyArraySizeException(strings.length);
            }
        } catch (MyArraySizeException e) {
            System.out.println("Wrong number of lines!");
        }
        try {
            for (String[] arr : strings) {
                if (arr.length != 4) {
                    throw new MyArraySizeException(arr.length);
                }
            }
        } catch (MyArraySizeException e){
            System.out.println("Wrong number of elements!");
        }
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    sum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] strings = { {"5", "6", "5", "6"},
                {"8", "7", "8", "7"},
                {"2","3", "4", "5"},
                {"5", "4", "3", "2"}};
        System.out.println(arraySum(strings));

        String[][] strings2 = { {"5", "6", "5", "6"},
                {"8", "7", "8", "7", "8"},
                {"2","3", "4", "5", "6"},
                {"5", "4", "3", "2"}};
        System.out.println(arraySum(strings2));
        String[][] strings3 = { {"5", "6", "5", "6"},
                {"8", "I", "8", "7"},
                {"2","3", "4", "5"},
                {"5", "4", "3", "2"}};
        System.out.println(arraySum(strings3));
        String[][] strings4 = { {"5", "6", "5", "6"},
                {"8", "7", "8", "7"},
                {"2","3", "4", "5"},
                {"2","3", "4", "5"},
                {"5", "4", "3", "2"}};
        System.out.println(arraySum(strings4));
    }
}