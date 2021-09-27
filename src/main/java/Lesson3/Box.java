package Lesson3;

import Lesson2.MyArraySizeException;

import java.util.ArrayList;
//Creating generic class Box and restrict it by class Fruit above as I'm going to store only Fruit in the Box.
// Using List to simplify and to use methods appropriate to Lists

public class Box<T extends Fruit> {
    private ArrayList<T> fruitsList = new ArrayList<>();

    public ArrayList<T> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(ArrayList<T> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public void addProperFruit(T fruit) {
        fruitsList.add(fruit);
    }
    public float getBoxWeight() throws MyArraySizeException {
        if (fruitsList.size() == 0) {
            throw new MyArraySizeException(0);
        } else {
            return fruitsList.size() * fruitsList.get(0).weight;
        }
    }
    public boolean compareWeight(Box<?> box) throws MyArraySizeException {
        return getBoxWeight() == box.getBoxWeight();
    }
    public void pourFruits(Box<T> box) {
        fruitsList.addAll(box.fruitsList);
        box.fruitsList.clear();
    }

    @Override
    public String toString() {
        return "The list of fruits in the box: {" + fruitsList.toString() +
                '}';
    }
}
