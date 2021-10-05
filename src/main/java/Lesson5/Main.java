package Lesson5;

import java.io.*;
import java.util.ArrayList;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        //File zoolist.txt created to be used to read with Reader
        //I want to convert data from file into Array
        ArrayList<ZooList> zooListArrayList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("zoolist.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                zooListArrayList.add(new ZooList(Integer.parseInt(line.split(";")[0]), (line.split(";")[1]),
                        Integer.parseInt(line.split(";")[2]), (line.split(";")[3])));
                out.println(line);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println();
        out.println(zooListArrayList);
        //I want to convert ArrayList into csv file
        try (PrintWriter printWriter = new PrintWriter("zoolist_new.txt")) {
            for (ZooList zooList : zooListArrayList) {
                printWriter.println(zooList);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
