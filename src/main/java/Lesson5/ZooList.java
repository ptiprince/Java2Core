package Lesson5;

import java.io.Serializable;

public class ZooList implements Serializable {
    private int number;
    private String name;
    private int quantity;
    private String type;

    public ZooList(int number, String name, int quantity, String type) {
        this.number = number;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "#: " + getNumber() + "; type: " + getType() + "; animal: " + getName() + "; quantity: " + getQuantity();
    }
}
