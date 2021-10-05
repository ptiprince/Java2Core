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

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getNumber() + "; " + getType() + "; " + getName() + "; " + getQuantity();
    }
}
