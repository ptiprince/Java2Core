package Lesson3;

// #1 I swap all odds and even elements.

import Lesson2.MyArraySizeException;

import java.util.Arrays;

public class Main {
    public static void swapArrayElements(Object[] array) {
        Object tempJ;
        for (int j = 1; j < array.length; j += 2) {
            tempJ = array[j - 1];
            array[j - 1] = array[j];
            array[j] = tempJ;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) throws MyArraySizeException {
        String[] array = {"live", "I", "New York", "in"};
        swapArrayElements(array);
        System.out.println();
        Box<Apple> appleBox = new Box<>();
        appleBox.addProperFruit(new Apple());
        appleBox.addProperFruit(new Apple());
        appleBox.addProperFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addProperFruit(new Apple());
        appleBox2.addProperFruit(new Apple());
        appleBox2.addProperFruit(new Apple());
        appleBox2.addProperFruit(new Apple());

        System.out.println(appleBox.compareWeight(appleBox2));
        System.out.println();
        appleBox.pourFruits(appleBox2);
        System.out.println(appleBox);
        System.out.println(appleBox2);
        System.out.println();
        System.out.println(appleBox.getBoxWeight());
        System.out.println();

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addProperFruit(new Orange());
        orangeBox.addProperFruit(new Orange());
        orangeBox.addProperFruit(new Orange());

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addProperFruit(new Orange());
        orangeBox2.addProperFruit(new Orange());
        orangeBox2.addProperFruit(new Orange());

        System.out.println(orangeBox.compareWeight(orangeBox2));
        System.out.println();
        orangeBox.pourFruits(orangeBox2);
        System.out.println(orangeBox);
        System.out.println(orangeBox2);
        System.out.println();
        System.out.println(orangeBox.getBoxWeight());
        System.out.println();

    }
}
