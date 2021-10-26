package Lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

//There is the main homework; the rest of classes added for the practice.
public class ZooData {
    private String[] header;
    private Integer[][] data;

    public ZooData() {
        header = new String[]{"Value1", "Value2", "Value3"};
        data = new Integer[][]{{100, 200, 300}, {400, 500, 600}, {700, 800, 900}};
    }

    public void saveData(String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
        bufferedWriter.write(lineConvertToString(header));
        for (Integer[] array : data){
            bufferedWriter.write(lineConvertToString(array));
        }
        bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> String lineConvertToString(T[] line){
       String result = "";
       for (int i = 0; i < line.length; i++){
           if (i < line.length - 1){
               result = result + line[i] + ";";
           } else {
               result = result + line[i];
           }
       }
       result += "\n";
       return result;
    }

     public void loadZooData(String fileName){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
           header = bufferedReader.readLine().split(";");
           String line;
            ArrayList<Integer[]> arrayList = new ArrayList<>();
           while ((line = bufferedReader.readLine()) != null){
            arrayList.add(stringToIntArray(line));
           }
          data = arrayList.toArray(new Integer[][]{});
        }catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }

     private Integer[] stringToIntArray(String str){
        String[] strinrArray = str.split(";");
        Integer[] intArray = new Integer[strinrArray.length];
        for (int i = 0; i < strinrArray.length; i++){
            intArray[i] = Integer.parseInt(strinrArray[i]);
        }
       return intArray;
     }

    public static void main(String[] args) {
        ZooData zooData = new ZooData();
        zooData.saveData("test.csv");
        zooData.loadZooData("test.csv");
        System.out.println(Arrays.toString(zooData.header));
        System.out.println(Arrays.deepToString(zooData.data));
    }
}
