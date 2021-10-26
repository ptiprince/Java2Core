package Lesson4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] animals = {"Lion", "Bear", "Gorilla", "Hyenna", "Hyenna", "Eagle", "Elephant",
                               "Gorilla", "Bear", "Bear", "Eagle", "Lion", "Owl", "Vulture", "Cheetah",
                                "Giraffe", "Antelope", "Lion", "Cheetah", "Leopard", "Vulture"};
        HashMap<String, Integer> animalsZooList = new HashMap<>();
        HashMap<String, Integer> birdsZooList = new HashMap<>();
        HashMap<String, Integer> herbivorousZooList = new HashMap<>();
        HashMap<String, Integer> predatorZooList = new HashMap<>();

        for (int i = 0; i < animals.length; i++) {
            if (animalsZooList.containsKey(animals[i])) {
                animalsZooList.put(animals[i], animalsZooList.get(animals[i]) + 1);
            } else {
                animalsZooList.put(animals[i], 1);
            }
        }

        //I want to organize 3 different HashMaps for the Zoo using Iterator
        Iterator<Map.Entry<String, Integer>> entryIterator = animalsZooList.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            if (entry.getKey().equals("Eagle") || entry.getKey().equals("Owl") || entry.getKey().equals("Vulture")) {
                birdsZooList.put(entry.getKey(), entry.getValue());
            }else if (entry.getKey().equals("Elephant") || entry.getKey().equals("Giraffe") || entry.getKey().equals("Antelope") || entry.getKey().equals("Gorilla")){
                herbivorousZooList.put (entry.getKey(), entry.getValue());
              } else {
           predatorZooList.put (entry.getKey(), entry.getValue());
           }
        }

        System.out.println("Full list of animals in the Zoo: \n" + animalsZooList);
        System.out.println();
        System.out.println("List of birds " + birdsZooList);
        System.out.println("List of herbivorous " + herbivorousZooList);
        System.out.println("List of predators " + predatorZooList);
        System.out.println();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("9178888889", "Malkovich");
        phoneBook.addContact("2123334455", "Johnson");
        phoneBook.addContact("9295553333", "Hanks");
        phoneBook.addContact("9175551111", "Nicholson");
        phoneBook.addContact("9295552222", "Pitt");
        phoneBook.addContact("6465550000", "Pitt");
        phoneBook.addContact("9175554664", "Peshi");
        phoneBook.addContact("2125554664", "Johnson");
        phoneBook.addContact("9298888800", "Malkovich");

        System.out.println(phoneBook.getPhones("Johnson"));
        System.out.println(phoneBook.getPhones("Pitt"));
        System.out.println(phoneBook.getPhones("Malkovich"));
    }
}
