package Lesson5;

import java.io.*;

public class SerializationClass {
    public static void main(String[] args) {
        File file = new File("zoolist1");

        ZooList zooList = new ZooList(7, "Bear", 2, "predator");
//Examples of serialization/de-serialization
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(zooList);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            ZooList zooList1 = (ZooList) objectInputStream.readObject();
            System.out.println(zooList1);
        } catch (FileNotFoundException exception) {
        exception.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
