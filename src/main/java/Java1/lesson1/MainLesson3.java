package Java1.lesson1;

import java.util.Arrays;

public class MainLesson3 {
    public static void main(String[] args) {
        int[] task1 = {1, 1, 0, 0, 1, 0, 0, 1};
        System.out.println(Arrays.toString(task1));
        arrayZeroOne(task1);
        System.out.println(Arrays.toString(task1));
        System.out.println();
        int[] task2 = new int[100];
        arrayHundreed(task2);
        System.out.println(Arrays.toString(task2));
        System.out.println();
        int[] task3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(task3));
        arrayMultiplication(task3);
        System.out.println(Arrays.toString(task3));
        System.out.println();
        int[][] task4 = new int [4][4];
        arrayDiagonal(task4);
        System.out.println();
        arrInitialValue(5,7);
        System.out.println();
        int[] task6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrayMinMax(task6);
        System.out.println();
        int[] task7 = {2, 2, 2, 1, 2, 2, 10, 3};
        checkEqualSum(task7);
    }

    public static void arrayZeroOne(int[] in) {
        for (int i = 0; i < in.length; i++) {
            if(in[i]==1){
                in[i]= 1-in[i];
            }else {
                in[i]=1;
            }
        }
    }

    public static void arrayHundreed(int[] in) {
        for (int i = 0; i < in.length; i++) {
            in[i] = i + 1;
        }
    }
    public static void arrayMultiplication(int[] in) {
        for (int i = 0; i < in.length; i++) {
            if(in[i] < 6){
                in[i]= in[i] * 2;
            }
        }
    }
    public static void arrayDiagonal(int[][] in) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                int sum = i + j;
                if (sum == in.length - 1) {
                    in[i][j] = 1;
                } else if (i == j) {
                    in[i][j] = 1;
                } else {
                    in[i][j] = 5;
                }
                System.out.print(in[i][j] + " " );
            }
            System.out.println();
        }
    }

    public static int[] arrInitialValue (int len, int initialValue) {
        int task5[] = new int [len];
        for (int i=0; i < task5.length; i++){
            task5[i] = initialValue;
        }
        System.out.println(Arrays.toString(task5));
        return task5;
    }
    public static void arrayMinMax(int[] in) {
        int min = in[0]; int max=in[0];
        for (int i=0; i<in.length; i++){
            if(min>in[i]){
                min = in[i];
            }
            if(max < in[i]){
                max = in[i];
            }
        }
        System.out.println(min);
        System.out.println(max);
    }

    public static boolean checkEqualSum(int[] in) {
        int leftSum = 0;
        for(int i=0; i<in.length; i++){
            leftSum += in[i];
            int rightSum = 0;
            for(int j=0; j<in.length; j++){
                rightSum += (j>i)? in[j] :0;
            }
            if (leftSum == rightSum){
                System.out.println(true);
                return true;
            }
        }
        System.out.println(false);
        return false;
    }
}
